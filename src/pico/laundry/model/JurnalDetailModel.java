package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pico.laundry.entity.JurnalDetail;

public class JurnalDetailModel {

        private Connection connection;

    public JurnalDetailModel(Connection connection) {
        this.connection = connection;
    }    
    
    public void insert(JurnalDetail jurnalDetail) throws SQLException{
        String sql = 
            "INSERT INTO jurnal_detail("
                + "debet, "
                + "kredit, "
                + "perkiraan, "
                + "jurnal"
            + ") "
            + "VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?"
            + ")";
        
        PreparedStatement statemen = connection.prepareStatement(sql);        
        statemen.setDouble(1, jurnalDetail.getDebet());
        statemen.setDouble(2, jurnalDetail.getKredit());
        statemen.setString(3, jurnalDetail.getPerkiraan().getKode());
        statemen.setString(4, jurnalDetail.getJurnal().getNomor());
        statemen.executeUpdate();
        statemen.close();
    }

}
