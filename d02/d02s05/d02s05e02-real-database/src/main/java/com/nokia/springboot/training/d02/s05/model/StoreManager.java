package com.nokia.springboot.training.d02.s05.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "StoreManager")
public class StoreManager extends AbstractEntity {

    @EmbeddedId
    private StoreManagerPK storeManagerPK;

    public StoreManagerPK getStoreManagerPK() {
        return storeManagerPK;
    }

    public void setStoreManagerPK(StoreManagerPK storeManagerPK) {
        this.storeManagerPK = storeManagerPK;
    }
}
