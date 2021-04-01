package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnection {

    public static void main(String[] args) throws ClassNotFoundException {
        ConnectionToPersonsTable();
    }

    public static void updateTablePersons(Connection connectionToDatabase, String firstName, String lastName, String address, int age) throws SQLException {
        String updateQuery = "INSERT INTO persons(firstName, lastName, address, age) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connectionToDatabase.prepareStatement(updateQuery);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, address);
        preparedStatement.setInt(4, age);
    }

    public static List<Object> ConnectionToPersonsTable() throws ClassNotFoundException {
        Connection connectionToDatabase = null;
        Statement queryToExecute;
        ResultSet resultOfQuery;
        List<Object> array = new ArrayList<Object>();
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:persons.sqlite";
            connectionToDatabase = DriverManager.getConnection(url);
            queryToExecute = connectionToDatabase.createStatement();
            resultOfQuery = queryToExecute.executeQuery("SELECT * FROM persons;");
            while (resultOfQuery.next()) {
                 array.add(
                        new Person(resultOfQuery.getString("firstName"), resultOfQuery.getString("lastName"),
                                resultOfQuery.getInt(5), resultOfQuery.getString("address"), resultOfQuery.getInt(1))
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connectionToDatabase != null) {
                    connectionToDatabase.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return array;
    }

    public static void sendInformationToFrontEndFromPersonsTable() {
    }
}
