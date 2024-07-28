package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pico.laundry.entity.PengeluaranDetail;
public class PengeluaranDetailModel {
    private Connection connection;

    public PengeluaranDetailModel(Connection connection) {
        this.connection = connection;
    }

    public void insert(PengeluaranDetail kasKeluarDetail) throws SQLException {
        String sql = "INSERT INTO pengeluaran_detail("
                + "keterangan, "
                + "jumlah, "
                + "perkiraan_beban, "
                + "kas_keluar"
                + ") "
                + "VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?"
                + ")";
            PreparedStatement statemen = connection.prepareStatement(sql);
            statemen.setString(1, kasKeluarDetail.getKeterangan());
            statemen.setInt(2, kasKeluarDetail.getJumlah());
            statemen.setString(3, kasKeluarDetail.getPerkiraan_beban().getKode());
            statemen.setString(4, kasKeluarDetail.getKas_keluar().getNomor());
            statemen.executeUpdate();
            statemen.close();

    }
    
}
