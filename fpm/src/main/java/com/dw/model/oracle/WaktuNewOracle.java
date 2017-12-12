package com.dw.model.oracle;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "WAKTU_NEW",
        indexes = {@Index(name = "WAKTU_NEW_PK", columnList = "ID_WAKTU", unique = true)})
public class WaktuNewOracle implements Serializable {
    @Id
    @Column(name = "ID_WAKTU", columnDefinition = "bigint(10)")
    private int idWaktu;
    @Column(name = "WAKTU", columnDefinition = "date")
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
}
