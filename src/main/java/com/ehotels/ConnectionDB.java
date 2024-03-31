package com.ehotels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    /* Database connection settings, change dbName, dbusername, dbpassword */
    private final String ipAddress = "localhost";
    private final String dbServerPort = "5432";
    private final String dbName = "eHotels";
    private final String dbusername = "postgres";
    private final String dbpassword = "2132";


    private Connection con = null;

    /**
     * Establishes a connection with the database, initializes and returns
     * the Connection object.
     *
     * @return Connection, the Connection object
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://"
                    + ipAddress + ":" + dbServerPort + "/" + dbName, dbusername, dbpassword);
            return con;
        } catch (Exception e) {

            throw new Exception();
        }

    }

    /**
     * Close database connection. It is very important to close the database connection
     * after it is used.
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            throw new SQLException();
        }

    }
}