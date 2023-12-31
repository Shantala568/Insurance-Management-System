
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    
    public static Connection getConnection() {

        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("===================================================");
                System.out.print("Driver Loaded");
                
                // Get the connection string from the property file
                String connectionString = DBPropertyUtil.getPropertyString();

                // Establish the connection("Most Important")
                connection = DriverManager.getConnection(connectionString); //Passes the connString from propertiesUtil File to driverManager.
                System.out.println("Database ("+DBPropertyUtil.dbName+") is connected Successfully!!\n");


            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
        return connection;
    }
}
