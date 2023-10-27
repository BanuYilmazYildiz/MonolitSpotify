package com.banu.MonolitSpotify.dto.response;

import com.banu.MonolitSpotify.repository.view.ViewUserProfile;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class FindAllUserProfileResponseDto {
//    Long id;
//    String userName;
//    String resimUrl;

    int statusCode;
    String message;
    List<ViewUserProfile> data;



}
