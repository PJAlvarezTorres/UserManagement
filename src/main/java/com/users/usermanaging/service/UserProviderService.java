package com.users.usermanaging.service;

import com.users.usermanaging.dto.UserDTO;

public interface UserProviderService {
    UserDTO getUser(String id);
}
