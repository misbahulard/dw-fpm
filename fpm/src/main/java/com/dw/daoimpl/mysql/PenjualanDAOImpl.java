package com.dw.daoimpl.mysql;

import com.dw.dao.mysql.PenjualanDAO;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.model.mysql.Penjualan;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class PenjualanDAOImpl implements PenjualanDAO {

    private MySQLHibernate mySQLHibernate;

    public PenjualanDAOImpl(MySQLHibernate mySQLHibernate) {
        this.mySQLHibernate= mySQLHibernate;
    }

    @Override
    public List<Penjualan> readPenjualan() {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery("select p from Penjualan p");

        List<Penjualan> penjualans = new ArrayList<>();

        try{
            for (Object o : query.getResultList()) {
                if (o instanceof Penjualan) {
                    Penjualan penjualan = (Penjualan) o;
                    penjualans.add(penjualan);
                } else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Eror parsing data!");
            penjualans.clear();
        }finally {
            session.close();
        }

        return penjualans;
    }
}
