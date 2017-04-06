package com.nokia.springboot.training.d02.s05.dto;

import java.io.Serializable;
import java.util.Set;

public class StoreDTO implements Serializable {
    private final int id;
    private final String name;
    private final Set<String> storeSectionNames;

    public StoreDTO(int id, String name, Set<String> storeSectionNames) {
        this.id = id;
        this.name = name;
        this.storeSectionNames = storeSectionNames;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getStoreSectionNames() {
        return storeSectionNames;
    }
}
