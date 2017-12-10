package com.dw.db.oracle;

import com.dw.model.oracle.Produk;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Class yang digunakan untuk membuat koneksi ke database dengan JPA
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 December 2017
 */
public class OracleHibernate {

    /**
     * Merupakan instance dari class OracleHibernate
     */
    private static OracleHibernate sInstance = null;

    /**
     * Merupakan object session factory untuk melakukan operasi ke db
     */
    private SessionFactory sessionFactory;

    /**
     * Merupakan default constructor dari class OracleHibernate
     */
    private OracleHibernate() {
        sessionFactory = buildSessionFactory();
    }

    /**
     * Method untuk membuat instance dari class OracleHibernate, agar instance dan koneksi yang ada tidak banyak dibuat
     *
     * @return merupakan instance dari class OracleHibernate
     */
    public static OracleHibernate getsInstance() {
        if (sInstance == null) {
            sInstance = new OracleHibernate();
        }

        return sInstance;
    }

    /**
     * Method yang digunakan untuk membuat object session factory dengan file konfigurasi mysql yang telah dibuat
     *
     * @return merupakan object session factory
     */
    private SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.oracle.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Method yang digunakan untuk mengambil object session factory
     *
     * @return merupakan object session factory
     */
    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public boolean insertProduk(ArrayList<Produk> produks) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        boolean isSuccess = true;

        try {
            for (int i = 0; i < produks.size(); i++) {
                Produk produk = produks.get(i);
                session.save(produk);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }


        session.close();
        return isSuccess;
    }

    /**
     * Method yang digunakan untuk menutup koneksi dan menghapus instance
     */
    public void shutdown() {
        sessionFactory.close();
        sInstance = null;
    }
}
