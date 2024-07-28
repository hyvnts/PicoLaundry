package pico.laundry.entity;

/**
 *
 * @author misba
 */
public class JurnalDetail {

    private Integer id;
    private Integer debet;
    private Integer kredit;
    private Perkiraan perkiraan;
    private Jurnal jurnal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDebet() {
        return debet;
    }

    public void setDebet(Integer debet) {
        this.debet = debet;
    }

    public Integer getKredit() {
        return kredit;
    }

    public void setKredit(Integer kredit) {
        this.kredit = kredit;
    }

    public Perkiraan getPerkiraan() {
        return perkiraan;
    }

    public void setPerkiraan(Perkiraan perkiraan) {
        this.perkiraan = perkiraan;
    }

    public Jurnal getJurnal() {
        return jurnal;
    }

    public void setJurnal(Jurnal jurnal) {
        this.jurnal = jurnal;
    }
    
}
