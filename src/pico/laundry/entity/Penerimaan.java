package pico.laundry.entity;

/**
 *
 * @author misba
 */
   import java.util.Date;
public class Penerimaan {
    
        private String nomor;
        private Date tanggal;
        private String pembayaran_dari;
        private String keterangan;
        private Integer jumlah_dibayarkan;
        private Integer sub_total;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getPembayaran_dari() {
        return pembayaran_dari;
    }

    public void setPembayaran_dari(String pembayaran_dari) {
        this.pembayaran_dari = pembayaran_dari;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getJumlah_dibayarkan() {
        return jumlah_dibayarkan;
    }

    public void setJumlah_dibayarkan(Integer jumlah_dibayarkan) {
        this.jumlah_dibayarkan = jumlah_dibayarkan;
    }

    public Integer getSub_total() {
        return sub_total;
    }

    public void setSub_total(Integer sub_total) {
        this.sub_total = sub_total;
    }
        
        
    
}
