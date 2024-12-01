package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {


                String url = "jdbc:mysql://localhost:3306/TP5?useSSL=false&serverTimezone=UTC";
                String user = "root";
                String password = "";

                try {
                    // Load MySQL JDBC Driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish the connection
                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                        System.out.println("Connected to the database!");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver not found.");
                    e.printStackTrace();
                } catch (SQLException e) {
                    System.out.println("Database connection failed.");
                    e.printStackTrace();
                }
            }
        }



