package com.dw;

import com.dw.dao.mysql.BarangDAO;
import com.dw.dao.mysql.WaktuDAO;
import com.dw.dao.oracle.WaktuNewDAO;
import com.dw.daoimpl.mysql.WaktuDAOImpl;
import com.dw.daoimpl.oracle.WaktuNewDAOImpl;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Barang;
import com.dw.model.mysql.Waktu;
import com.dw.model.oracle.WaktuNewOracle;
import com.dw.model.oracle.WaktuOracle;
import com.dw.util.InsertBarang;
import com.dw.util.InsertCustomer;
import com.dw.util.InsertPenjualan;
import com.dw.util.InsertWaktu;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Merupakan main class dari aplikasi
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 December 2017
 */
public class App {
    private final static String DB_NAME = "retail";
    private final static String USER_NAME = "root";
    private final static String USER_PASSWORD = "";

    /**
     * Method main dari aplikasi
     *
     * @param args merupakan argumen aplikasi
     */
    public static void main(String[] args) {
        /**
         * Insert waktu untuk MySQL dan Oracle
         */
        // InsertWaktu.newTransaction();

        /**
         * Insert barang untuk MySQL
         */
        // InsertBarang.newTransaction2();

        /**
         * Insert customer untuk MySQL
         */
        // InsertCustomer.newTransaction();

        /**
         * Insert customer untuk MySQL
         */
        InsertPenjualan.newTransaction();
    }
}
