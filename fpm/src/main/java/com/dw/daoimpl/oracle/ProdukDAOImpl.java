package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.ProdukDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.ProdukOracle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class ProdukDAOImpl implements ProdukDAO {
    private OracleHibernate oracleHibernate;
    public ProdukDAOImpl(OracleHibernate oracleHibernate){
        this.oracleHibernate = oracleHibernate;
    }
    @Override
    public List<ProdukOracle> readProduk() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from ProdukOracle w");

        List<ProdukOracle> produkOracles = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof ProdukOracle) {
                    ProdukOracle w = (ProdukOracle) o;
                    produkOracles.add(w);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error parsing data");
            produkOracles.clear();
        } finally {
            session.close();
        }

        return produkOracles;
    }

    @Override
    public List<ProdukOracle> save(List<ProdukOracle> produkOracles) {
        Session session = oracleHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        boolean isValid = true;

        for (int i = 0; i < produkOracles.size(); i++) {
           ProdukOracle product = produkOracles.get(i);
            session.save(product);

            if (product == null) {
                transaction.rollback();
                isValid = false;

                break;
            } else {
                produkOracles.set(i, product);
            }
        }

        if (isValid) {
            transaction.commit();
        } else {
            produkOracles = null;
        }

        session.close();
        return produkOracles;
    }
}
