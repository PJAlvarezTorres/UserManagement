package com.users.usermanaging.converter;

import com.users.usermanaging.api.dto.UserSystemResponse;
import com.users.usermanaging.dto.UserSystemDTO;
import com.users.usermanaging.dto.UserSystemDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unexpectedValueMappingException = Exception.class,
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface UserDtoToUserSystemResponse {

    UserSystemResponse convertToUserSystemResponse(UserSystemDataDto userSystemDataDto);

}
