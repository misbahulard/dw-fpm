package com.dw.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "t_barang_new")
@Entity
public class Barang implements Serializable {

    @Id
    @Column(name = "id_new", columnDefinition = "int(10)")
    private int id_new;

    @Column(name = "id_old", nullable = false, unique = true, columnDefinition = "char(10)")
    private String id_old;

    @Column(name = "nama", nullable = false, columnDefinition = "char(25)")
    private String nama;

    @Column(name = "jns_brg", nullable = false, columnDefinition = "char(6)")
    private String jnsBrg;

    public int getId_new() {
        return id_new;
    }

    public void setId_new(int id_new) {
        this.id_new = id_new;
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

    public String getJnsBrg() {
        return jnsBrg;
    }

    public void setJnsBrg(String jnsBrg) {
        this.jnsBrg = jnsBrg;
    }
}
