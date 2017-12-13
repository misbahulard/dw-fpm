package com.dw.dao.oracle;

import com.dw.model.oracle.SalesOracle;

import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public interface SalesDAO {
    public List<SalesOracle> readSales();
}
