package com.javarush.test.level33.lesson15.big01.strategies;

import java.sql.*;

/**
 * Created by ame on 01-Feb-16.
 */
public class SqlLiteDBStorageStrategy implements StorageStrategy {

    private Connection conn;
    private Statement statmt;
    private ResultSet resSet;
    private final String TABLE_NAME = "entries";

    public SqlLiteDBStorageStrategy() {
        try {
            Conn();
            DeleteTable();
            CreateTable();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    private void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:storagestrategydb.s3db");
    }

    private void DeleteTable() throws SQLException {
        statmt = conn.createStatement();
        statmt.execute("DROP TABLE if exists " + TABLE_NAME + ";");
    }

    private void CreateTable() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists " + TABLE_NAME + " (id INTEGER PRIMARY KEY, value text);");
    }

    public void CloseConnections() {
        try {
            statmt.close();
            resSet.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean containsKey(Long key) {
        try {
            resSet = statmt.executeQuery("SELECT id FROM " + TABLE_NAME + " WHERE id LIKE " + key + ";");
            int count = 0;
            while (resSet.next()) {
                count++;
            }
            return count > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        try {
            resSet = statmt.executeQuery("SELECT value FROM " + TABLE_NAME + " WHERE value LIKE '" + value + "';");
            int count = 0;
            while (resSet.next()) {
                count++;
            }
            return count > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        try {
            statmt.execute("INSERT INTO '" + TABLE_NAME + "' ('id', 'value') VALUES ('" + key + "','" + value + "'); ");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getKey(String value) {
        Long result = null;
        if (value != null) {
            try {
                resSet = statmt.executeQuery("SELECT id FROM " + TABLE_NAME + " WHERE value LIKE '" + value + "';");
                while (resSet.next()) {
                    result = resSet.getLong("id");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String getValue(Long key) {
        String result = null;
        if (key != null) {
            try {
                resSet = statmt.executeQuery("SELECT value FROM " + TABLE_NAME + " WHERE id LIKE '" + key + "';");
                while (resSet.next()) {
                    result = resSet.getString("value");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
