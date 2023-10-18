package com.users.usermanaging.dto;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
