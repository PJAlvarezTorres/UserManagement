package com.users.usermanaging.converter;

import com.users.usermanaging.dto.User;
import com.users.usermanaging.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unexpectedValueMappingException = Exception.class,
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE
)
public interface UserToUserEntityConverter {

    @Mapping(target = "name", source = "name")
    UserEntity userToUserEntity(User user);

    @Named("setToUpperCase")
    default String setToUpperCase(String name) {
        return name.toUpperCase();
    }
}
