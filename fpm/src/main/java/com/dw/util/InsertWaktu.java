package com.dw.util;

import com.dw.dao.mysql.WaktuDAO;
import com.dw.dao.oracle.WaktuNewDAO;
import com.dw.daoimpl.mysql.WaktuDAOImpl;
import com.dw.daoimpl.oracle.WaktuNewDAOImpl;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Waktu;
import com.dw.model.oracle.WaktuNewOracle;
import com.dw.model.oracle.WaktuOracle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertWaktu {
    public static void newTransaction() {
        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        WaktuDAO waktuDAO = new WaktuDAOImpl(mySQLHibernate);
        com.dw.dao.oracle.WaktuDAO waktuDAOOracle = new com.dw.daoimpl.oracle.WaktuDAOImpl(oracleHibernate);
        WaktuNewDAO waktuNewDAO = new WaktuNewDAOImpl(oracleHibernate);

        /**
         * Mengambil data dari tabel Waktu di MySQL
         * Dan menyimpan ke tabel Waktu di DW Oracle
         */

        // Ambil data dari MySQL
        List<Waktu> waktus = waktuDAO.readWaktu();

        // Inisialisasi List untuk menyimpan Waktu DW
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


        // ORACLE SESSION
        waktuOracles.clear();

        List<WaktuNewOracle> waktuNewOracles = waktuNewDAO.readWaktu();

        for (WaktuNewOracle w : waktuNewOracles) {
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

        mySQLHibernate.shutdown();
    }
}
