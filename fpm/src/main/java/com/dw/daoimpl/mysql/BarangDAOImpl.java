package com.dw.daoimpl.mysql;

import com.dw.dao.mysql.BarangDAO;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.model.mysql.Barang;
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
    public Barang readBarang(String id, String jnsPsr) {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery(
                "select b from Barang b " +
                        "where b.id = :id and b.jnsPsr = :jnsPsr"
        );

        query.setParameter("id", id);
        query.setParameter("jnsPsr", jnsPsr);

        List barangs = query.getResultList();
        Barang barang = null;

        if (barangs.size() != 0)
            barang = (Barang) barangs.get(0);

        session.close();

        return barang;
    }

    @Override
    public Barang readBarang(Barang barang) {
        return readBarang(barang.getId(), barang.getJnsPsr());
    }

    @Override
    public List<Barang> readBarang() {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery("select b from Barang b");

        List<Barang> barangs = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof Barang) {
                    Barang b = (Barang) o;
                    barangs.add(b);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing data");
            barangs.clear();
        } finally {
            session.close();
        }

        return barangs;
    }

    @Override
    public Barang save(Barang barang) {
        Session session = mySQLHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            barang = (Barang) session.save(barang);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error saving data");

            barang = null;
            transaction.rollback();
        } finally {
            session.close();
        }

        return barang;
    }

    @Override
    public List<Barang> save(List<Barang> barangs) {
        Session session = mySQLHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        boolean isValid = true;

        for (int i = 0; i < barangs.size(); i++) {
            Barang barang = barangs.get(i);
            barang = (Barang) session.save(barang);

            if (barang == null) {
                transaction.rollback();
                isValid = false;

                break;
            } else {
                barangs.set(i, barang);
            }
        }

        if (isValid) {
            transaction.commit();
        } else {
            barangs = null;
        }

        session.close();
        return barangs;
    }

    @Override
    public Barang update(Barang barang) {
        return null;
    }

    @Override
    public List<Barang> update(List<Barang> barangs) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public boolean deleteByJnsPsr(String jnsPsr) {
        return false;
    }

    @Override
    public boolean delete(String id, String jnsPsr) {
        return false;
    }

    @Override
    public boolean delete(Barang barang) {
        return false;
    }

    @Override
    public boolean delete(List<Barang> barangs) {
        return false;
    }
}
