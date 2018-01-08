package com.epam.jf.common.classwork.lesson8;

import java.util.logging.Logger;

public class InitStaticBlockExample {

    private final static Logger LOG = Logger.getLogger("root");

    static {
        System.out.println(loadConfig());
    }

    public static String value = "String value";

    static {
        System.out.println(InitStaticBlockExample.value);
    }

    public static String loadConfig() {
        LOG.info("Loading config");
        return value;
    }

    public static void main(String[] args) {

    }
}
