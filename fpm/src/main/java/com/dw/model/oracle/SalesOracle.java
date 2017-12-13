package com.dw.model.oracle;

import javax.persistence.*;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "SALES_NEW")
public class SalesOracle {


    @Basic
    @Column(name = "PROD_ID")
    private int prodId;


    @Basic
    @Column(name = "CUST_ID")
    private  int custId;

    @Column(name = "TIME_ID")
    private int timeId;


    @Basic
    @Column(name = "QUANTITY_SOLD")
    private int quantitySold;



    @Id
    @Column(name = "ID")
    private int id;
    public int getId() {return id; }

    public void setId(int id) { this.id = id;}

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }


}
