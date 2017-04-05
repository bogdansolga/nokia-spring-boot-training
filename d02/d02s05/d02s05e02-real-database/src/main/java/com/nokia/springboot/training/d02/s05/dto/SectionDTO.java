package com.nokia.springboot.training.d02.s05.dto;

import java.io.Serializable;
import java.util.List;

public class SectionDTO implements Serializable {

    private final int id;
    private final String sectionName;
    private final String storeName;
    private final List<String> productNames;

    public SectionDTO(int id, String sectionName,
                      String storeName, List<String> products) {
        this.id = id;
        this.sectionName = sectionName;
        this.storeName = storeName;
        this.productNames = products;
    }

    public int getId() {
        return id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getStoreName() {
        return storeName;
    }

    public List<String> getProductNames() {
        return productNames;
    }
}
