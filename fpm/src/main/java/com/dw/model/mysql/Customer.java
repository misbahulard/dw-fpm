package com.dw.model.mysql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "t_customer_new", schema = "retail", catalog = "")
public class Customer implements Serializable {
    @Id
    @Column(name = "id_new")
    private int idNew;
    @Basic
    @Column(name = "id_old")
    private String id_old;
    @Basic
    @Column(name = "nama")
    private String nama;
    @Basic
    @Column(name = "alamat")
    private String alamat;
    @Basic
    @Column(name = "kota")
    private String kota;

    public int getIdNew() {
        return idNew;
    }

    public void setIdNew(int idNew) {
        this.idNew = idNew;
    }

    public String getId_old() {
        return id_old;
    }

    public void setId_old(String id_old) {
        this.id_old = id_old;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
