package com.dw.util;

import com.dw.dao.mysql.JualDAO;
import com.dw.dao.oracle.PenjualanDAO;
import com.dw.dao.oracle.SalesDAO;
import com.dw.daoimpl.mysql.JualDAOImpl;
import com.dw.daoimpl.oracle.PenjualanDAOImpl;
import com.dw.daoimpl.oracle.SalesDAOImpl;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Penjualan;
import com.dw.model.oracle.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class InsertPenjualan {
    public static void newTransaction() {
        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        JualDAO jualDAO = new JualDAOImpl(mySQLHibernate);
        SalesDAO salesDAO = new SalesDAOImpl(oracleHibernate);
        PenjualanDAO penjualanDAO = new PenjualanDAOImpl(oracleHibernate);


       List<PenjualanOracle> sales = new ArrayList<>();

//        List<Penjualan> jual = jualDAO.readJual();
//        for (Penjualan w : jual) {
//            int id = w.getIdBarang();
//            int cust = w.getIdCustomer();
//            int id_waktu = w.getTgl();
//            int jml = w.getJumlah();
//
//            ProdukOracle produkOracle = new ProdukOracle();
//            PelangganOracle pelangganOracle = new PelangganOracle();
//            WaktuOracle waktuOracle = new WaktuOracle();
//
//            produkOracle.setNoProduk(id);
//            pelangganOracle.setNoPelanggan(cust);
//            waktuOracle.setNoWaktu(id_waktu);
//
//            System.out.println(id_waktu);
//
//            PenjualanOracle penjualan = new PenjualanOracle();
//            penjualan.setNoProduk(produkOracle);
//            penjualan.setNoPelanggan(pelangganOracle);
//            penjualan.setNoWaktu(waktuOracle);
//            penjualan.setJumlahPenjualan(jml);
//
//            sales.add(penjualan);
//        }
//
//        penjualanDAO.save(sales);
//        sales.clear();


        List<SalesOracle> sale = salesDAO.readSales();
        for (SalesOracle w : sale) {
            int id = w.getProdId();
            int cust = w.getCustId();
            int id_waktu = w.getTimeId();
            int jml = w.getQuantitySold();
            System.out.println(id_waktu);

            ProdukOracle produkOracle = new ProdukOracle();
            PelangganOracle pelangganOracle = new PelangganOracle();
            WaktuOracle waktuOracle = new WaktuOracle();

            produkOracle.setNoProduk(id);
            pelangganOracle.setNoPelanggan(cust);
            waktuOracle.setNoWaktu(id_waktu);

            System.out.println(id_waktu);

            PenjualanOracle penjualan = new PenjualanOracle();
            penjualan.setNoProduk(produkOracle);
            penjualan.setNoPelanggan(pelangganOracle);
            penjualan.setNoWaktu(waktuOracle);
            penjualan.setJumlahPenjualan(jml);

            sales.add(penjualan);
        }

        penjualanDAO.save(sales);
       //mySQLHibernate.shutdown();
    }
}
