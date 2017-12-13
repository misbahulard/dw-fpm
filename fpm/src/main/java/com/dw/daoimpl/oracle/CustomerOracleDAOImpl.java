package com.dw.daoimpl.oracle;

import com.dw.dao.oracle.CustomersOracleDAO;
import com.dw.db.oracle.OracleHibernate;
import com.dw.model.oracle.CustomersOracle;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class CustomerOracleDAOImpl implements CustomersOracleDAO {

    private OracleHibernate oracleHibernate;

    public CustomerOracleDAOImpl(OracleHibernate oracleHibernate) {
        this.oracleHibernate = oracleHibernate;
    }

    @Override
    public List<CustomersOracle> readCustomerOracle() {
        Session session = oracleHibernate.openSession();
        Query query = session.createQuery("select co from CustomersOracle co");

        List<CustomersOracle> customersOracles = new ArrayList<>();

        try {
            for (Object o : query.getResultList()) {
                if (o instanceof CustomersOracle) {
                    CustomersOracle customersOracle = (CustomersOracle) o;
                    customersOracles.add(customersOracle);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error pasring data");
        } finally {
            session.close();
        }

        return customersOracles;
    }
}
