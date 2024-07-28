package pico.laundry.model;

/**
 *
 * @author misba
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pico.laundry.entity.Pemesanan;

public class DataTransaksiTableModel extends AbstractTableModel {

    private List<Pemesanan> rows;

    public DataTransaksiTableModel(List<Pemesanan> list) {
        rows = list;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 6; //jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pemesanan pemesanan = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pemesanan.getId_pemesanan();
            case 1:
                return pemesanan.getPelanggan();
            case 2:
                return pemesanan.getPesanan_masuk();
            case 3:
                return pemesanan.getJenis_layanan();
            case 4:
                return pemesanan.getTotal_biaya();
            case 5:
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
                return "Nama Pelanggan";
            case 2:
                return "Tanggal Transaksi";
            case 3:
                return "Jenis Layanan";
            case 4:
                return "Total Biaya";
            case 5:
                return "Status Pesanan";
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
                return String.class;
            case 4:
                return Integer.class;
            case 5:
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
