package com.users.usermanaging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSystemDTO {
    public int id;
    public UserInfoAddressDTO address;
    public String phone;
}
