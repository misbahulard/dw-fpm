package com.dw;

import com.dw.dao.mysql.BarangDAO;
import com.dw.daoimpl.mysql.BarangDAOImpl;
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
        BarangDAO barangDAO = new BarangDAOImpl(mySQLHibernate);

//        for (Barang b : barangDAO.readBarang()) {
//            System.out.println(b.getId() + " - " + b.getJnsPsr() + " : " + b.getNama());
//        }

//        Barang barang = new Barang();
//
//        barang.setId("AG20");
//        barang.setJnsPsr("TRD");
//
//        Barang b = barangDAO.readBarang(barang);
//        System.out.println(b.getId() + " - " + b.getJnsPsr() + " : " + b.getNama());

        mySQLHibernate.shutdown();
    }
}
