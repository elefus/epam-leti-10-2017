package com.epam.jf.common.lesson26.pool4;

import lombok.experimental.Delegate;

import java.sql.*;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ConnectionPool implements AutoCloseable {

    private static final ConnectionPool INSTANCE = new ConnectionPool();
    private static final int DEFAULT_POOL_SIZE = 5;
    private BlockingQueue<PooledConnection> connectionQueue;
    private BlockingQueue<PooledConnection> givenAwayConQueue;

    private String url;
    private String user;
    private String password;
    private int poolSize;

    private ConnectionPool() {
        DBResourceManager dbResourseManager = DBResourceManager.getInstance();
        this.url = dbResourseManager.getValue(DBParameter.DB_URL);
        this.user = dbResourseManager.getValue(DBParameter.DB_USER);
        this.password = dbResourseManager.getValue(DBParameter.DB_PASSWORD);

        try {
            this.poolSize = Integer.parseInt(dbResourseManager.getValue(DBParameter.DB_POLL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = DEFAULT_POOL_SIZE;
        }
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public synchronized void initPoolData() throws ConnectionPoolException {
        if (connectionQueue != null) {
            try {
                givenAwayConQueue = new ArrayBlockingQueue<>(poolSize);
                connectionQueue = new ArrayBlockingQueue<>(poolSize);
                for (int i = 0; i < poolSize; i++) {
                    Connection connection = DriverManager.getConnection(url, user, password);
                    PooledConnection pooledConnection = new PooledConnection(connection);
                    connectionQueue.add(pooledConnection);
                }
            } catch (SQLException e) {
                throw new ConnectionPoolException("SQLException in ConnectionPool", e);
            }
        } else {
            throw new IllegalStateException("ConnectionPool is already initialized");
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        try {
            PooledConnection connection = connectionQueue.take();
            givenAwayConQueue.add(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to the data source.", e);
        }
    }

    @Override
    public synchronized void close() throws Exception {
        try {
            closeConnectionsQueue(connectionQueue);
        } catch (SQLException e) {
            // logger.log(Level.ERROR, "Error closing the connection.", e);
        }
    }

    private void closeConnectionsQueue(BlockingQueue<PooledConnection> queue) throws SQLException, InterruptedException {
        PooledConnection connection;
        while ((connection = queue.take()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.reallyClose();
        }
    }

    private class PooledConnection implements Connection {

        @Delegate(types = Connection.class, excludes = AutoCloseable.class)
        private Connection connection;

        public PooledConnection(Connection connection) throws SQLException {
            this.connection = connection;
            this.connection.setAutoCommit(true);
        }

        public void reallyClose() throws SQLException {
            connection.close();
        }

        @Override
        public void close() throws SQLException {
            if (connection.isClosed()) {
                throw new SQLException("Attempting to close closed connection.");
            }
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            if (!givenAwayConQueue.remove(this)) {
                throw new SQLException("Error deleting connection from the given away connections pool.");
            }
            if (!connectionQueue.offer(this)) {
                throw new SQLException("Error allocating connection in the pool.");
            }
        }
    }
}
