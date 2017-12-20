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
import com.dw.util.*;
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

    /**
     * Data source dasar aplikasi (digunakan untuk jdbc
     */
    private final static String DB_NAME = "retail";
    private final static String USER_NAME = "root";
    private final static String USER_PASSWORD = "";

    /**
     * Letak dari file-file sql yang akan dijalankan
     */
    private static final String BASE_PATH = "G:\\Materi Semester 5\\Data Warehouse\\dw-fpm\\sql\\";

    /**
     * Method main dari aplikasi
     *
     * @param args merupakan argumen aplikasi
     */
    public static void main(String[] args) {
//        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        String mysqlPath = BASE_PATH + "mysql\\"; // Letak data set mysql
        String oraclePath = BASE_PATH + "oracle\\"; // Letak data set oracle

        /*
            Membuatkan tabel-tabel sesuai file mysql
         */
//        NativeQueryFromFile.insertFromFile(mysqlPath + "mysql_table_ddl.sql", mySQLHibernate);

        /*
            Menginputkan data set mysql dari file
         */
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_barang_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_customer_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_det_jual_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_jns_brg_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_jns_cust_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_jns_sales_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_jual_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_kota_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_sales_data.sql", mySQLHibernate);
//        NativeQueryFromFile.insertFromFile(mysqlPath + "t_supplier_data.sql", mySQLHibernate);

        /*
            Membuatkan tabel-tabel sesuai file oralce
         */
//        NativeQueryFromFile.insertFromFile(oraclePath + "table_cre.sql", oracleHibernate);

        /*
            Menginputkan data set oracle dari file
         */
        NativeQueryFromFile.insertFromFileDat(oraclePath + "customer.dat", oracleHibernate, "customers");
        NativeQueryFromFile.insertFromFileDat(oraclePath + "product.dat", oracleHibernate, "products");

        /*
         * Insert waktu untuk MySQL dan Oracle
         */
        // InsertWaktu.newTransaction();

        /*
         * Insert barang untuk MySQL
         */
        // InsertBarang.newTransaction2();

        /*
         * Insert customer untuk MySQL
         */
        // InsertCustomer.newTransaction();

        /*
         * Insert customer untuk MySQL
         */
//        InsertPenjualan.newTransaction();

//        mySQLHibernate.shutdown();
        oracleHibernate.shutdown();
    }
}
