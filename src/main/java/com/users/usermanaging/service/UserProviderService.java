package com.users.usermanaging.service;

import com.users.usermanaging.dto.UserDTO;
import com.users.usermanaging.dto.UsersDTO;

public interface UserProviderService {
    UserDTO getUserById(String id);

    UsersDTO getUsers();
}
