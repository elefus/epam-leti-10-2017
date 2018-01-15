package com.epam.jf.common.classwork.lesson25;

import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/students","sa", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENTS")){
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID") + " " + resultSet.getString("Name") + " " + resultSet.getString("Acronym"));
            }
        }

        System.out.println("Success");
    }
}

class ExecuteQueryToDBExample {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root", "123456");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS")){
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID") + " " + resultSet.getString("Name") + " " + resultSet.getInt("Age"));
            }
        } catch (SQLException e) {
        }
    }
}
