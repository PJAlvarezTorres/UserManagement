package com.users.usermanaging.repository;

import com.users.usermanaging.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
