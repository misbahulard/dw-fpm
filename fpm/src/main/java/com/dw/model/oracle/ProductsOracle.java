package com.dw.model.oracle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "products")
public class ProductsOracle implements Serializable {
    @Id
    @Column(name = "prod_id", columnDefinition = "number(6)")
    private int prodId;
    @Column(name = "prod_name", columnDefinition = "varchar2(50)")
    private  String prodName;
    @Column(name = "prod_desc", columnDefinition = "varchar2(4000")
    private  String prodDesc;
    @Column(name = "prod_subcategory", columnDefinition = "varchar2(50)")
    private String prodSubcategory;
    @Column(name = "prod_subcat_desc", columnDefinition = "varchar2(2000")
    private String prodSubcatDesc;
    @Column(name = "prod_category", columnDefinition = "varchar2(50)")
    private String prodcategory;
    @Column(name = "prod_cat_desc", columnDefinition = "varchar2(2000)")
    private String prodCatDesc;
    @Column(name = "prod_weight_class", columnDefinition = "number(2)")
    private int prodWeightClass;
    @Column(name = "prod_unit_of_measure", columnDefinition = "varchar(20)")
    private String prodUnitOfMeasure;
    @Column(name = "prod_pack_size", columnDefinition = "varchar2(30)")
    private String prodPackSize;
    @Column(name = "supplier_id", columnDefinition = "number(6)")
    private  int supplierId;
    @Column(name = "prod_status", columnDefinition = "varchar2(20)")
    private  String prodStatus;
    @Column(name = "prod_list_price", columnDefinition = "number(8)")
    private int prodListPrice;
    @Column(name = "prod_min_price", columnDefinition = "number(8)")
    private int prodMinPrice;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdSubcategory() {
        return prodSubcategory;
    }

    public void setProdSubcategory(String prodSubcategory) {
        this.prodSubcategory = prodSubcategory;
    }

    public String getProdSubcatDesc() {
        return prodSubcatDesc;
    }

    public void setProdSubcatDesc(String prodSubcatDesc) {
        this.prodSubcatDesc = prodSubcatDesc;
    }

    public String getProdcategory() {
        return prodcategory;
    }

    public void setProdcategory(String prodcategory) {
        this.prodcategory = prodcategory;
    }

    public String getProdCatDesc() {
        return prodCatDesc;
    }

    public void setProdCatDesc(String prodCatDesc) {
        this.prodCatDesc = prodCatDesc;
    }

    public int getProdWeightClass() {
        return prodWeightClass;
    }

    public void setProdWeightClass(int prodWeightClass) {
        this.prodWeightClass = prodWeightClass;
    }

    public String getProdUnitOfMeasure() {
        return prodUnitOfMeasure;
    }

    public void setProdUnitOfMeasure(String prodUnitOfMeasure) {
        this.prodUnitOfMeasure = prodUnitOfMeasure;
    }

    public String getProdPackSize() {
        return prodPackSize;
    }

    public void setProdPackSize(String prodPackSize) {
        this.prodPackSize = prodPackSize;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(String prodStatus) {
        this.prodStatus = prodStatus;
    }

    public int getProdListPrice() {
        return prodListPrice;
    }

    public void setProdListPrice(int prodListPrice) {
        this.prodListPrice = prodListPrice;
    }

    public int getProdMinPrice() {
        return prodMinPrice;
    }

    public void setProdMinPrice(int prodMinPrice) {
        this.prodMinPrice = prodMinPrice;
    }
}
