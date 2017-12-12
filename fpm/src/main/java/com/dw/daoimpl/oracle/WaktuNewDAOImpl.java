package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.WaktuNewDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.WaktuNewOracle;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class WaktuNewDAOImpl implements WaktuNewDAO {
    private OracleHibernate oracleHibernate;

    public WaktuNewDAOImpl(OracleHibernate oracleHibernate) {
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<WaktuNewOracle> readWaktu() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from WaktuNewOracle w");

        List<WaktuNewOracle> waktuNewOracles = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof WaktuNewOracle) {
                    WaktuNewOracle w = (WaktuNewOracle) o;
                    waktuNewOracles.add(w);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing data");
            waktuNewOracles.clear();
        } finally {
            session.close();
        }

        return waktuNewOracles;
    }

    @Override
    public List<WaktuNewOracle> save(List<WaktuNewOracle> waktuNewOracles) {
        return null;
    }
}
