package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnection {
    public static final String URL_CONNECTION_TO_DB = "jdbc:sqlite:persons.sqlite";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionToPersonsTable();
    }

    public static Connection  createAndReturnConnection() throws SQLException {
        Connection connectionToDB;
        connectionToDB = DriverManager.getConnection(URL_CONNECTION_TO_DB);
        return connectionToDB;
    }

    public static void  updateTablePersons(String firstName, String lastName, String address, int age) throws SQLException {
        //SETS UP QUERY TO INSERT INTO TABLE PERSONS
        String updateQuery = "INSERT INTO persons(firstName, lastName, address, age) VALUES (?,?,?,?)";
        //CREATES CONNECTION TO DATABASE TO USE WHEN UPDATING
        Connection connectionToDB = createAndReturnConnection();

        //PREPARED STATEMENT TO CREATE NEW OBJECT AND INSERT IT INTO DB
        PreparedStatement preparedStatement = connectionToDB.prepareStatement(updateQuery);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, address);
        preparedStatement.setInt(4, age);

        //EXECUTING UPDATE
        preparedStatement.executeUpdate();
        connectionToDB.close();

    }


    public static List<Object> ConnectionToPersonsTable() throws ClassNotFoundException, SQLException {
        Connection connectionToDatabase = createAndReturnConnection();
        Statement queryToExecute;
        ResultSet resultOfQuery;
        List<Object> array = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connectionToDatabase = DriverManager.getConnection(URL_CONNECTION_TO_DB);
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

}
