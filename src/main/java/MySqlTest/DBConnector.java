package MySqlTest;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Connect to MySQL with JDBC Driver
 */
public class DBConnector {
    private static Dotenv dotenv = Dotenv.load();
    private static String driverName = "com.mysql.cj.jdbc.Driver";  // Necessary to modify the class it's fitted your driver version
    private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";
    private static String user = dotenv.get("DB_USER");
    private static String password = dotenv.get("DB_PASS");

    /**
     * Create connection with MySQL
     * @return Connection object
     */
    public Connection getConnection() {
        Connection con = null;

        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace() ;
        } catch (SQLException e) {
            e.printStackTrace() ;
        }

        return con ;
    }
}
