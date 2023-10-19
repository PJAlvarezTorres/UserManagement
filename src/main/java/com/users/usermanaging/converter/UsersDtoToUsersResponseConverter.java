package com.users.usermanaging.converter;

import com.users.usermanaging.api.dto.UserResponse;
import com.users.usermanaging.dto.UserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unexpectedValueMappingException = Exception.class,
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface UsersDtoToUsersResponseConverter {

    @Mapping(target = "firstName", source = "first_name")
    UserResponse convertToUserInfo(UserInfoDTO userInfoDTO);

    List<UserResponse> mapSourceListToTargetList(List<UserInfoDTO> sourceItemList);

}
