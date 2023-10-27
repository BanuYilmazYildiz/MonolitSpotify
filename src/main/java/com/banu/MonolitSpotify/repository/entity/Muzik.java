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
@Table(name = "tbl_muzik")
public class Muzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String muzikUrl;

    private String name;

    private String kapakResmi;

    /**
     * TODO :Müzik Türü tablosundan doğrulantıktan sonra girişine onay var
     */
    private String tur;

    private int sure;

    private String aciklama;

    @Enumerated(EnumType.STRING)
    private State state;



}
