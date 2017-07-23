package com.epam.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "items")
public class Item {
    @Id
    private long id;
    private List<Product> products;

    public Item(long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
