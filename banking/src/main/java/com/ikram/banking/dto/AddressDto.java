package com.ikram.banking.dto;

import com.ikram.banking.com.models.Address;
import com.ikram.banking.com.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressDto {
    private Integer id;
    private String street;
    private Integer houseNumber;
    private Integer zipCode;
    private String city;
    private String country;
    private Integer userId;

    public static AddressDto fromEntity(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .userId(address.getUsers().getId())
                .build();
    }

    public static Address toEntity(AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .street(addressDto.getStreet())
                .houseNumber(addressDto.getHouseNumber())
                .zipCode(addressDto.getZipCode())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .users(
                        User.builder()
                                .id(addressDto.getUserId())
                                .build()
                )
                .build();
    }

}
