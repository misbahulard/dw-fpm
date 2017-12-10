package com.dw.model.mysql;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_supplier",
        indexes = { @Index(name = "idx_t_supplier", columnList = "id, nama") })
@Entity
public class Supplier implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "varchar(6)")
    private String id;

    @Id
    @Column(name = "nama", nullable = false, unique = true, columnDefinition = "varchar(25)")
    private String nama;

    @Column(name = "alamat", nullable = false, columnDefinition = "varchar(30)")
    private String alamat;

    @Column(name = "kota", nullable = false, columnDefinition = "varchar(5)")
    private String kota;

    @Column(name = "kdpos", nullable = false, columnDefinition = "varchar(6)")
    private String kdpos;

    @Column(name = "notel", nullable = false, columnDefinition = "varchar(15)")
    private String notel;

    @Column(name = "hp", nullable = false, columnDefinition = "varchar(15)")
    private String hp;

    @Column(name = "nofax", nullable = false, columnDefinition = "varchar(15)")
    private String nofax;

    @Column(name = "url", nullable = false, columnDefinition = "varchar(20)")
    private String url;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(20)")
    private String email;

    public Supplier() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getKdpos() {
        return kdpos;
    }

    public void setKdpos(String kdpos) {
        this.kdpos = kdpos;
    }

    public String getNotel() {
        return notel;
    }

    public void setNotel(String notel) {
        this.notel = notel;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getNofax() {
        return nofax;
    }

    public void setNofax(String nofax) {
        this.nofax = nofax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
