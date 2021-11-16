package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) {
        String sql = String.format(
                "create table if not exists %s(%s, %s);",
                    tableName, "id serial primary key",
                    "name varchar(255)");
       statementExecute(sql);

    }

    public void dropTable(String tableName) {
        String sql = String.format("drop table if exists %s", tableName);
        statementExecute(sql);

    }

    public void addColumn(String tableName, String columnName, String type) {
            String sql = String.format("alter table %s add %s %s;", tableName, columnName, type);
            statementExecute(sql);
    }
    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("alter table %s drop column %s;", tableName, columnName);
         statementExecute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("alter table %s rename column %s to %s ;", tableName, columnName, newColumnName);
        statementExecute(sql);
    }

    public void statementExecute(String request) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
