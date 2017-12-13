package com.dw.daoimpl.oracle;

import com.dw.dao.mysql.CustomerDAO;
import com.dw.dao.oracle.CustomersOrclDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.CustomersOracle;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class CustomerOrclDAOImpl implements CustomersOrclDAO {
    private OracleHibernate oracleHibernate;

    public  CustomerOrclDAOImpl(OracleHibernate oracleHibernate){
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<CustomersOracle> readCustomerOrcl() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select w from CustomersOracle w");

        List<CustomersOracle> customersOracles = new ArrayList<>();
        try{
            for (Object o : query.getResultList()){
                if(o instanceof CustomersOracle){
                    CustomersOracle p = (CustomersOracle) o;
                    customersOracles.add(p);
                }else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Error pasring data");

        }finally {
            session.close();
        }
        return  customersOracles;
    }
}
