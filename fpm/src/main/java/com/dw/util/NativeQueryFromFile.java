package com.dw.util;

import com.dw.db.mysql.MySQLHibernate;
import com.dw.db.oracle.OracleHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.*;

public class NativeQueryFromFile {

    public static void insertFromFile(String filePath, MySQLHibernate mySQLHibernate) {
        Session session = mySQLHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";

            while (str != null) {
                str = br.readLine();

                if (str != null && !str.equals(""))
                    session.createNativeQuery(str).executeUpdate();
            }
        } catch (FileNotFoundException e) {
            transaction.rollback();
            System.out.println("File tidak ditemukan");
        } catch (IOException e) {
            transaction.rollback();
            System.out.println("Kesalahan saat membaca file");
        } finally {
            session.close();
        }
    }

    public static void insertFromFile(String filePath, OracleHibernate oracleHibernate) {
        Session session = oracleHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";

            while (str != null) {
                str = br.readLine();

                if (str != null && !str.equals(""))
                    session.createNativeQuery(str).executeUpdate();
            }
        } catch (FileNotFoundException e) {
            transaction.rollback();
            System.out.println("File tidak ditemukan");
        } catch (IOException e) {
            transaction.rollback();
            System.out.println("Kesalahan saat membaca file");
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public static void insertFromFileDat(String filePath, OracleHibernate oracleHibernate, String tableName) {
        Session session = oracleHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";

            while (str != null) {
                str = br.readLine();

                String sql = "INSERT INTO " + tableName + " VALUES (";

                if (str != null && !str.equals("")) {
                    String[] strings = str.split("\\|");

                    for (int i = 0; i < strings.length; i++) {
                        sql += ":parameter" + i;

                        if (i != (strings.length - 1))
                            sql += ", ";
                    }

                    sql += ")";

                    NativeQuery nativeQuery = session.createNativeQuery(sql);

                    for (int i = 0; i < strings.length; i++) {
                        String newStr = "\'" + strings[i].replace("\'", "\'\'") + "\'";
                        nativeQuery.setParameter("parameter" + i, newStr);
                    }

                    nativeQuery.executeUpdate();
                }
            }
        } catch (FileNotFoundException e) {
            transaction.rollback();
            System.out.println("File tidak ditemukan");
        } catch (IOException e) {
            transaction.rollback();
            System.out.println("Kesalahan saat membaca file");
        } finally {
            transaction.commit();
            session.close();
        }
    }
}
