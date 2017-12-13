package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.ProductsDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.ProductsOracle;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class ProductsDAOImpl implements ProductsDAO{
    private OracleHibernate oracleHibernate;

    public  ProductsDAOImpl(OracleHibernate oracleHibernate){
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<ProductsOracle> readProducts() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from ProductsOracle w");

        List<ProductsOracle> productsOracles = new ArrayList<>();
        try{
            for (Object o : query.getResultList()){
                if(o instanceof ProductsOracle){
                    ProductsOracle p = (ProductsOracle) o;
                    productsOracles.add(p);
                }else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Error pasring data");

        }finally {
            session.close();
        }
        return  productsOracles;
    }

    @Override
    public List<ProductsOracle> save(List<ProductsOracle> productsOracles) {
        return null;
    }
}
