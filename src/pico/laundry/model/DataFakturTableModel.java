package pico.laundry.model;

/**
 *
 * @author misbakhulhanif
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.Pemesanan;

public class DataFakturTableModel extends AbstractTableModel {

    private List<Pemesanan> rows;

    public DataFakturTableModel(List<Pemesanan> list) {
        rows = list;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 5; //jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pemesanan pemesanan = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pemesanan.getId_pemesanan();
            case 1:
                return pemesanan.getPesanan_masuk();
            case 2:
                return pemesanan.getPelanggan();
            case 3:
                return pemesanan.getTotal_biaya();
            case 4:
                return pemesanan.getStatus_pesanan();
            
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Faktur";
            case 1:
                return "Tanggal Transaksi";
            case 2:
                return "Nama Pelanggan";
            case 3:
                return "Tagihan Pembayaran";
            case 4:
                return "Status";
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
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;                
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    public void setRows(List<Pemesanan> list) {
        rows = list;
    }

    public List<Pemesanan> getRows() {
        return rows;
    }

}
