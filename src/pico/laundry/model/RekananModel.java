package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pico.laundry.entity.Rekanan;
public class RekananModel {
    private Connection connection;

    public RekananModel(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Rekanan rekanan) throws SQLException {
        String sql = "INSERT INTO rekanans (kode,nama,alamat,telepon) VALUES (?,?,?,?)";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, rekanan.getKode());
        statemen.setString(2, rekanan.getNama());
        statemen.setString(3, rekanan.getAlamat());
        statemen.setString(4, rekanan.getTelepon());
        statemen.executeUpdate();
        statemen.close();
    }

    public void update(Rekanan rekanan) throws SQLException {
        String sql = 
            "UPDATE "
                + "rekanans"
            + "SET "
                + "nama = ?, "
                + "alamat = ?, "
                + "telepon = ? "
            + "WHERE "
                + "kode = ?"
            ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);        
        statemen.setString(1, rekanan.getNama());
        statemen.setString(2, rekanan.getAlamat());
        statemen.setString(3, rekanan.getTelepon());
        statemen.setString(4, rekanan.getKode());
        statemen.executeUpdate();
        statemen.close();
    }

    public void delete(Rekanan rekanan) throws SQLException {
        String sql = 
            "DELETE FROM "
                + "rekanans"
            + "WHERE "
                + "kode = ?"
            ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, rekanan.getKode());
        statemen.executeUpdate();
        statemen.close();
    }
 
    public List<Rekanan> search(String keyword) {
        String sql = "SELECT kode,nama,alamat,telepon FROM rekanans WHERE nama LIKE ? OR kode LIKE ?";
                  
        List<Rekanan> list = new ArrayList<Rekanan>();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Rekanan entity = new Rekanan();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setAlamat(result.getString("alamat"));
                entity.setTelepon(result.getString("telepon"));
                list.add(entity);
            }
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
        return list;
    }
    
    public List<Rekanan> getData() {
        String sql = 
            "SELECT "
                + "kode, "
                + "nama, "
                + "alamat, "
                + "telepon "
            + "FROM "
                + "rekanans"
            ;        
        List<Rekanan> list = new ArrayList<Rekanan>();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Rekanan entity = new Rekanan();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setAlamat(result.getString("alamat"));
                entity.setTelepon(result.getString("telepon"));
                list.add(entity);
            }
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
        return list;
    }
}
