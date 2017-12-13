package com.dw.model.mysql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "t_customer_new", schema = "retail", catalog = "")
public class Customer implements Serializable {
    private int idNew;
    private String id;
    private String jenis;
    private String nama;
    private String almat;
    private String kota;
    private String kdpos;
    private String notel;
    private String hp;
    private String nofax;
    private String url;
    private String email;

    @Id
    @Column(name = "id_new")
    public int getIdNew() {
        return idNew;
    }

    public void setIdNew(int idNew) {
        this.idNew = idNew;
    }

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jenis")
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Basic
    @Column(name = "nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "almat")
    public String getAlmat() {
        return almat;
    }

    public void setAlmat(String almat) {
        this.almat = almat;
    }

    @Basic
    @Column(name = "kota", nullable = true)
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Basic
    @Column(name = "kdpos")
    public String getKdpos() {
        return kdpos;
    }

    public void setKdpos(String kdpos) {
        this.kdpos = kdpos;
    }

    @Basic
    @Column(name = "notel")
    public String getNotel() {
        return notel;
    }

    public void setNotel(String notel) {
        this.notel = notel;
    }

    @Basic
    @Column(name = "hp")
    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    @Basic
    @Column(name = "nofax")
    public String getNofax() {
        return nofax;
    }

    public void setNofax(String nofax) {
        this.nofax = nofax;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer that = (Customer) o;

        if (idNew != that.idNew) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (jenis != null ? !jenis.equals(that.jenis) : that.jenis != null) return false;
        if (nama != null ? !nama.equals(that.nama) : that.nama != null) return false;
        if (almat != null ? !almat.equals(that.almat) : that.almat != null) return false;
        if (kota != null ? !kota.equals(that.kota) : that.kota != null) return false;
        if (kdpos != null ? !kdpos.equals(that.kdpos) : that.kdpos != null) return false;
        if (notel != null ? !notel.equals(that.notel) : that.notel != null) return false;
        if (hp != null ? !hp.equals(that.hp) : that.hp != null) return false;
        if (nofax != null ? !nofax.equals(that.nofax) : that.nofax != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNew;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (jenis != null ? jenis.hashCode() : 0);
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (almat != null ? almat.hashCode() : 0);
        result = 31 * result + (kota != null ? kota.hashCode() : 0);
        result = 31 * result + (kdpos != null ? kdpos.hashCode() : 0);
        result = 31 * result + (notel != null ? notel.hashCode() : 0);
        result = 31 * result + (hp != null ? hp.hashCode() : 0);
        result = 31 * result + (nofax != null ? nofax.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
