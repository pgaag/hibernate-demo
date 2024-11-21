package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnection {

    private static final Logger logger = LogManager.getLogger(DatabaseConnection.class);
    private static Connection connection = null;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DatabaseConnection.class) { // Ensure thread safety
                if (connection == null || connection.isClosed()) {
                    connection = createNewConnection();
                }
            }
        }
        return connection;
    }

    private static Connection createNewConnection() throws SQLException {
        Properties properties = new Properties();

        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find database.properties");
                throw new SQLException("Database properties file not found.");
            }

            // Load a properties file
            properties.load(input);

            // Get the property values
            String url = properties.getProperty("db.url", System.getenv("DB_URL"));
            String user = properties.getProperty("db.user", System.getenv("DB_USER"));
            String password = properties.getProperty("db.password", System.getenv("DB_PASSWORD"));

            if (url == null || user == null || password == null) {
                logger.error("Database URL, user, or password not set properly.");
                throw new SQLException("Database credentials missing.");
            }

            logger.info("Received URL: " + url);
            logger.info("Received User: " + user);
            logger.info("Received Password: ******");
            logger.info("Connecting to the database...");
            return DriverManager.getConnection(url, user, password);

        } catch (Exception ex) {
            logger.error("Error while reading the database properties file", ex);
            throw new SQLException("Failed to connect to the database", ex);
        }
    }
}
