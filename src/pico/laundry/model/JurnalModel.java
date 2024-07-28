package pico.laundry.model;

/**
 *
 * @author misba
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pico.laundry.entity.Jurnal;
public class JurnalModel {
    private Connection connection;

    public JurnalModel(Connection connection) {
        this.connection = connection;
    }    
    
    public void insert(Jurnal jurnal) throws SQLException{
        String sql = "INSERT INTO jurnal(nomor,tanggal,keterangan,tipe) VALUES (?,?,?,?)";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, jurnal.getNomor());
        statemen.setDate(2, new java.sql.Date(jurnal.getTanggal().getTime()));
        statemen.setString(3, jurnal.getKeterangan());
        statemen.setString(4, jurnal.getTipe());
        statemen.executeUpdate();
        statemen.close();
    }
}
