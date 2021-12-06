package com.dvdrental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private long addressId;
    private String address;
    private String address2;
    private String district;
    private int cityId;
    private String postelCode;
    private String phone;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public Address(String address, String address2, String district, int cityId, String postelCode, String phone) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.cityId = cityId;
        this.postelCode = postelCode;
        this.phone = phone;
    }

    public Address() {
    }
}


