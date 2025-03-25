package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "123456"
        );

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();

            String firstName = resultSet.getString("first_name");
            user.setFirstName(firstName);

            String lastName = resultSet.getString("last_name");
            user.setLastName(lastName);

            String email = resultSet.getString("email");
            user.setEmail(email);

            users.add(user);
        }

        System.out.println(users);
    }
}