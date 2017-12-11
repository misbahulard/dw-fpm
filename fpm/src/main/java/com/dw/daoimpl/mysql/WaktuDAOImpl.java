package com.dw.daoimpl.mysql;

import com.dw.dao.mysql.WaktuDAO;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.model.mysql.Waktu;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class WaktuDAOImpl implements WaktuDAO {

    private MySQLHibernate mySQLHibernate;

    public WaktuDAOImpl(MySQLHibernate mySQLHibernate) {
        this.mySQLHibernate = mySQLHibernate;
    }

    @Override
    public List<Waktu> readWaktu() {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery("select w from Waktu w");

        List<Waktu> waktus = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof Waktu) {
                    Waktu w = (Waktu) o;
                    waktus.add(w);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing data");
            waktus.clear();
        } finally {
            session.close();
        }

        return waktus;
    }
}
