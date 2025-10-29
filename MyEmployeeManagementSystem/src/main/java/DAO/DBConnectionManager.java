package DAO;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
    private static String jdbcUrl;
    private static String dbUser;
    private static String dbPassword;
    private static String dbDriver;
    static {
        try {
            Properties properties = new Properties();
            try (InputStream input = DBConnectionManager.class.getClassLoader()
                    .getResourceAsStream("db.properties")) {
                if (input == null) {
                    throw new RuntimeException("db.properties file not found");
                }
                properties.load(input);
            }
            jdbcUrl = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");
            dbDriver = properties.getProperty("db.driver");
            Class.forName(dbDriver);
            System.out.println("Database driver loaded successfully!");
        } catch (Exception e) {
            System.err.println("Failed to load database configuration:" + e.getMessage());
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
