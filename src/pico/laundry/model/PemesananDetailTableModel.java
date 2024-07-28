package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.PemesananDetail;

public class PemesananDetailTableModel extends AbstractTableModel{
    private List<PemesananDetail> rows;
    
     public PemesananDetailTableModel(List<PemesananDetail> list) {
        rows = list;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PemesananDetail pemesananDetailEntity = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pemesananDetailEntity.getItem();
            case 1:
                return pemesananDetailEntity.getJumlah();
            case 2:
                return pemesananDetailEntity.getHarga();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Item";
            case 1:
                return "Jumlah";
            case 2:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    public void setRows(List<PemesananDetail> list) {
        rows = list;
    }

    public List<PemesananDetail> getRows() {
        return rows;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }
    
}
