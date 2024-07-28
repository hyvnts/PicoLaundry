
package pico.laundry.database;

/**
 *
 * @author misba
 */


import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    
    private static Connection connection;
    
    public static Connection newInstant(){
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                String url= "jdbc:mysql://localhost:3306/picolaundry";
                String user= "root";
                String password= "";
                connection = DriverManager.getConnection(url, user, password);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return connection;
    }
}
