package com.global.advanced.java.advancedjava;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SpringObjects {

    public static SpringObjects instance;

    @Getter
    private DataSource dataSource;
    @Getter
    private ICdrDao cdrDao;

    @Autowired
    public SpringObjects(final DataSource dataSourceParam,
                         final ICdrDao cdrDaoParam) {
        dataSource = dataSourceParam;
        cdrDao     = cdrDaoParam;
        instance   = this;
    }


    public static SpringObjects getInstance(){
        return instance;
    }


}
