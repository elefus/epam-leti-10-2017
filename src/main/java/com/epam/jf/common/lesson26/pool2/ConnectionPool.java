package com.epam.jf.common.lesson26.pool2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    public static final String PROPERTIES_FILE = "properties/database";
    public static final int DEFAULT_POOL_SIZE = 10;
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connectionQueue;

    private ConnectionPool(String driver, String url, String user, String password, int poolSize) throws ClassNotFoundException, SQLException {
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connectionQueue.offer(DriverManager.getConnection(url, user, password));
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE);
            String driver = rb.getString("db.driver");
            String url = rb.getString("db.url");
            String user = rb.getString("db.user");
            String password = rb.getString("db.password");
            String poolSizeStr = rb.getString("db.poolsize");
            int poolSize = (poolSizeStr != null) ? Integer.parseInt(poolSizeStr) : DEFAULT_POOL_SIZE;
            try {
                instance = new ConnectionPool(driver, url, user, password, poolSize);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static synchronized void dispose() throws SQLException {
        if (instance != null) {
            instance.clearConnectionQueue();
            instance = null;
        }
    }

    public Connection takeConnection() {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                if (!connectionQueue.offer(connection)) {
                    //"Connection not added. Possible `leakage` of
                    // connections"
                }
            } else {
                //"Trying to release closed connection. Possible
                // `leakage` of connections"
            }
        } catch (SQLException e) {
            //"SQLException at conection isClosed () checking.
            // Connection not added", e
        }
    }

    private void clearConnectionQueue() throws SQLException {
        Connection connection;
        while ((connection = connectionQueue.poll()) != null) {
            connection.close();
        }
    }
}
