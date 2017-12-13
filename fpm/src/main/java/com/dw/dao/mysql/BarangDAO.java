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
    public List<Barang> readBarang();
}
