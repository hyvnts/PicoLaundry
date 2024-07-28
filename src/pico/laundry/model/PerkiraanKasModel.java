package pico.laundry.model;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pico.laundry.entity.Perkiraan;
public class PerkiraanKasModel extends PerkiraanModel{
    
    public PerkiraanKasModel(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    public List<Perkiraan> search(String keyword) {
        String sql = "SELECT kode,nama,tipe From perkiraan WHERE kode LIKE ? or nama LIKE AND tipe = 'Kas atau Bank' ORDER BY kode ASC";
        List<Perkiraan> list = new ArrayList<Perkiraan>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Perkiraan entity = new Perkiraan();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setTipe(result.getString("tipe"));
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

    public List<Perkiraan> getData() {
        String sql = "SELECT kode,nama,tipe FROM perkiraan WHERE tipe = 'Kas atau bank' ORDER BY kode ASC";
        List<Perkiraan> list = new ArrayList<Perkiraan>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Perkiraan entity = new Perkiraan();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setTipe(result.getString("tipe"));
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
