package com.dw.model.mysql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "t_penjualan")
public class Penjualan implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "id_barang")
    private int idBarang;

    @Column(name = "id_customer")
    private int idCustomer;
    private int tgl;
    private int jumlah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Basic
    @Column(name = "tgl")
    public int getTgl() {
        return tgl;
    }

    public void setTgl(int tgl) {
        this.tgl = tgl;
    }

    @Basic
    @Column(name = "jumlah")
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

}
