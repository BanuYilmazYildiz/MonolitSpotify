package com.banu.MonolitSpotify.repository.entity;

import com.banu.MonolitSpotify.utility.enums.State;
import com.banu.MonolitSpotify.utility.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;
    String password;
    String email;

    private String resimUrl;
    private int followerCount;
    private int followingCount;
    private Long createAt;
    private Long updateAt;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private State state;
}
