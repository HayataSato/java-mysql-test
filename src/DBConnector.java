import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Connect to MySQL with JDBC Driver
 */
public class DBConnector {
    private static String driverName = "com.mysql.cj.jdbc.Driver";  // Necessary to modify the class it's fitted your driver version
    private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";
    private static String user = "USERNAME";
    private static String password = "PASSWORD";

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
