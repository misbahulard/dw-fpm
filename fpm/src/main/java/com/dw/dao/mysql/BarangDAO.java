package com.dw.dao.mysql;

import com.dw.model.mysql.Barang;

import java.util.List;

/**
 * Merupakan class DAO (Data Access Object) untuk class Barang
 * Class ini digunakan untuk melakukan operasi database untuk class Barang
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 December 2017
 */
public interface BarangDAO {

    public Barang readBarang(String id, String jnsPsr);
    public Barang readBarang(Barang barang);
    public List<Barang> readBarang();
    public Barang save(Barang barang);
    public List<Barang> save(List<Barang> barangs);
    public Barang update(Barang barang);
    public List<Barang> update(List<Barang> barangs);
    public boolean deleteById(String id);
    public boolean deleteByJnsPsr(String jnsPsr);
    public boolean delete(String id, String jnsPsr);
    public boolean delete(Barang barang);
    public boolean delete(List<Barang> barangs);
}
