package com.nokia.springboot.training.d02.s05.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Product")
@NamedQuery(
        name = "Product.bySection",
        query = "SELECT product " +
                "FROM Product product " +
                "WHERE product.storeSection.store.id = :storeId"
)
public class Product extends AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "product_sequence_generator")
    @SequenceGenerator(name = "product_sequence_generator", sequenceName="product_sequence",
            allocationSize = 1)
    private int id;

    @Column(name = "name", unique = true, nullable = false, insertable = true, updatable = false, length = 50)
    private String name;

    @ManyToOne(targetEntity = StoreSection.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionid", referencedColumnName = "id")
    private StoreSection storeSection;

    public Product() {
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoreSection getStoreSection() {
        return storeSection;
    }

    public void setStoreSection(StoreSection storeSection) {
        this.storeSection = storeSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(storeSection, product.storeSection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, storeSection);
    }

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
