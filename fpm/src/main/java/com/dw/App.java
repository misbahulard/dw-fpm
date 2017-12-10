package com.dw;

import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Barang;
import com.dw.model.oracle.Produk;

import java.util.ArrayList;

/**
 * Merupakan main class dari aplikasi
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 December 2017
 */
public class App 
{
    private final static String DB_NAME = "retail";
    private final static String USER_NAME = "root";
    private final static String USER_PASSWORD = "";

    /**
     * Method main dari aplikasi
     *
     * @param args merupakan argumen aplikasi
     */
    public static void main( String[] args )
    {
        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        ArrayList<Barang> barangs = mySQLHibernate.readBarang();

//        for (Barang barang: barangs) {
//            System.out.println(barang.getId());
//        }

        System.out.println(barangs.size());

        ArrayList<Produk> produks = new ArrayList<>();
        for (int i = 0; i < barangs.size(); i++) {
            Produk produk = new Produk();

//            produk.setNoProduk(i);
            produk.setNamaProduk(barangs.get(i).getNama());
            produk.setKategoriProduk(barangs.get(i).getJnsBrg());
            produks.add(produk);
        }

        boolean isSuccess = oracleHibernate.insertProduk(produks);
        if (isSuccess) {
            System.out.println("YES!");
        } else {
            System.out.println("SHIT");
        }
    }
}
