package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.PengeluaranDetail;

public class PengeluaranDetailTableModel extends AbstractTableModel {

    private List<PengeluaranDetail> rows;

    public PengeluaranDetailTableModel(List<PengeluaranDetail> list) {
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
        PengeluaranDetail kasKeluarDetail = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return kasKeluarDetail.getPerkiraan_beban().getNama();
            case 1:
                return kasKeluarDetail.getKeterangan();
            case 2:
                return kasKeluarDetail.getJumlah();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Rekening beban";
            case 1:
                return "Keterangan";
            case 2:
                return "Jumlah";
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
                return String.class;
            case 2:
                return Integer.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    public void setRows(List<PengeluaranDetail> list) {
        rows = list;
    }

    public List<PengeluaranDetail> getRows() {
        return rows;
    }

}
