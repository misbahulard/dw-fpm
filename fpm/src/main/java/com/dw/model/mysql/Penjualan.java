package com.dw.model.mysql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "t_penjualan")
public class Penjualan implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NO_PRODUK")
    private Integer noProduk;
    @Column(name = "NO_PELANGGAN")
    private Integer noPelanggan;
    @Column(name = "NO_WAKTU")
    private Integer noWaktu;
    @Column(name = "JUMLAH_PENJUALAN")
    private Integer jumlahPenjualan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoProduk() {
        return noProduk;
    }

    public void setNoProduk(Integer noProduk) {
        this.noProduk = noProduk;
    }

    public Integer getNoPelanggan() {
        return noPelanggan;
    }

    public void setNoPelanggan(Integer noPelanggan) {
        this.noPelanggan = noPelanggan;
    }

    public Integer getNoWaktu() {
        return noWaktu;
    }

    public void setNoWaktu(Integer noWaktu) {
        this.noWaktu = noWaktu;
    }

    public Integer getJumlahPenjualan() {
        return jumlahPenjualan;
    }

    public void setJumlahPenjualan(Integer jumlahPenjualan) {
        this.jumlahPenjualan = jumlahPenjualan;
    }
}
