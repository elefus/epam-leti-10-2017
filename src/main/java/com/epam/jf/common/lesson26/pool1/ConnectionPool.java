package com.epam.jf.common.lesson26.pool1;

import lombok.experimental.Delegate;

import java.io.Closeable;
import java.sql.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {

    private static final ConnectionPool INSTANCE = new ConnectionPool();
    private List<PooledConnection> freeConnections;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Integer connectionNumber;
    private Semaphore semaphore;
    private static Logger classLogger = Logger.getLogger(ConnectionPool.class.getName());
    private static Logger package1Logger = Logger.getLogger("com.epam.jf.common.classwork.lesson26.pool1");
    private static Logger package2Logger = Logger.getLogger("com.epam.jf.common.classwork.lesson26");
    private static Logger package3Logger = Logger.getLogger("com.epam.jf.common.classwork");
    private static Logger myLogger1 = Logger.getLogger("my.logger_1");
    private static Logger myLogger2 = Logger.getLogger("my.logger_2");
    private static Logger myLogger = Logger.getLogger("my");

    private ConnectionPool() {}

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setConnectionNumber(Integer connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public void initConnections() throws SQLException {
        semaphore = new Semaphore(connectionNumber);
        freeConnections = new LinkedList<>();
        for (int i = 0; i < connectionNumber; i++) {
            Connection connection = DriverManager.getConnection(url, username, password);
            PooledConnection pooledConnection = new PooledConnection(connection);
            freeConnections.add(pooledConnection);
        }
        classLogger.log(Level.INFO, connectionNumber + " connections created");
        classLogger.log(Level.INFO, () -> connectionNumber + " connections created");

        classLogger.info(connectionNumber + " connections created");
    }

    public Optional<Connection> getConnection() {
        try {
            semaphore.acquire();
            return Optional.of(freeConnections.remove(0));
        } catch (InterruptedException ex) {
            classLogger.log(Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }

    public void closeConnections() {
        int releaseNumber = connectionNumber - semaphore.availablePermits();
        semaphore.release(releaseNumber);
    }

    private class PooledConnection implements Connection {

        @Delegate(types = Connection.class, excludes = Closeable.class)
        private Connection connection;

        public PooledConnection(Connection connection) throws SQLException {
            this.connection = connection;
            this.connection.setAutoCommit(true);
        }

        @Override
        public void close() throws SQLException {
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            freeConnections.add(this);
            semaphore.release();
        }
    }
}
