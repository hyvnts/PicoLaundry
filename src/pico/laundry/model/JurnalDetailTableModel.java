package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.JurnalDetail;

public class JurnalDetailTableModel extends AbstractTableModel {

    private List<JurnalDetail> rows;

    public JurnalDetailTableModel(List<JurnalDetail> list) {
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
        JurnalDetail jurnalDetail = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return jurnalDetail.getPerkiraan().getKode();
            case 1:
                return jurnalDetail.getPerkiraan().getNama();
            case 2:
                return jurnalDetail.getDebet();
            case 3:
                return jurnalDetail.getKredit();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Rekening";
            case 2:
                return "Debet";
            case 3:
                return "Kredit";
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
            case 3:
                return Integer.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    public void setRows(List<JurnalDetail> list) {
        rows = list;
    }

    public List<JurnalDetail> getRows() {
        return rows;
    }
}
