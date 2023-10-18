package com.users.usermanaging.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfoAddressDTO {

    public String street;
    public String street_name;
    public String city;
    public String state;
    public String country;
    public String country_code;
    public String postal_code;

}
