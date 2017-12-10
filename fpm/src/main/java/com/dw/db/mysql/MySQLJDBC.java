package com.dw.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class yang digunakan untuk mengatur koneksi ke database MySQL
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 December 2017
 */
public class MySQLJDBC {

    /**
     * Merupakan instance dari class OracleJDBC
     */
    private static MySQLJDBC sInstance = null;

    /**
     * Merupakan object connection
     */
    private Connection connection;

    /**
     * Merupakan data source yang digunakan untuk membuat koneksi ke database
     */
    private String dbName, userName, userPassword;

    /**
     * Merupakan default constructor dari class OracleJDBC
     *
     * @param dbName merupakan nama database
     * @param userName merupakan username pengguna database
     * @param userPassword merupakan password dari pengguna database
     */
    private MySQLJDBC(String dbName, String userName, String userPassword) {
        this.dbName = dbName;
        this.userName = userName;
        this.userPassword = userPassword;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Mencari class driver yang dibutuhkan

            System.out.println("Load Driver Class Success");
            setConnection(); // Membuat koneksi ke database
        } catch (ClassNotFoundException e) { // Jika class tidak ditemukan
            System.out.println("Failed to load Driver Class"); // Menampilkan pesan error
            System.exit(1); // Memberhentikan program
        }
    }

    /**
     * Method untuk membuat instance dari class OracleJDBC, agar instance dan koneksi yang ada tidak banyak dibuat
     *
     * @param dbName merupakan nama database
     * @param userName merupakan username pengguna database
     * @param userPassword merupakan password dari pengguna database
     * @return merupakan instance dari class OracleJDBC
     */
    public static MySQLJDBC getsInstance(String dbName, String userName, String userPassword) {
        if (sInstance == null) {
            sInstance = new MySQLJDBC(dbName, userName, userPassword);
        }

        return sInstance;
    }

    /**
     * Method yang digunakan untuk membuat koneksi ke database
     */
    private void setConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, userPassword);

            System.out.println("Create connection success");
        } catch (Exception e) {
            System.out.println("Failed to create connection");
            System.exit(1); // Memberhentikan program
        }
    }

    /**
     * Method yang digunakan untuk mengambil object koneksi database
     *
     * @return merupakan object koneksi database
     */
    private Connection getConnection() {
        return connection;
    }
}
