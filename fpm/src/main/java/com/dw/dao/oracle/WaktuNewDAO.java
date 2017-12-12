package com.dw.dao.oracle;

import com.dw.model.oracle.WaktuNewOracle;

import java.util.List;

public interface WaktuNewDAO {
    public List<WaktuNewOracle> readWaktu();

    public List<WaktuNewOracle> save(List<WaktuNewOracle> waktuNewOracles);
}
