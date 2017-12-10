package com.dw.db.mysql;

import com.dw.db.oracle.OracleHibernate;
import com.dw.model.mysql.Barang;
import com.dw.model.mysql.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class MySQLHibernate {

    /**
     * Merupakan instance dari class MySQLHibernate
     */
    private static MySQLHibernate sInstance = null;

    /**
     * Merupakan object session factory untuk melakukan operasi ke db
     */
    private SessionFactory sessionFactory;

    /**
     * Merupakan default constructor dari class MySQLHibernate
     */
    private MySQLHibernate() {
        sessionFactory = buildSessionFactory();
    }

    /**
     * Method untuk membuat instance dari class MySQLHibernate, agar instance dan koneksi yang ada tidak banyak dibuat
     *
     * @return merupakan instance dari class MySQLHibernate
     */
    public static MySQLHibernate getsInstance() {
        if (sInstance == null) {
            sInstance = new MySQLHibernate();
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
            return new Configuration().configure("hibernate.mysql.cfg.xml").buildSessionFactory();
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

    public ArrayList<Barang> readBarang() {
        Session session = getSessionFactory().openSession();

        Query query = session.createQuery("select b from Barang b");
        List list = query.list();

//        for (Object o : list) {
//            Barang b = (Barang) o;
//
//            System.out.println(b.getId() + b.getNama() + b.getJnsBrg());
//        }

        session.close();
        ArrayList<Barang> barangs = new ArrayList<>(list);
        return barangs;
    }

    /**
     * Method yang digunakan untuk menutup koneksi dan menghapus instance
     */
    public void shutdown() {
        sessionFactory.close();
        sInstance = null;
    }
}
