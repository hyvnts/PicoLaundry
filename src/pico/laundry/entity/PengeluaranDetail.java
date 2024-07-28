package pico.laundry.entity;

/**
 *
 * @author misba
 */
public class PengeluaranDetail {

    private Integer id;
    private String keterangan;
    private Integer jumlah;
    private Perkiraan perkiraan_beban;
    private Pengeluaran kas_keluar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Perkiraan getPerkiraan_beban() {
        return perkiraan_beban;
    }

    public void setPerkiraan_beban(Perkiraan perkiraan_beban) {
        this.perkiraan_beban = perkiraan_beban;
    }

    public Pengeluaran getKas_keluar() {
        return kas_keluar;
    }

    public void setKas_keluar(Pengeluaran kas_keluar) {
        this.kas_keluar = kas_keluar;
    }
    
    
}
