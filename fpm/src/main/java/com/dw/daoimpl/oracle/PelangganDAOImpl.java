package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.PelangganDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.PelangganOracle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class PelangganDAOImpl implements PelangganDAO {

    private OracleHibernate oracleHibernate;

    public PelangganDAOImpl(OracleHibernate oracleHibernate){
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<PelangganOracle> readPelangganOracles() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select po from PelangganOracle po");

        List<PelangganOracle> pelangganOracles = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof PelangganOracle) {
                    PelangganOracle pelangganOracle = (PelangganOracle) o;
                    pelangganOracles.add(pelangganOracle);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing data");
            pelangganOracles.clear();
        } finally {
            session.close();
        }

        return pelangganOracles;
    }

    @Override
    public List<PelangganOracle> save(List<PelangganOracle> pelangganOracles) {
        Session session = oracleHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        boolean isValid = true;

        for (int i = 0; i < pelangganOracles.size(); i++) {
            PelangganOracle pelanggan = pelangganOracles.get(i);
            session.save(pelanggan);

            if (pelanggan == null) {
                transaction.rollback();
                isValid = false;

                break;
            } else {
                pelangganOracles.set(i, pelanggan);
            }
        }

        if (isValid) {
            transaction.commit();
        } else {
            pelangganOracles = null;
        }

        session.close();
        return pelangganOracles;
    }
}
