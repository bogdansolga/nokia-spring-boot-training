package com.nokia.springboot.training.d02.s05.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Section")
public class StoreSection extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "section_sequence_generator")
    @SequenceGenerator(name = "section_sequence_generator", sequenceName = "section_sequence",
            allocationSize = 1)
    private int id;

    @Column(name = "name", length = 40)
    private String sectionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeid")
    private Store store;

    // 'mappedby' tells the persistence provider that the join column is in the Product table
    @OneToMany(mappedBy = "storeSection", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy(value = "name")
    private Set<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreSection)) return false;
        StoreSection that = (StoreSection) o;
        return id == that.id &&
                Objects.equals(sectionName, that.sectionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sectionName);
    }
}
