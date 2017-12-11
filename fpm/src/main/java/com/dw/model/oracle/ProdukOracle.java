package com.dw.model.oracle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produk",
        indexes = {@Index(name = "PRODUK_PK", columnList = "NO_PRODUK", unique = true)})
public class ProdukOracle implements Serializable {
    @Id
    @Column(name = "no_produk", columnDefinition = "number(10)")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produk_id_seq")
    @SequenceGenerator(name = "produk_id_seq", sequenceName = "produk_seq", allocationSize = 1)
    private int noProduk;

    @Column(name = "nama_produk", columnDefinition = "varchar2(50)")
    private String namaProduk;

    @Column(name = "kategori_produk", columnDefinition = "varchar2(50)")
    private String kategoriProduk;

    public ProdukOracle() {
    }

    public int getNoProduk() {
        return noProduk;
    }

    public void setNoProduk(int  noProduk) {
        this.noProduk = noProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getKategoriProduk() {
        return kategoriProduk;
    }

    public void setKategoriProduk(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }
}
