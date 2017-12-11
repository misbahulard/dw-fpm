package com.dw.db.mysql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Method yang digunakan untuk membuka sesi user
     *
     * @return merupakan object sesi yang dibuka
     */
    public Session openSession() {
        return sessionFactory.openSession();
    }

    /**
     * Method yang digunakan untuk menutup koneksi dan menghapus instance
     */
    public void shutdown() {
        sessionFactory.close();
        sInstance = null;
    }
}
