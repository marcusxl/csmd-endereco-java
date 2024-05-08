package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){

        String url = "jdbc:mariadb://127.0.0.1:3306/endereco";
        Connection connection;

        try {
            connection = DriverManager.getConnection(url, "root", "mar123#");
            return  connection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
