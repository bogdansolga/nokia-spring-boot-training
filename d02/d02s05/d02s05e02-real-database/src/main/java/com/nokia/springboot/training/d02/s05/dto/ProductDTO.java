package com.nokia.springboot.training.d02.s05.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO (Data Transfer Object) used to serialize / deserialize {@link Product} objects
 *
 * @author bogdan.solga
 */
public class ProductDTO implements Serializable {

    private int id;

    @NotNull(message = "The name cannot be null")
    @Pattern(regexp = "\\d", message = "Does not match the pattern")
    @Size(min = 10, max = 50, message = "Nope")
    private String productName;

    private String sectionName;

    public ProductDTO(int id, String sectionName, String name) {
        this.id = id; this.sectionName = sectionName; this.productName = name;
    }

    public ProductDTO(final int id, final String productName) {
        this.id = id; this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSectionName() {
        return sectionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }
}
