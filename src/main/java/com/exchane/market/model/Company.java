package com.exchane.market.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Company {

    @Id
    private String id;
    private String name;

    private String link;

    public Company(String name, String link) {
        this.name= name;
        this.link=link;
    }
}
