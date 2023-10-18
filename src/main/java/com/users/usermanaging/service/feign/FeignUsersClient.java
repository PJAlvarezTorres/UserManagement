package com.users.usermanaging.service.feign;


import com.users.usermanaging.configuration.FeignConfig;
import com.users.usermanaging.dto.UserDTO;
import com.users.usermanaging.dto.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
             name = "users-service",
             url = "https://myfakeapi.com/api",
             configuration = FeignConfig.class)
public interface FeignUsersClient {


    @GetMapping("users/{id}")
    ResponseEntity<UserDTO> getUsers(@PathVariable("id") String id);

}
