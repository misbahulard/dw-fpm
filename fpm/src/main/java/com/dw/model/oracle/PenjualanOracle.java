package com.dw.model.oracle;

import com.dw.model.mysql.Waktu;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/13/17.
 */
@Entity
@Table(name = "PENJUALAN")
public class PenjualanOracle implements Serializable {

    @Id
    @SequenceGenerator(name = "gen_penjualan", sequenceName = "seq_penjualan", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_penjualan")
    @Column(name = "NO_PENJUALAN", columnDefinition = "number(10)")
    private int id;

    @ManyToOne
    @JoinColumn(name = "NO_PRODUK")
    private ProdukOracle noProduk;

    @ManyToOne
    @JoinColumn(name = "NO_PELANGGAN")
    private PelangganOracle noPelanggan;

    @ManyToOne
    @JoinColumn(name = "NO_WAKTU")
    private WaktuOracle noWaktu;

    @Column(name = "JUMLAH_PENJUALAN")
    private int jumlahPenjualan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdukOracle getNoProduk() {
        return noProduk;
    }

    public void setNoProduk(ProdukOracle noProduk) {
        this.noProduk = noProduk;
    }

    public PelangganOracle getNoPelanggan() {
        return noPelanggan;
    }

    public void setNoPelanggan(PelangganOracle noPelanggan) {
        this.noPelanggan = noPelanggan;
    }

    public WaktuOracle getNoWaktu() {
        return noWaktu;
    }

    public void setNoWaktu(WaktuOracle noWaktu) {
        this.noWaktu = noWaktu;
    }

    public int getJumlahPenjualan() {
        return jumlahPenjualan;
    }

    public void setJumlahPenjualan(int jumlahPenjualan) {
        this.jumlahPenjualan = jumlahPenjualan;
    }
}
