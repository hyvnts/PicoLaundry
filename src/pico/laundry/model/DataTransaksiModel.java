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
import pico.laundry.entity.Pemesanan;

public class DataTransaksiModel {

    private Connection connection;

    public DataTransaksiModel(Connection connection) {
        this.connection = connection;
    }

    public List<Pemesanan> search(String keyword) {
        String sql = "SELECT id_pemesanan,pelanggan,pesanan_masuk,jenis_layanan,total_biaya,status_pesanan FROM pemesanan WHERE (id_pemesanan LIKE ? OR pelanggan LIKE ?)";
        List<Pemesanan> list = new ArrayList<Pemesanan>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pemesanan entity = new Pemesanan();
                entity.setId_pemesanan(result.getString("id_pemesanan"));
                entity.setPelanggan(result.getString("pelanggan"));
                entity.setPesanan_masuk(result.getDate("pesanan_masuk"));
                entity.setJenis_layanan(result.getString("jenis_layanan"));
                entity.setTotal_biaya(result.getInt("total_biaya"));
                entity.setStatus_pesanan(result.getString("status_pesanan"));

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

    public List<Pemesanan> getData() {
        String sql = "SELECT id_pemesanan,pelanggan,pesanan_masuk,jenis_layanan,total_biaya,status_pesanan FROM pemesanan";
        List<Pemesanan> list = new ArrayList<Pemesanan>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pemesanan entity = new Pemesanan();
                 entity.setId_pemesanan(result.getString("id_pemesanan"));
                entity.setPelanggan(result.getString("pelanggan"));
                entity.setPesanan_masuk(result.getDate("pesanan_masuk"));
                entity.setJenis_layanan(result.getString("jenis_layanan"));
                entity.setTotal_biaya(result.getInt("total_biaya"));
                entity.setStatus_pesanan(result.getString("status_pesanan"));

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
