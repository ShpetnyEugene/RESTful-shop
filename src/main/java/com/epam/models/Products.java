package com.epam.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Products {
    @Id
    private long id;
    private String name;
    private int price;


}
