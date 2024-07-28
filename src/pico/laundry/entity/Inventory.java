package pico.laundry.entity;

/**
 *
 * @author misba
 */
import java.util.Date;
public class Inventory {
    
    private String nama_produk;
    private Date tgl_pembelian;
    private Integer jumlah_stok;
    private Integer harga_produk;
    private String supplier;

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Date getTgl_pembelian() {
        return tgl_pembelian;
    }

    public void setTgl_pembelian(Date tgl_pembelian) {
        this.tgl_pembelian = tgl_pembelian;
    }

    public Integer getJumlah_stok() {
        return jumlah_stok;
    }

    public void setJumlah_stok(Integer jumlah_stok) {
        this.jumlah_stok = jumlah_stok;
    }

    public Integer getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(Integer harga_produk) {
        this.harga_produk = harga_produk;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    
}
