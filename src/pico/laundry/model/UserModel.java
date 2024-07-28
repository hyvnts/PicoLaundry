package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import pico.laundry.entity.User;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UserModel {
    
    private Connection connection;
    
    public UserModel(Connection connection){
        this.connection = connection;
    }
    
        public boolean login(String username, String password) {
        String sql = "SELECT username, password FROM user WHERE username = ? AND password = MD5(?)";
            PreparedStatement statement = null;
            boolean status = false;
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);            
                ResultSet result = statement.executeQuery();
                status = result.first() ? true : false; 
                result.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }        
            return status;
        }    
}
