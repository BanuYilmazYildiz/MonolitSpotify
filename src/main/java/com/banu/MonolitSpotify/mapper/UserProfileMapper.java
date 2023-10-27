package com.banu.MonolitSpotify.mapper;


import com.banu.MonolitSpotify.dto.request.SaveUserProfileRuquestDto;
import com.banu.MonolitSpotify.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {

    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfile userProfileFromDto(SaveUserProfileRuquestDto dto);

    SaveUserProfileRuquestDto toDto(UserProfile userProfile);
}
