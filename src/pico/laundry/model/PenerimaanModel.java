package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import pico.laundry.entity.Penerimaan;

public class PenerimaanModel {

    private Connection connection;

    public PenerimaanModel(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Penerimaan penerimaan) throws SQLException {
        String sql = "INSERT INTO penerimaan (nomor,tanggal,pembayaran_dari,keterangan,jumlah_dibayarkan,sub_total) VALUES(?,?,?,?,?,?)";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, penerimaan.getNomor());
        statemen.setDate(2, new java.sql.Date(penerimaan.getTanggal().getTime()));
        statemen.setString(3, penerimaan.getPembayaran_dari());
        statemen.setString(4, penerimaan.getKeterangan());
        statemen.setInt(5, penerimaan.getJumlah_dibayarkan());
        statemen.setInt(6, penerimaan.getSub_total());
        statemen.executeUpdate();
        statemen.close();
    }
    
}
