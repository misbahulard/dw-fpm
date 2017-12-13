package com.dw.daoimpl.mysql;

import com.dw.dao.mysql.BarangDAO;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.model.mysql.Barang;
import com.dw.model.mysql.Waktu;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BarangDAOImpl implements BarangDAO {

    private MySQLHibernate mySQLHibernate;

    public BarangDAOImpl(MySQLHibernate mySQLHibernate) {
        this.mySQLHibernate = mySQLHibernate;
    }

    @Override
    public List<Barang> readBarang() {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery("select b from Barang b");

        List<Barang> barangs = new ArrayList<>();

        try{
            for (Object o : query.getResultList()) {
                if (o instanceof Barang) {
                    Barang barang = (Barang) o;
                    barangs.add(barang);
                } else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Eror parsing data!");
            barangs.clear();
        }finally {
            session.close();
        }

        return barangs;
    }
}
