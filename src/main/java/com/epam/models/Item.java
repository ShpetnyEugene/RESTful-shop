package com.epam.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {
    @Id
    private long id;
    private int price;

    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item() {
    }

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
