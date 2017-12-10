package com.dw.model.mysql;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_customer",
        indexes = { @Index(name = "idx_t_customer", columnList = "id, jenis, kota") })
@Entity
public class Customer implements Serializable {
}
