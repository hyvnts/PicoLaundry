package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pico.laundry.entity.Pengeluaran;
public class PengeluaranModel {
     private Connection connection;

    public PengeluaranModel(Connection connection) {
        this.connection = connection;
    }
    public void insert(Pengeluaran pengeluaran) throws SQLException {
        String sql = "INSERT INTO pengeluaran(nomor,tanggal,catatan,rekanan,perkiraan_kas) VALUES(?,?,?,?,?)";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1,pengeluaran.getNomor());
        statemen.setDate(2,new java.sql.Date(pengeluaran.getTanggal().getTime()));
        statemen.setString (3, pengeluaran.getCatatan());
        statemen.setString(4, pengeluaran.getRekanan().getKode());
        statemen.setString(5, pengeluaran.getPerkiraan_kas().getKode());
        statemen.executeUpdate();
        statemen.close();
    }
}
