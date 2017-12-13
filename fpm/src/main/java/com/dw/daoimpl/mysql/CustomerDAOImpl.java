package com.dw.daoimpl.mysql;

import com.dw.dao.mysql.CustomerDAO;
import com.dw.db.mysql.MySQLHibernate;
import com.dw.model.mysql.Customer;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public class CustomerDAOImpl implements CustomerDAO {

    private MySQLHibernate mySQLHibernate;

    public CustomerDAOImpl(MySQLHibernate mySQLHibernate) {

        this.mySQLHibernate = mySQLHibernate;
    }
    @Override
    public List<Customer> readCustomer() {
        Session session = mySQLHibernate.openSession();
        Query query = session.createQuery("select w from Customer w");

        List<Customer> customers = new ArrayList<>();

        try{
            for (Object o : query.getResultList()) {
                if (o instanceof Customer) {
                    Customer w = (Customer) o;
                    customers.add(w);
                } else {
                    throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Eror parsing data!");
            customers.clear();
        }finally {
            session.close();
        }

        return customers;
    }
}
