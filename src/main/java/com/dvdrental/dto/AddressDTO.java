package com.dvdrental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private long addressId;
    private String address;
    private String address2;
    private String district;
    private int cityId;
    private String postelCode;
    private String phone;
    private String lastUpdate;

    public AddressDTO(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
