package pico.laundry.entity;

/**
 *
 * @author misba
 */
import java.util.Date;
public class Pengeluaran {
    
    private String nomor;
    private Date tanggal;
    private String catatan;
    private Integer total;
    private Rekanan rekanan;
    private Perkiraan perkiraan_kas;

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

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Rekanan getRekanan() {
        return rekanan;
    }

    public void setRekanan(Rekanan rekanan) {
        this.rekanan = rekanan;
    }

    
    public Perkiraan getPerkiraan_kas() {
        return perkiraan_kas;
    }

    public void setPerkiraan_kas(Perkiraan perkiraan_kas) {
        this.perkiraan_kas = perkiraan_kas;
    }
    
    
    
}
