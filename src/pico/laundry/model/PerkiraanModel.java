package pico.laundry.model;

/**
 *
 * @author PC
 */

import pico.laundry.entity.Perkiraan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerkiraanModel {
    Connection connection;

    public PerkiraanModel(Connection connection) {
        this.connection = connection;
    }
        
    public void insert(Perkiraan perkiraan) throws SQLException{
        String sql = 
            "INSERT INTO "
            + "perkiraan("
                + "kode, "
                + "nama, "
                + "tipe"
            + ") "
            + "VALUES("
                + "?, "
                + "?, "
                + "?"
            + ")";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, perkiraan.getKode());
        statemen.setString(2, perkiraan.getNama());
        statemen.setString(3, perkiraan.getTipe());
        statemen.executeUpdate();
        statemen.close();
    }

    public void update(Perkiraan perkiraan) throws SQLException{
        String sql = 
            "UPDATE "
                + "perkiraan "
            + "SET "
                + "nama = ?, "
                + "tipe = ? "
            + "WHERE "
                + "kode = ?"
            ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);        
        statemen.setString(1, perkiraan.getNama());
        statemen.setString(2, perkiraan.getTipe());
        statemen.setString(3, perkiraan.getKode());
        statemen.executeUpdate();
        statemen.close();
    }

    public void delete(Perkiraan perkiraan) throws SQLException{
        String sql = 
            "DELETE "
            + "FROM "
                + "perkiraan "
            + "WHERE "
                + "kode = ?"
            ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, perkiraan.getKode());
        statemen.executeUpdate();
        statemen.close();
    }    

    public List<Perkiraan> search(String keyword) {
        String sql = 
            "SELECT "
                + "kode, "
                + "nama, "
                + "tipe "
            + "FROM "
                + "perkiraan "
            + "WHERE "
                + "kode LIKE ? "
            + "OR "
                + "nama LIKE ?"
            ;        
        List<Perkiraan> list = new ArrayList<Perkiraan>();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result = statement.executeQuery();
            while (result.next()){
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
        String sql = 
            "SELECT "
                + "kode, "
                + "nama, "
                + "tipe "
            + "FROM "
                + "perkiraan"
            ;        
        List<Perkiraan> list = new ArrayList<Perkiraan>();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
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
