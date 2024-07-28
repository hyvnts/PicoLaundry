package pico.laundry.model;

/**
 *
 * @author PC
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.Perkiraan;
public class PerkiraanTableModel extends AbstractTableModel{
    private List<Perkiraan> rows;
    
    public PerkiraanTableModel(List<Perkiraan> list) {
        rows = list;
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3; //jumlah kolom
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perkiraan perkiraan = rows.get(rowIndex);
        switch(columnIndex){
            case 0 : 
                return perkiraan.getKode();
            case 1 : 
                return perkiraan.getNama();
            case 2 : 
                return perkiraan.getTipe();
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
                return "Tipe";
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
            default : 
                return super.getColumnClass(columnIndex);
        }
    }
    
    public void setRows(List<Perkiraan> list) {
        rows = list;
    }

    public List<Perkiraan> getRows() {
        return rows;
    }
}
