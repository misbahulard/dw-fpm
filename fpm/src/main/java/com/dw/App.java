package com.dw;

import com.dw.dao.mysql.WaktuDAO;
import com.dw.daoimpl.mysql.WaktuDAOImpl;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Waktu;
import com.dw.model.oracle.WaktuOracle;

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
        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        WaktuDAO waktuDAO = new WaktuDAOImpl(mySQLHibernate);
        com.dw.dao.oracle.WaktuDAO waktuDAOOracle = new com.dw.daoimpl.oracle.WaktuDAOImpl(oracleHibernate);

        // Ambil data dari MySQL
        List<Waktu> waktus = waktuDAO.readWaktu();

        List<WaktuOracle> waktuOracles = new ArrayList<>();

        // Looping untuk menyimpan data ke Array WaktuOracle Data Warehouse
        for (Waktu w : waktus) {
            int noWaktu = w.getIdWaktu();
            Date tanggal = w.getWaktu();
            java.sql.Date date = w.getWaktu();

            LocalDate localDate = date.toLocalDate();
            int hari = localDate.getDayOfMonth();
            int bulan = localDate.getMonthValue();
            int tahun = localDate.getYear();
            int quarter = (bulan / 3) + 1;

            WaktuOracle waktuOracle = new WaktuOracle();
            waktuOracle.setNoWaktu(noWaktu);
            waktuOracle.setTanggal(tanggal);
            waktuOracle.setHari(hari);
            waktuOracle.setBulan(bulan);
            waktuOracle.setTahun(tahun);
            waktuOracle.setQuarter(quarter);

            waktuOracles.add(waktuOracle);
        }

        // Menyimpan ke DW Waktu Oracle
        waktuDAOOracle.save(waktuOracles);



//        for (WaktuOracle w : waktus) {
//            System.out.println(w.getIdWaktu() + " - " + w.getWaktu());
//        }

//        BarangDAO barangDAO = new BarangDAOImpl(mySQLHibernate);

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
