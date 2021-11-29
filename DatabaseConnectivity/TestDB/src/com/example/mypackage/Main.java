package com.example.mypackage;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Kirill/JavaCore/DatabaseConnectivity/TestDB/"
            + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
	    try{
            // connecting the database
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            //connection.setAutoCommit(false);  // need to commit the changes explicitly

            // creating a table
            Statement statement = connection.createStatement();
            statement.execute(String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s INTEGER, %s TEXT)",
                    TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));

            insertContact(statement, "Rhonin", 777777, "rhonin@warcraft.com");
            insertContact(statement, "Sargeras", 666666, "sargeras@warcraft.com");
            insertContact(statement, "Kiljaeden", 666666, "kiljaeden@warcraft.com");
            insertContact(statement, "Archimonde", 666666, "archimonde@warcraft.com");

            statement.execute(String.format(
                    "UPDATE %s SET %s = 101010 " +
                    "WHERE %s = 'Rhonin' AND %s != 101010",
                    TABLE_CONTACTS, COLUMN_PHONE, COLUMN_NAME, COLUMN_PHONE));
            statement.execute(String.format(
                    "DELETE FROM %s WHERE %s = 'Archimonde'",
                    TABLE_CONTACTS, COLUMN_NAME));

            // querying the database and showing the output
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            System.out.println(String.format("%s|%s|%s", COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + "|" +
                        results.getInt(2) + "|" +
                        results.getString(3));
            }

            // closing the resources
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute(String.format("INSERT INTO %s(%s, %s, %s) ",
                TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL) +
                String.format(
                        "SELECT * FROM (VALUES " +
                                "('%s', %d, '%s')) " +
                                "WHERE NOT EXISTS (SELECT %s FROM %s WHERE %s = '%s')",
                        name, phone, email, COLUMN_NAME, TABLE_CONTACTS, COLUMN_NAME, name));
    }
}