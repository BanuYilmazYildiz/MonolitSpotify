package com.banu.MonolitSpotify.service;

import com.banu.MonolitSpotify.dto.request.AddMusicForArtistsRequestDto;
import com.banu.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.banu.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.banu.MonolitSpotify.mapper.MuzikMapper;
import com.banu.MonolitSpotify.repository.MuzikRepository;
import com.banu.MonolitSpotify.repository.entity.Muzik;
import com.banu.MonolitSpotify.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikSevice {
    private final MuzikRepository repository;

    public void save(SaveMuzikRequestDto dto){
//        Muzik muzik = Muzik.builder()
//                .muzikUrl(dto.getMuzikUrl())
//                .aciklama(dto.getMuzikUrl())
//                .tur(dto.getTur())
//                .name(dto.getName())
//                .sure(dto.getSure())
//                .kapakResmi(dto.getKapakResmi()).build();

        Muzik muzik = MuzikMapper.INSTANCE.muzikFromDto(dto);
        muzik.setState(State.PENDING);
        repository.save(muzik);
//        repository.save(MuzikMapper.INSTANCE.muzikFromDto(dto));
    }

    public FindAllMuzikResponseDto findAll() {
        return FindAllMuzikResponseDto.builder()
                .statusCode(100)
                .message("Muzik listesi getirildi")
                .data(repository.findAll()).build();
    }

    /**
     * TODO: 1- Kullanıcı id mevcut mu bakılmalı
     * TODO: 2- Müzik id var mı kontrol edilmeli
     * TODO: 3- Kullanıcı id si verilen kişi sanatcı mı? kontrol edilecek
     * TODO: 4- Eğer aynı kullanıcı id ve müzik id daha önce kayıt edilmiş ise tekrar kayıt edilememelidir.
     * @param dto
     */
    public void addMusicForArtist(AddMusicForArtistsRequestDto dto) {

    }
}
