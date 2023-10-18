package com.users.usermanaging.service.implementation;

import com.users.usermanaging.converter.UserToUserEntityConverter;
import com.users.usermanaging.dto.User;
import com.users.usermanaging.repository.UserRepository;
import com.users.usermanaging.service.UserRepositoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserRepositoryServiceImpl implements UserRepositoryService {

    UserRepository userRepository;

    UserToUserEntityConverter userToUserEntityConverter;
    @Override
    public void addUser(User user) {
        userRepository.save(userToUserEntityConverter.userToUserEntity(user));
    }
}
