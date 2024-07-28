package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import pico.laundry.entity.Pelanggan;

public class PelangganModel {

    private Connection connection;

    public PelangganModel(Connection connection) {
        this.connection = connection;
    }

    public void insert(Pelanggan pelanggan) throws SQLException {
        String sql
                = "INSERT INTO "
                + "pelanggan("
                + "nama, "
                + "telepon, "
                + "alamat"
                + ") "
                + "VALUES("
                + "?, "
                + "?, "
                + "?"
                + ")";

        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, pelanggan.getNama());
        statemen.setString(2, pelanggan.getTelepon());
        statemen.setString(3, pelanggan.getAlamat());
        statemen.executeUpdate();
        statemen.close();
    }

    public void update(Pelanggan pelanggan) throws SQLException {
        String sql = "UPDATE pelanggan "
           + "SET nama = ?, "
           + "alamat = ?, "
           + "telepon = ? "
           + "WHERE id = ?";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, pelanggan.getNama());
        statemen.setString(2, pelanggan.getAlamat());
        statemen.setString(3, pelanggan.getTelepon());
        statemen.executeUpdate();
        statemen.close();
    }

    public void delete(Pelanggan pelanggan) throws SQLException {
        String sql = "DELETE FROM pelanggan WHERE id = ?";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setInt(1, pelanggan.getId());
        statemen.executeUpdate();
        statemen.close();
    }

    public List<Pelanggan> search(String keyword) {
        String sql = "SELECT nama,telepon,alamat FROM pelanggan WHERE nama LIKE ? OR alamat LIKE ?";
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pelanggan entity = new Pelanggan();
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

    public List<Pelanggan> getData() {
        String sql
                = "SELECT "
                + "nama, "
                + "alamat, "
                + "telepon "
                + "FROM "
                + "pelanggan";
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pelanggan entity = new Pelanggan();
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
