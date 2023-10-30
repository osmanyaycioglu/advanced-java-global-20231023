package com.global.advanced.java.advancedjava.java.enums;

public enum EState implements ILoad {

    BOOTING("Booting System",
            1) {
        @Override
        public String check() {
            return "System check not available.";
        }
    },
    RUNNING("System is running",
            5),
    PAUSED("system paused",
           9),
    STOPPED("Stopped",
            12) {
        @Override
        public String load(final String str) {
            return "System stopped and can not load anything";
        }
    };

    private final String desc;
    private final int    id;

    EState(final String descParam,
           final int idParam) {
        desc = descParam;
        id   = idParam;
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }

    public String check() {
        return "Checking : " + id + "-" + desc;
    }

    @Override
    public String load(final String str) {
        return "Loading : " + str;
    }
}
