package com.users.usermanaging.converter;

import com.users.usermanaging.api.dto.UserSystemRequest;
import com.users.usermanaging.dto.UserSystemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unexpectedValueMappingException = Exception.class,
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface UserSystemRequestToUserSystemDataDto {
    UserSystemDTO convertToUserInfo(UserSystemRequest userSystemRequest);

}
