package com.dw.model.oracle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "WAKTU",
        indexes = {@Index(name = "WAKTU_PK", columnList = "NO_WAKTU", unique = true)})
public class WaktuOracle implements Serializable {
    @Id
    @Column(name = "NO_WAKTU", columnDefinition = "bigint(10)")
    private int noWaktu;
    @Column(name = "TANGGAL", columnDefinition = "date")
    private Date tanggal;
    @Column(name = "HARI", columnDefinition = "bigint(2)")
    private long hari;
    @Column(name = "BULAN", columnDefinition = "bigint(2)")
    private long bulan;
    @Column(name = "TAHUN", columnDefinition = "bigint(4)")
    private long tahun;
    @Column(name = "QUARTER", columnDefinition = "bigint(1)")
    private long quarter;

    public int getNoWaktu() {
        return noWaktu;
    }

    public void setNoWaktu(int noWaktu) {
        this.noWaktu = noWaktu;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public long getHari() {
        return hari;
    }

    public void setHari(long hari) {
        this.hari = hari;
    }

    public long getBulan() {
        return bulan;
    }

    public void setBulan(long bulan) {
        this.bulan = bulan;
    }

    public long getTahun() {
        return tahun;
    }

    public void setTahun(long tahun) {
        this.tahun = tahun;
    }

    public long getQuarter() {
        return quarter;
    }

    public void setQuarter(long quarter) {
        this.quarter = quarter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WaktuOracle waktuOracle = (WaktuOracle) o;

        if (noWaktu != waktuOracle.noWaktu) return false;
        if (hari != waktuOracle.hari) return false;
        if (bulan != waktuOracle.bulan) return false;
        if (tahun != waktuOracle.tahun) return false;
        if (quarter != waktuOracle.quarter) return false;
        if (tanggal != null ? !tanggal.equals(waktuOracle.tanggal) : waktuOracle.tanggal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noWaktu;
        result = 31 * result + (tanggal != null ? tanggal.hashCode() : 0);
        result = 31 * result + (int) (hari ^ (hari >>> 32));
        result = 31 * result + (int) (bulan ^ (bulan >>> 32));
        result = 31 * result + (int) (tahun ^ (tahun >>> 32));
        result = 31 * result + (int) (quarter ^ (quarter >>> 32));
        return result;
    }
}
