package com.dw.util;

import com.dw.dao.mysql.CustomerDAO;
import com.dw.dao.oracle.CustomersOracleDAO;
import com.dw.dao.oracle.PelangganDAO;
import com.dw.daoimpl.mysql.CustomerDAOImpl;
import com.dw.daoimpl.oracle.CustomerOracleDAOImpl;
import com.dw.daoimpl.oracle.PelangganDAOImpl;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Customer;
import com.dw.model.oracle.CustomersOracle;
import com.dw.model.oracle.PelangganOracle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class InsertCustomer {
    public static void newTransaction() {
        MySQLHibernate mySQLHibernate = MySQLHibernate.getsInstance();
        OracleHibernate oracleHibernate = OracleHibernate.getsInstance();

        CustomerDAO customerDAO = new CustomerDAOImpl(mySQLHibernate);
        CustomersOracleDAO customersOracleDAO = new CustomerOracleDAOImpl(oracleHibernate);
        PelangganDAO pelangganDAO = new PelangganDAOImpl(oracleHibernate);

        List<PelangganOracle> pelanggans = new ArrayList<>();

        List<Customer> customers = customerDAO.readCustomer();
        for (Customer w : customers) {
            int id = w.getIdNew();
            String nama = w.getNama();
            String alamat = w.getAlamat();
            String kota = w.getKota();

            if (alamat == null || alamat.equals("")) {
                alamat = "-";
            }

            if (kota == null || kota.equals("")) {
                kota = "-";
            }

            PelangganOracle pelangganOracle = new PelangganOracle();
            pelangganOracle.setNoPelanggan(id);
            pelangganOracle.setNamaPelanggan(nama);
            pelangganOracle.setAlamatPelanggan(alamat);
            pelangganOracle.setKotaPelanggan(kota);

            pelanggans.add(pelangganOracle);
        }
        pelangganDAO.save(pelanggans);

        /*pelanggans.clear();

        List<CustomersOracle> customersO = customersOracleDAO.readCustomerOracle();
        for (CustomersOracle w : customersO) {
            int id = w.getCustId();
            String nama = w.getCustFirstName();
            String alamat = w.getCustStreetAddress();
            String kota = w.getCustCity();
            //System.out.println(id);
            PelangganOracle pelangganOracle = new PelangganOracle();
            pelangganOracle.setNoPelanggan(id);
            pelangganOracle.setNamaPelanggan(nama);
            pelangganOracle.setAlamatPelanggan(alamat);
            pelangganOracle.setKotaPelanggan(kota);

            pelanggans.add(pelangganOracle);
        }
        pelangganDAO.save(pelanggans);
        pelanggans.clear();*/

        mySQLHibernate.shutdown();
        oracleHibernate.shutdown();
    }
}
