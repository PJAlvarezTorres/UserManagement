package com.users.usermanaging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
//https://apimocha.com/
@FeignClient(name = "users-service",
             url = "https://apimocha.com/businessusers")
public interface FeignUsersClient {

    @GetMapping(path = "/requestuser")
    ResponseEntity<String> getUsers(
            @RequestBody String id);
}
