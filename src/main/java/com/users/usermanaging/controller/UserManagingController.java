package com.users.usermanaging.controller;

import com.users.usermanaging.api.UserApi;
import com.users.usermanaging.api.UsersApi;
import com.users.usermanaging.api.AddUserApi;

import com.users.usermanaging.api.dto.UserRequest;
import com.users.usermanaging.api.dto.UserResponse;
import com.users.usermanaging.api.dto.UsersResponse;
import com.users.usermanaging.converter.UserDtoToUserConverter;
import com.users.usermanaging.converter.UserToUserResponseConverter;
import com.users.usermanaging.converter.UsersDtoToUsersResponseConverter;
import com.users.usermanaging.dto.UsersDTO;
import com.users.usermanaging.service.UserProviderService;
import com.users.usermanaging.service.UserRepositoryService;
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
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/getUsersInfo")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserManagingController implements UsersApi, UserApi, AddUserApi {

    UserProviderService userProviderService;

    UserDtoToUserConverter userDtoToUserConverter;

    UserToUserResponseConverter userToUserResponseConverter;

    UsersDtoToUsersResponseConverter usersDtoToUsersResponseConverter;

    UserRepositoryService userRepositoryService;
    Logger logger = LoggerFactory.getLogger(UserManagingController.class);
    
    @Override
    public ResponseEntity<UserResponse> getUser(UserRequest userRequest) {
        logger.info("Processing user with id {}", userRequest.getIdUser());
        userRepositoryService.addUser(
                userDtoToUserConverter.convertToUserDto(
                        userProviderService.getUserById(
                                userRequest.getIdUser())));
        return ResponseEntity.ok(
                userToUserResponseConverter.userToUserResponse(
                    userProviderService.getUserById(
                            userRequest.getIdUser())));
    }

    @Override
    public ResponseEntity<com.users.usermanaging.api.dto.UserSystemResponse> addUser() {
        logger.info("Processing uses");
        return null;
    }

    @Override
    public ResponseEntity<UsersResponse> getUsers() {
        logger.info("Processing uses");
        UsersDTO usersDTO = userProviderService.getUsers();
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setUsers(usersDtoToUsersResponseConverter.mapSourceListToTargetList(usersDTO.getUsers()));
        return ResponseEntity.ok(usersResponse);
    }


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UsersApi.super.getRequest();
    }
}



