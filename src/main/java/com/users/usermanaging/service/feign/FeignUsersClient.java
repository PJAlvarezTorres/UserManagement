package com.users.usermanaging.service.feign;


import com.users.usermanaging.configuration.FeignConfig;
import com.users.usermanaging.dto.UserDTO;
import com.users.usermanaging.dto.UserSystemDTO;
import com.users.usermanaging.dto.UserSystemDataDto;
import com.users.usermanaging.dto.UsersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
             name = "users-service",
             url = "${endpoing.url.feign}",
             configuration = FeignConfig.class)
public interface FeignUsersClient {

    @GetMapping(value = "${endpoing.url.feign.user}")
    ResponseEntity<UserDTO> getUserById(
            @PathVariable("id") String id);

    @GetMapping(value = "${endpoing.url.feign.users}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UsersDTO> getUsers();

    @PostMapping(value = "${endpoing.url.feign.users}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserSystemDataDto> addUser(
            @RequestBody UserSystemDTO userSystemDTO);
}
