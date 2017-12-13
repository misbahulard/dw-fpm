package com.dw.daoimpl.mysql;

import com.dw.dao.mysql.JualDAO;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.model.mysql.Penjualan;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class JualDAOImpl implements JualDAO {
    private MySQLHibernate mySQLHibernate;
    public JualDAOImpl(MySQLHibernate mySQLHibernate)
    {
        this.mySQLHibernate= mySQLHibernate;
    }

    @Override
    public List<Penjualan> readJual() {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery("select a from Penjualan a ");

        List<Penjualan> juals = new ArrayList<>();

        try{
            for (Object o : query.getResultList()) {
                if (o instanceof Penjualan) {
                    Penjualan w = (Penjualan) o;
                    juals.add(w);
                } else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Eror parsing data!");
            juals.clear();
        }finally {
            session.close();
        }

        return juals;
    }
}
