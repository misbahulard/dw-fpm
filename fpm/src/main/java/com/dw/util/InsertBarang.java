package com.dw.util;

import com.dw.dao.mysql.BarangDAO;
import com.dw.dao.oracle.ProductsDAO;
import com.dw.dao.oracle.ProdukDAO;
import com.dw.daoimpl.mysql.BarangDAOImpl;
import com.dw.daoimpl.oracle.ProductsDAOImpl;
import com.dw.daoimpl.oracle.ProdukDAOImpl;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Barang;
import com.dw.model.oracle.ProductsOracle;
import com.dw.model.oracle.ProdukOracle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class InsertBarang {
    public static void newTransaction2() {
        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        BarangDAO barangDAO = new BarangDAOImpl(mySQLHibernate);
        ProductsDAO productsDAO = new ProductsDAOImpl(oracleHibernate);
        ProdukDAO produkDAO = new ProdukDAOImpl(oracleHibernate);

        List<ProdukOracle> produks = new ArrayList<>();

        List<Barang> barangs = barangDAO.readBarang();
        for (Barang w : barangs) {
            int id = w.getId_new();
            String nama = w.getNama();
            String jenis = w.getJnsBrg();

            ProdukOracle produkOracle = new ProdukOracle();
            produkOracle.setNoProduk(id);
            produkOracle.setNamaProduk(nama);
            produkOracle.setKategoriProduk(jenis);

            produks.add(produkOracle);
        }
        produkDAO.save(produks);

        /*produks.clear();

        produks = new ArrayList<>();

        List<ProductsOracle> productsO = productsDAO.readProducts();
        int i=1;
        for (ProductsOracle w :productsO) {
           // System.out.println("here");
            int id = w.getProdId();
            String nama = w.getProdName();
            String jenis = w.getProdSubcategory();

          //  System.out.println(id);
           ProdukOracle produkOracle = new ProdukOracle();
            produkOracle.setNoProduk(id);
            produkOracle.setNamaProduk(nama);
            produkOracle.setKategoriProduk(jenis);


            produks.add(produkOracle);
            i++;
        }
        produkDAO.save(produks);*/

        mySQLHibernate.shutdown();
        oracleHibernate.shutdown();
    }
}
