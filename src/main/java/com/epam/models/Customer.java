package com.epam.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
    @Id
    private long id;
    private String name;



    // TODO Add Clear constructor and override toString
}
