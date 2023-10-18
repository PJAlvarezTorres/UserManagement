package com.users.usermanaging.service.feign;


import com.users.usermanaging.configuration.FeignConfig;
import com.users.usermanaging.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
             name = "users-service",
             url = "${endpoing.url.feign}",
             configuration = FeignConfig.class)
public interface FeignUsersClient {

    @GetMapping("${endpoing.url.feign.users}")
    ResponseEntity<UserDTO> getUsers(@PathVariable("id") String id);

}
