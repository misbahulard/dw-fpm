package com.dw.model.oracle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
@Entity
@Table(name = "CUSTOMERS")
public class CustomersOracle implements Serializable {
    private int custId;
    private String custFirstName;
    private String custLastName;
    private String custGender;
    private Long custYearOfBirth;
    private String custMaritalStatus;
    private String custStreetAddress;
    private String custPostalCode;
    private String custCity;
    private String custStateProvince;
    private String countryId;
    private String custMainPhoneNumber;
    private String custIncomeLevel;
    private Long custCreditLimit;
    private String custEmail;

    @Id
    @Column(name = "CUST_ID", columnDefinition = "number")
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    @Column(name = "CUST_FIRST_NAME")
    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    @Column(name = "CUST_LAST_NAME")
    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }


    @Column(name = "CUST_GENDER")
    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }


    @Column(name = "CUST_YEAR_OF_BIRTH")
    public Long getCustYearOfBirth() {
        return custYearOfBirth;
    }

    public void setCustYearOfBirth(Long custYearOfBirth) {
        this.custYearOfBirth = custYearOfBirth;
    }

    @Column(name = "CUST_MARITAL_STATUS")
    public String getCustMaritalStatus() {
        return custMaritalStatus;
    }

    public void setCustMaritalStatus(String custMaritalStatus) {
        this.custMaritalStatus = custMaritalStatus;
    }


    @Column(name = "CUST_STREET_ADDRESS")
    public String getCustStreetAddress() {
        return custStreetAddress;
    }

    public void setCustStreetAddress(String custStreetAddress) {
        this.custStreetAddress = custStreetAddress;
    }


    @Column(name = "CUST_POSTAL_CODE")
    public String getCustPostalCode() {
        return custPostalCode;
    }

    public void setCustPostalCode(String custPostalCode) {
        this.custPostalCode = custPostalCode;
    }

    @Column(name = "CUST_CITY")
    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    @Column(name = "CUST_STATE_PROVINCE")
    public String getCustStateProvince() {
        return custStateProvince;
    }

    public void setCustStateProvince(String custStateProvince) {
        this.custStateProvince = custStateProvince;
    }


    @Column(name = "COUNTRY_ID")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }


    @Column(name = "CUST_MAIN_PHONE_NUMBER")
    public String getCustMainPhoneNumber() {
        return custMainPhoneNumber;
    }

    public void setCustMainPhoneNumber(String custMainPhoneNumber) {
        this.custMainPhoneNumber = custMainPhoneNumber;
    }


    @Column(name = "CUST_INCOME_LEVEL")
    public String getCustIncomeLevel() {
        return custIncomeLevel;
    }

    public void setCustIncomeLevel(String custIncomeLevel) {
        this.custIncomeLevel = custIncomeLevel;
    }


    @Column(name = "CUST_CREDIT_LIMIT")
    public Long getCustCreditLimit() {
        return custCreditLimit;
    }

    public void setCustCreditLimit(Long custCreditLimit) {
        this.custCreditLimit = custCreditLimit;
    }

    @Column(name = "CUST_EMAIL")
    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

}
