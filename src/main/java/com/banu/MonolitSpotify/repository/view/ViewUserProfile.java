package com.banu.MonolitSpotify.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViewUserProfile {
    Long id;
    String userName;
    String resimUrl;
}
