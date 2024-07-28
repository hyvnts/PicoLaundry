package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.Rekanan;
public class RekananTableModel extends AbstractTableModel {
    private List<Rekanan> rows;
    
    public RekananTableModel(List<Rekanan> list) {
        rows = list;
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4; //jumlah kolom
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rekanan perkiraan = rows.get(rowIndex);
        switch(columnIndex){
            case 0 : 
                return perkiraan.getKode();
            case 1 : 
                return perkiraan.getNama();
            case 2 : 
                return perkiraan.getAlamat();
            case 3 : 
                return perkiraan.getTelepon();
            default : 
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0 : 
                return "Kode";
            case 1 : 
                return "Nama";
            case 2 : 
                return "Alamat";
            case 3 : 
                return "Telepon";
            default : 
                return null;
        }       
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0 : 
                return String.class;
            case 1 : 
                return String.class;
            case 2 : 
                return String.class;
            case 3 : 
                return String.class;
            default : 
                return super.getColumnClass(columnIndex);
        }
    }
    
    public void setRows(List<Rekanan> list) {
        rows = list;
    }

    public List<Rekanan> getRows() {
        return rows;
    }
    
}
