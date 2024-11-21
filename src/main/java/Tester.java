import entitiesjba.Article;
import entitiesjba.Emp;
import helper.PersonData;
import infrastructure.DatabaseConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Tester {

    private static final Logger logger = LogManager.getLogger(Tester.class);
    private Properties properties = new Properties();

    public void callEntityManager() {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find database.properties");
                throw new SQLException("Database properties file not found.");
            }

            // Load a properties file
            properties.load(input);

            // Get the property values
            String password = properties.getProperty("db.password", "error");

            // Override password from properties file
            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.password", password);

            // Database access setup
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA-Test", properties);
            EntityManager em = emFactory.createEntityManager();

//            TypedQuery<Article> pq = em.createQuery(
//                    "SELECT a.artName, a.description, a.price, a.shippingSurcharge, a.department FROM entitiesjba.Article a WHERE a.price > 100 AND a.shippingSurcharge IS NULL", Article.class
//            );

            TypedQuery<Article> pq = em.createQuery(
                    "FROM entitiesjba.Article a LEFT JOIN entitiesjba.POrderLine pol ON pol.article.id = a.id WHERE pol.article IS NULL", Article.class
            );

            List<Article> pResult = pq.getResultList();
            for (Article pData : pResult) {
                System.out.println(pData);
            }

        } catch (Exception e) {
            logger.error("Error occurred while creating EntityManager", e);
        }
    }
}
