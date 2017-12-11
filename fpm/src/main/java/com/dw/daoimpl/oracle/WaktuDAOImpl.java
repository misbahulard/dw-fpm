package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.WaktuDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.WaktuOracle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class WaktuDAOImpl implements WaktuDAO {

    private OracleHibernate oracleHibernate;

    public WaktuDAOImpl(OracleHibernate oracleHibernate) {
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<WaktuOracle> readWaktu() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from WaktuOracle w");

        List<WaktuOracle> waktuOracles = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof WaktuOracle) {
                    WaktuOracle w = (WaktuOracle) o;
                    waktuOracles.add(w);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing data");
            waktuOracles.clear();
        } finally {
            session.close();
        }

        return waktuOracles;
    }

    @Override
    public List<WaktuOracle> save(List<WaktuOracle> waktuOracles) {
        Session session = oracleHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        boolean isValid = true;

        for (int i = 0; i < waktuOracles.size(); i++) {
            WaktuOracle waktuOracle = waktuOracles.get(i);
            session.save(waktuOracle);

            if (waktuOracle == null) {
                transaction.rollback();
                isValid = false;

                break;
            } else {
                waktuOracles.set(i, waktuOracle);
            }
        }

        if (isValid) {
            transaction.commit();
        } else {
            waktuOracles = null;
        }

        session.close();
        return waktuOracles;
    }
}
