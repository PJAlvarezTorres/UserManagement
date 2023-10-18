package com.users.usermanaging.converter;

import com.users.usermanaging.api.dto.UsersResponse;
import com.users.usermanaging.dto.UserDTO;
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
public interface UserToUserResponseConverter {

    @Mapping(target = "name", source = "userDTO.user.first_name", qualifiedByName = "setToUpperCase")
    UsersResponse userToUserResponse(UserDTO userDTO);

    @Named("setToUpperCase")
    default String setToUpperCase(String name) {
        return name.toUpperCase();
    }
}
