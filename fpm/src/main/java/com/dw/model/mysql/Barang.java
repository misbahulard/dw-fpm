package com.dw.model.mysql;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_barang",
        indexes = { @Index(name = "idx_t_barang", columnList = "id, supplier, nama, no, jns_brg, jns_psr") })
@Entity
public class Barang implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "char(10)")
    private String id;

    @Id
    @Column(name = "jns_psr", nullable = false, unique = true, columnDefinition = "char(6)")
    private String jnsPsr;

    @Column(name = "no", nullable = false, columnDefinition = "char(15)")
    private String no;

    @Column(name = "nama", nullable = false, columnDefinition = "char(25)")
    private String nama;

    @Column(name = "jns_brg", nullable = false, columnDefinition = "char(6)")
    private String jnsBrg;

    @Column(name = "hrg_beli", nullable = false, columnDefinition = "bigint(12)")
    private long hrgBeli;

    @Column(name = "sat_bsr", nullable = false, columnDefinition = "char(5)")
    private String satBsr;

    @Column(name = "hrg_bsr", nullable = false, columnDefinition = "bigint(12)")
    private long hrgBsr;

    @Column(name = "sat_kcl", nullable = false, columnDefinition = "char(5)")
    private String satKcl;

    @Column(name = "hrg_kcl", nullable = false, columnDefinition = "bigint(12)")
    private long hrgKcl;

    @Column(name = "isi", nullable = false, columnDefinition = "bigint(12)")
    private long isi;

    @Column(name = "supplier", nullable = false, columnDefinition = "char(6)")
    private String supplier;

    @Column(name = "kritis", nullable = false, columnDefinition = "bigint(12)")
    private long kritis;

    @Column(name = "stock", nullable = false, columnDefinition = "bigint(12)")
    private long stock;

    public Barang() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJnsPsr() {
        return jnsPsr;
    }

    public void setJnsPsr(String jsnPsr) {
        this.jnsPsr = jsnPsr;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJnsBrg() {
        return jnsBrg;
    }

    public void setJnsBrg(String jnsBrg) {
        this.jnsBrg = jnsBrg;
    }

    public long getHrgBeli() {
        return hrgBeli;
    }

    public void setHrgBeli(long hrgBeli) {
        this.hrgBeli = hrgBeli;
    }

    public String getSatBsr() {
        return satBsr;
    }

    public void setSatBsr(String satBsr) {
        this.satBsr = satBsr;
    }

    public long getHrgBsr() {
        return hrgBsr;
    }

    public void setHrgBsr(long hrgBsr) {
        this.hrgBsr = hrgBsr;
    }

    public String getSatKcl() {
        return satKcl;
    }

    public void setSatKcl(String satKcl) {
        this.satKcl = satKcl;
    }

    public long getHrgKcl() {
        return hrgKcl;
    }

    public void setHrgKcl(long hrgKcl) {
        this.hrgKcl = hrgKcl;
    }

    public long getIsi() {
        return isi;
    }

    public void setIsi(long isi) {
        this.isi = isi;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public long getKritis() {
        return kritis;
    }

    public void setKritis(long kritis) {
        this.kritis = kritis;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
