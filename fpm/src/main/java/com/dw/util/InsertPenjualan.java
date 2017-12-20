package com.dw.util;

import com.dw.dao.mysql.PenjualanDAO;
import com.dw.dao.oracle.SalesDAO;
import com.dw.daoimpl.mysql.PenjualanDAOImpl;
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

        PenjualanDAO jualDAO = new PenjualanDAOImpl(mySQLHibernate);
        com.dw.dao.oracle.PenjualanDAO penjualanDAO = new com.dw.daoimpl.oracle.PenjualanDAOImpl(oracleHibernate);

        SalesDAO salesDAO = new SalesDAOImpl(oracleHibernate);

        List<PenjualanOracle> penjualans = new ArrayList<>();

        List<Penjualan> jual = jualDAO.readPenjualan();

        for (Penjualan p : jual) {
            Integer noProduk = p.getNoProduk();
            Integer noPelanggan = p.getNoPelanggan();
            Integer noWaktu = p.getNoWaktu();
            Integer jml = p.getJumlahPenjualan();

            PenjualanOracle penjualan = new PenjualanOracle();
            penjualan.setNoProduk(noProduk);
            penjualan.setNoPelanggan(noPelanggan);
            penjualan.setNoWaktu(noWaktu);
            penjualan.setJumlahPenjualan(jml);

            penjualans.add(penjualan);
        }

        penjualanDAO.save(penjualans);

        /*penjualans.clear();

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

            penjualans.add(penjualan);
        }

        penjualanDAO.save(penjualans);*/

        mySQLHibernate.shutdown();
        oracleHibernate.shutdown();
    }
}
