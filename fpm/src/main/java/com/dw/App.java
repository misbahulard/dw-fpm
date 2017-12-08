package com.dw;

import com.dw.db.oracle.DbConnection;

/**
 * Merupakan main class dari aplikasi
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 December 2017
 */
public class App 
{
    private final static String DB_NAME = "dw_fpm";
    private final static String USER_NAME = "root";
    private final static String USER_PASSWORD = "";

    /**
     * Method main dari aplikasi
     *
     * @param args merupakan argumen aplikasi
     */
    public static void main( String[] args )
    {
        DbConnection dbConnection = DbConnection.getsInstance(DB_NAME, USER_NAME, USER_PASSWORD);
    }
}
