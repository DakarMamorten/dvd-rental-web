package com.dvdrental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private long categoryID;
    private String name;
    @Column(name = "last_update")
    private String lastUpdate;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
