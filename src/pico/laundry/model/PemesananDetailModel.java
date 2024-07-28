package pico.laundry.model;

/**
 *
 * @author misba
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PemesananDetailModel {
private Connection connection;
    public PemesananDetailModel(Connection connection) {
        this.connection = connection;
    }    
    public void insert(pico.laundry.entity.PemesananDetail pemesananDetailEntity) throws SQLException {
        String sql = "INSERT INTO pemesanan_detail(id_pemesanan,item,jumlah,harga) VALUES (?,?,?,?)";
           
            PreparedStatement statemen = connection.prepareStatement(sql);
            statemen.setString(1, pemesananDetailEntity.getId_pemesanan());
            statemen.setString(2, pemesananDetailEntity.getItem());
            statemen.setInt(3, pemesananDetailEntity.getJumlah());
            statemen.setInt(4, pemesananDetailEntity.getHarga());
            statemen.executeUpdate();
            statemen.close();
    }
}
