package com.users.usermanaging.service.implementation;

import com.users.usermanaging.dto.UserDTO;
import com.users.usermanaging.dto.UserSystemDTO;
import com.users.usermanaging.dto.UsersDTO;
import com.users.usermanaging.service.UserProviderService;
import com.users.usermanaging.service.feign.FeignUsersClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProviderServiceImpl implements UserProviderService {

    Logger logger = LoggerFactory.getLogger(UserProviderServiceImpl.class);

    FeignUsersClient feignUsersClient;
    @Override
    public UserDTO getUserById(String id) {
        logger.info("Getting info for id User {}", id);
        return feignUsersClient.getUserById(id).getBody();
    }

    @Override
    public UsersDTO getUsers() {
        logger.info("Getting info for users");
        return feignUsersClient.getUsers().getBody();
    }

    public UserSystemDTO addUserToSystem() {
        logger.info("Add user to system");
        return feignUsersClient.addUser().getBody();
    }
}
