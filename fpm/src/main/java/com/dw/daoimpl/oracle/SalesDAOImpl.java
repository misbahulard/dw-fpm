package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.SalesDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.SalesOracle;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class SalesDAOImpl implements SalesDAO{

    private OracleHibernate oracleHibernate;

    public  SalesDAOImpl(OracleHibernate oracleHibernate){
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<SalesOracle> readSales() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from SalesOracle w");

        List<SalesOracle> salesOracles = new ArrayList<>();
        try{
            for (Object o : query.getResultList()){
                if(o instanceof SalesOracle){
                    SalesOracle p = (SalesOracle) o;
                    salesOracles.add(p);
                }else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error pasring data");

        }finally {
            session.close();
        }
        return  salesOracles;
    }
}
