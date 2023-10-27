package com.banu.MonolitSpotify.repository.entity;

import com.banu.MonolitSpotify.utility.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_calmaListesi")
public class CalmaListesi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userProfileId;

    private String baslik;
    private int sarkiSayisi;

    @Enumerated(EnumType.STRING)
    private State state;
}
