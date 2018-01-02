package com.epam.jf.common.lesson26.pool4;

public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 1L;

    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}

