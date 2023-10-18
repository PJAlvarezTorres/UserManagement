package com.users.usermanaging.controller;

import com.users.usermanaging.api.UsersApi;
import com.users.usermanaging.api.dto.UsersResponse;
import com.users.usermanaging.model.UserEntity;
import com.users.usermanaging.repository.UserRepository;
import com.users.usermanaging.service.UserProviderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/getUsersInfo")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserManagingController implements UsersApi {

    UserProviderService userProviderService;

    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserManagingController.class);

    @Override
    public ResponseEntity<UsersResponse> getUser(com.users.usermanaging.api.dto.UsersRequest usersRequest) {
        logger.info("Processing user with id {}", usersRequest.getIdUser());
        var user = userProviderService.getUser(String.valueOf(usersRequest.getIdUser()));
        UserEntity userEntity = UserEntity.builder()
                .name(usersRequest.getIdUser())
                .build();
        userRepository.save(userEntity);
        UsersResponse usersResponse = new UsersResponse();
        return ResponseEntity.ok(usersResponse);
    }
}



