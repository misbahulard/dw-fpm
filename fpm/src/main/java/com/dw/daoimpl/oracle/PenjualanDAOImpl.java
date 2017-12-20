package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.PenjualanDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.PenjualanOracle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class PenjualanDAOImpl implements PenjualanDAO{

    private OracleHibernate oracleHibernate;

    public  PenjualanDAOImpl(OracleHibernate oracleHibernate){
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<PenjualanOracle> readProducts() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from ProductsOracle w");

        List<PenjualanOracle> penjualanOracle = new ArrayList<>();
        try{
            for (Object o : query.getResultList()){
                if(o instanceof PenjualanOracle){
                    PenjualanOracle p = (PenjualanOracle) o;
                    penjualanOracle.add(p);
                }else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Error pasring data");

        }finally {
            session.close();
        }
        return  penjualanOracle;
    }

    @Override
    public List<PenjualanOracle> save(List<PenjualanOracle> penjualanOracles) {
        Session session = oracleHibernate.openSession();
        Transaction transaction = session.beginTransaction();

        boolean isValid = true;

        int counter = 0;
        for (int i = 0; i < penjualanOracles.size(); i++) {
            PenjualanOracle penjualan = penjualanOracles.get(i);
            session.save(penjualan);

            if (penjualan == null) {
                transaction.rollback();
                isValid = false;

                break;
            } else {
                if (counter == 1000) {
                    counter = 0;
                    System.out.println("COMMITED!!!!");
                    transaction.commit();
                    transaction = session.beginTransaction();
                }
//                System.out.println("Penjualan id : " + penjualan.getId());
                penjualanOracles.set(i, penjualan);
            }
            counter++;
        }

        if (isValid) {
            transaction.commit();
        } else {
            penjualanOracles = null;
        }

        session.close();
        return penjualanOracles;
    }
}
