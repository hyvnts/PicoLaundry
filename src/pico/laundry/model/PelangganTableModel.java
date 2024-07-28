package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.Pelanggan;

public class PelangganTableModel extends AbstractTableModel
{

    private List<Pelanggan> rows;
    
    public PelangganTableModel(List<Pelanggan> list) {
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
        Pelanggan perkiraan = rows.get(rowIndex);
        switch(columnIndex){
            case 0 : 
                return perkiraan.getNama();
            case 1 : 
                return perkiraan.getAlamat();
            case 2 : 
                return perkiraan.getTelepon();
            default : 
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0 : 
                return "Nama Pelanggan";
            case 1 : 
                return "Alamat Pelanggan";
            case 2 : 
                return "Nomor Telepon";
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
    
    public void setRows(List<Pelanggan> list) {
        rows = list;
    }

    public List<Pelanggan> getRows() {
        return rows;
    }
    
}
