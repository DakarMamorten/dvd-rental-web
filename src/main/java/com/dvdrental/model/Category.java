package com.dvdrental.model;

import lombok.Data;

@Data
public class Category {
    private long categoryID;
    private String name;
    private String localDateTime;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
