package com.epam.jf.common.lesson26.pool3;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final String DRIVER_NAME;
    private ArrayList<Connection> freeConnections = new ArrayList<>();
    private String URL;
    private String user;
    private String password;
    private int maxConn;
    private ConnectionPool(String DRIVER_NAME, String URL, String user, String password, int maxConn) {
        this.DRIVER_NAME = DRIVER_NAME;
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
    }

    public static synchronized ConnectionPool getInstance (String driverName, String URL, String user, String password, int maxConn) {
        if (instance == null) {
            instance = new ConnectionPool(driverName, URL, user, password, maxConn);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (!freeConnections.isEmpty()) {
            Connection con = freeConnections.remove(freeConnections.size() - 1);
            try {
                if (con.isClosed()) {
                    return getConnection();
                }
                return con;
            } catch (Exception e) {
                return getConnection();
            }
        } else {
            return newConnection();
        }
    }

    private Connection newConnection() {
        try {
            if (user == null) {
                return DriverManager.getConnection(URL);
            } else {
                return DriverManager.getConnection(URL, user, password);
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public synchronized void freeConnection(Connection con) {
        if ((con != null) && (freeConnections.size() <= maxConn)){
            freeConnections.add(con);
        }
    }

    public synchronized void release() {
        for (Connection con : freeConnections) {
            try {
                con.close();
                // "Closed connection for pool „
            } catch (SQLException e) {
                // "Can't close connection for pool „
            }
        }
        freeConnections.clear();
    }
}
