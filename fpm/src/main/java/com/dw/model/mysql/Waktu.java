package com.dw.model.mysql;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_waktu")
public class Waktu {
    @Id
    @Column(name = "id", columnDefinition = "int(10)")
    private int idWaktu;

    @Column(name = "tgl", nullable = false, columnDefinition = "date")
    private Date waktu;

    public int getIdWaktu() {
        return idWaktu;
    }

    public void setIdWaktu(int idWaktu) {
        this.idWaktu = idWaktu;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Waktu tWaktu = (Waktu) o;

        if (idWaktu != tWaktu.idWaktu) return false;
        if (waktu != null ? !waktu.equals(tWaktu.waktu) : tWaktu.waktu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWaktu;
        result = 31 * result + (waktu != null ? waktu.hashCode() : 0);
        return result;
    }
}
