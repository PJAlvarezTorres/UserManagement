package com.users.usermanaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.users.usermanaging.service"})
@EnableJpaRepositories("com.users.usermanaging.repository")
public class UserManagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagingApplication.class, args);
    }

}
