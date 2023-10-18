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
public class UserInfoDTO {

    public int id;
    public String first_name;
    public String last_name;
    public String email;
    public String gender;
    public String birthdate;
    public String company_name;
    public String department;
    public String job_title;
    public ArrayList<UserInfoAddressDTO> address;
    public String phone;
    public String avatar;
    public boolean email_verified;
    public String password;
    public String last_login;
    public String last_login_ip;
    public boolean subscribed;

}
