package com.users.usermanaging.controller;

import com.users.usermanaging.api.UsersApi;
import com.users.usermanaging.api.dto.UsersRequest;
import com.users.usermanaging.api.dto.UsersResponse;
import com.users.usermanaging.converter.UserDtoToUserConverter;
import com.users.usermanaging.converter.UserToUserResponseConverter;
import com.users.usermanaging.service.UserProviderService;
import com.users.usermanaging.service.UserRepositoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
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

    UserDtoToUserConverter userDtoToUserConverter;

    UserToUserResponseConverter userToUserResponseConverter;

    UserRepositoryService userRepositoryService;
    Logger logger = LoggerFactory.getLogger(UserManagingController.class);

    @Override
    public ResponseEntity<UsersResponse> getUser(UsersRequest usersRequest) {
        logger.info("Processing user with id {}", usersRequest.getIdUser());
        var user = userProviderService.getUser(
                usersRequest.getIdUser());
        userRepositoryService.addUser(
                userDtoToUserConverter.convertToUserDto(user));
        var userResponse = userToUserResponseConverter.userToUserResponse(user);
        return ResponseEntity.ok(userResponse);
    }
}



