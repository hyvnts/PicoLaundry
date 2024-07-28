package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pico.laundry.entity.Pemesanan;

public class PemesananModel {

    private Connection connection;

    public PemesananModel(Connection connection) {
        this.connection = connection;
    }

    public void insert(Pemesanan pemesanan) throws SQLException {
        String sql = "INSERT INTO pemesanan (id_pemesanan, pelanggan, pesanan_masuk, pesanan_selesai, status_pesanan, jenis_layanan, total_biaya) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pemesanan.getId_pemesanan());
        statement.setString(2, pemesanan.getPelanggan());
        statement.setDate(3, new java.sql.Date(pemesanan.getPesanan_masuk().getTime()));
        statement.setDate(4, new java.sql.Date(pemesanan.getPesanan_selesai().getTime()));
        statement.setString(5, pemesanan.getStatus_pesanan());
        statement.setString(6, pemesanan.getJenis_layanan());
        statement.setInt(7, pemesanan.getTotal_biaya());
        statement.executeUpdate();
        statement.close();
    }

    public void update_status(Pemesanan pemesanan) throws SQLException {
        String sql = "UPDATE pemesanan SET status_pesanan = 'Selesai' WHERE id_pemesanan= ? AND status_pesanan = 'dikerjakan' ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pemesanan.getId_pemesanan());
        statement.executeUpdate();
        statement.close();
    }

    public List<Pemesanan> getData() {
        String sql = "SELECT id_pemesanan,pesanan_masuk,pesanan_selesai,status_pesanan,jenis_layanan,total_biaya FROM pemesanan";
        List<Pemesanan> list = new ArrayList<Pemesanan>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pemesanan entity = new Pemesanan();
                entity.setId_pemesanan(result.getString("id_pemesanan"));
                entity.setPesanan_masuk(result.getDate("pesanan_masuk"));
                entity.setPesanan_selesai(result.getDate("pesanan_selesai"));
                entity.setStatus_pesanan(result.getString("status_pesanan"));
                entity.setJenis_layanan(result.getString("jenis_layanan"));
                entity.setTotal_biaya(result.getInt("total_biaya"));
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
