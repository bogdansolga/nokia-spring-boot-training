package com.nokia.springboot.training.d03.s04.endpoint;

import java.io.Serializable;

public class MemoryInfo implements Serializable {

    private static final int MB = 1024 * 1024;

    private final String freeMemory;

    private final String usedMemory;

    public MemoryInfo(final long usedMemory, final long freeMemory) {
        this.usedMemory = usedMemory / MB + " MB"; this.freeMemory = freeMemory / MB + " MB";
    }

    public final String getFreeMemory() {
        return freeMemory;
    }

    public final String getUsedMemory() {
        return usedMemory;
    }
}
