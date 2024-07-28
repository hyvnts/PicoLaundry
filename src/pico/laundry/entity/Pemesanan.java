package pico.laundry.entity;

/**
 *
 * @author misba
 */
import java.util.Date;

public class Pemesanan {

    private String id_pemesanan;
    private String pelanggan;
    private Date pesanan_masuk;
    private Date pesanan_selesai;
    private String status_pesanan;
    private String jenis_layanan;
    private Integer total_biaya;
    private Pelanggan pelangganEntity;

    public Pelanggan getPelangganEntity() {
        return pelangganEntity;
    }

    public void setPelangganEntity(Pelanggan pelangganEntity) {
        this.pelangganEntity = pelangganEntity;
    }
    
    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Date getPesanan_masuk() {
        return pesanan_masuk;
    }

    public void setPesanan_masuk(Date pesanan_masuk) {
        this.pesanan_masuk = pesanan_masuk;
    }

    public Date getPesanan_selesai() {
        return pesanan_selesai;
    }

    public void setPesanan_selesai(Date pesanan_selesai) {
        this.pesanan_selesai = pesanan_selesai;
    }

    public String getStatus_pesanan() {
        return status_pesanan;
    }

    public void setStatus_pesanan(String status_pesanan) {
        this.status_pesanan = status_pesanan;
    }

    public String getJenis_layanan() {
        return jenis_layanan;
    }

    public void setJenis_layanan(String jenis_layanan) {
        this.jenis_layanan = jenis_layanan;
    }

    public Integer getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(Integer total_biaya) {
        this.total_biaya = total_biaya;
    }


}
