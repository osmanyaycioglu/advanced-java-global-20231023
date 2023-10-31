package com.global.advanced.java.advancedjava.cdr;

import com.global.advanced.java.advancedjava.ICdrDao;
import com.global.advanced.java.advancedjava.SpringObjects;
import lombok.Data;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CdrDb {
    private CdrList                cdrList;
    private BlockingQueue<CdrList> cdrListQueue = new ArrayBlockingQueue<>(1_000);

    public CdrDb() {
        for (int i = 0; i < 5; i++) {
            DbWriterThread dbWriterThreadLoc = new DbWriterThread(this);
            dbWriterThreadLoc.setName("DBWRITER-" + i);
            dbWriterThreadLoc.start();
        }
    }

    public synchronized void addCdrToBatch(Cdr cdrParam) {
        if (cdrList == null) {
            cdrList = new CdrList();
        }
        cdrList.cdrs.add(cdrParam);
        long delta = System.currentTimeMillis() - cdrList.createDate;
        if (cdrList.cdrs.size() >= 1000 || delta >= 1_000) {

            cdrListQueue.add(cdrList);
            cdrList = new CdrList();
        }
    }

    public synchronized void check() {
        if (cdrList != null) {
            long delta = System.currentTimeMillis() - cdrList.createDate;
            if (delta >= 1_000) {
                cdrListQueue.add(cdrList);
                cdrList = new CdrList();
            }
        }
    }

    @Data
    private static class CdrList implements Iterable<Cdr> {
        private List<Cdr> cdrs       = new ArrayList<>();
        private long      createDate = System.currentTimeMillis();

        @Override
        public Iterator<Cdr> iterator() {
            return cdrs.iterator();
        }

        @Override
        public void forEach(final Consumer<? super Cdr> action) {
            cdrs.forEach(action);
        }

        @Override
        public Spliterator<Cdr> spliterator() {
            return cdrs.spliterator();
        }
    }

    private static class DbWriterThread extends Thread {
        private final       CdrDb      cdrDb;
        private final       DataSource dataSource;
        public static final String     sql = "INSERT INTO cdr ("
                                             + "cdr_id, "
                                             + "msisdn,"
                                             + "cdr_date_in_millis, "
                                             + "call_duration_in_seconds, "
                                             + "cell_id, "
                                             + "call_rate"
                                             + ") VALUES (?,?,?,?,?,?)";

        public DbWriterThread(final CdrDb cdrDbParam) {
            cdrDb      = cdrDbParam;
            dataSource = SpringObjects.getInstance()
                                      .getDataSource();
        }

        public void run2() {
            while (true) {
                CdrList cdrListLoc = null;
                try {
                    cdrListLoc = cdrDb.cdrListQueue.poll(1_000,
                                                         TimeUnit.MILLISECONDS);
                    if (cdrListLoc == null) {
                        cdrDb.check();
                    } else {
                        // Db write
                        try (Connection connectionLoc = dataSource.getConnection();
                             PreparedStatement p = connectionLoc.prepareStatement(sql);
                        ) {
                            connectionLoc.setAutoCommit(false);
                            for (Cdr cdrLoc : cdrListLoc) {
                                p.setString(1,
                                            cdrLoc.getCdrId());
                                p.setString(2,
                                            cdrLoc.getMsisdn());
                                p.setLong(3,
                                          cdrLoc.getCdrDateInMillis());
                                p.setInt(4,
                                         cdrLoc.getCallDurationInSeconds());
                                p.setInt(5,
                                         cdrLoc.getCellId());
                                p.setInt(6,
                                         cdrLoc.getCallRate());
                                p.addBatch();
                            }
                            int[] intsLoc = p.executeBatch();
                            // connectionLoc.commit();
                            System.out.println(intsLoc);
                        } catch (Exception exp) {
                            exp.printStackTrace();
                        }
                    }
                } catch (Exception eParam) {
                    eParam.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            while (true) {
                ICdrDao cdrDaoLoc = SpringObjects.getInstance()
                                                 .getCdrDao();
                CdrList cdrListLoc = null;
                try {
                    cdrListLoc = cdrDb.cdrListQueue.poll(1_000,
                                                         TimeUnit.MILLISECONDS);
                    if (cdrListLoc == null) {
                        cdrDb.check();
                    } else {
                        // Db write
                        try {
                            cdrDaoLoc.saveAll(cdrListLoc);
                        } catch (Exception exp) {
                            exp.printStackTrace();
                        }
                    }
                } catch (Exception eParam) {
                    eParam.printStackTrace();
                }
            }
        }

    }

}
