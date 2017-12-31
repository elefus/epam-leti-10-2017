package com.epam.jf.common.lesson27;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {

    private static final Logger LOG = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        LOG.info("info");
        LOG.warn("warn");
        LOG.warn(() -> "warn from supplier");
        LOG.error("error");
        LOG.fatal("fatal");
    }
}
