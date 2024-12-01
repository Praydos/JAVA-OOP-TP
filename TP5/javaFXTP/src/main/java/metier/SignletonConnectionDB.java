package metier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignletonConnectionDB {
    private static Connection connection;

    private SignletonConnectionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                // Explicitly load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Update connection string with parameters used in the test class
                String url = "jdbc:mysql://localhost:3306/TP5?useSSL=false&serverTimezone=UTC";
                String user = "root";  // Your database username
                String password = "";  // Your database password

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Database connection failed: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("Database connection error!");
            }
        }
        return connection;
    }
}

