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
@Table(name = "tbl_calmaListesiMuzik")
public class CalmaListesiMuzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long muzikId;

    private Long calmaListesiId;

    @Enumerated(EnumType.STRING)
    private State state;
}
