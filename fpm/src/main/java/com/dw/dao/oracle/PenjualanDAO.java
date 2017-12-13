package com.dw.dao.oracle;

import com.dw.model.oracle.PenjualanOracle;
import com.dw.model.oracle.SalesOracle;

import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public interface PenjualanDAO {
    public List<PenjualanOracle> readProducts();
    public List<PenjualanOracle> save(List<PenjualanOracle> penjualanOracles);
}
