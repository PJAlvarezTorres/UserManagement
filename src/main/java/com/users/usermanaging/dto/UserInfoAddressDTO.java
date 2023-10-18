package com.users.usermanaging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoAddressDTO {

    public String street;
    public String street_name;
    public String city;
    public String state;
    public String country;
    public String country_code;
    public String postal_code;

}
