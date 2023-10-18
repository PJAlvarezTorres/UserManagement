package com.users.usermanaging.service.implementation;

import com.users.usermanaging.dto.UserDTO;
import com.users.usermanaging.service.feign.FeignUsersClient;
import com.users.usermanaging.service.UserProviderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProviderServiceImpl implements UserProviderService {

    FeignUsersClient feignUsersClient;
    @Override
    public UserDTO getUser(String id) {
        return feignUsersClient.getUsers(id).getBody();
    }
}