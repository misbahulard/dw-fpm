package com.dw.model.oracle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "PELANGGAN")
public class PelangganOracle implements Serializable {
    private int noPelanggan;
    private String namaPelanggan;
    private String alamatPelanggan;
    private String kotaPelanggan;

    @Id
    @Column(name = "NO_PELANGGAN", columnDefinition = "number(10)")
    public int getNoPelanggan() {
        return noPelanggan;
    }

    public void setNoPelanggan(int noPelanggan) {
        this.noPelanggan = noPelanggan;
    }


    @Column(name = "NAMA_PELANGGAN")
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }


    @Column(name = "ALAMAT_PELANGGAN")
    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public void setAlamatPelanggan(String alamatPelanggan) {
        this.alamatPelanggan = alamatPelanggan;
    }


    @Column(name = "KOTA_PELANGGAN", nullable = true)
    public String getKotaPelanggan() {
        return kotaPelanggan;
    }

    public void setKotaPelanggan(String kotaPelanggan) {
        this.kotaPelanggan = kotaPelanggan;
    }

}
