package com.banu.MonolitSpotify.service;

import com.banu.MonolitSpotify.dto.request.AddMusicForArtistsRequestDto;
import com.banu.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.banu.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.banu.MonolitSpotify.exception.ErrorType;
import com.banu.MonolitSpotify.exception.MonolitSpotifyException;
import com.banu.MonolitSpotify.mapper.MuzikMapper;
import com.banu.MonolitSpotify.repository.MuzikRepository;
import com.banu.MonolitSpotify.repository.MuzikSanatciRepository;
import com.banu.MonolitSpotify.repository.entity.Muzik;
import com.banu.MonolitSpotify.repository.entity.MuzikSanatci;
import com.banu.MonolitSpotify.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuzikSevice {
    private final MuzikRepository repository;
    private final UserProfileService userProfileService;
    private final MuzikSanatciRepository muzikSanatciRepository;

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
     * 1- Kullanıcı id mevcut mu bakılmalı
     * 2- Müzik id var mı kontrol edilmeli
     * 3- Kullanıcı id si verilen kişi sanatcı mı? kontrol edilecek
     * TODO: 4- Eğer aynı kullanıcı id ve müzik id daha önce kayıt edilmiş ise tekrar kayıt edilememelidir.
     */
    public void addMusicForArtist(AddMusicForArtistsRequestDto dto) {
        // iki hatayı genel yazıp error codes.md de bu hatayı aldıysan bu sebeplerden olabilir diye açıklayabiliriz
        if (!userProfileService.existById(dto.getArtistsId()) || !userProfileService.isArtist(dto.getArtistsId())){
            throw new MonolitSpotifyException(ErrorType.ARTIST_ERROR);
        }
       else if (!repository.existsById(dto.getMuzikId())){
           throw new MonolitSpotifyException(ErrorType.MUSIC_NOT_FOUND);
       }
       muzikSanatciRepository.save(MuzikSanatci.builder()
               .muzikId(dto.getMuzikId())
               .sanatciId(dto.getArtistsId())
               .build());
    }

    /**
     *-- TODO: 1- Artist id sini (UserProfileId si) kullanarak tbl_muziksanatci taplosundan ilgili id ye ait tüm kayıtlar çekilir
     *-- TODO: 2- tbl_muziksanatci tablosundan gelen tüm kayıtların içinden müzik id leri bir liste içine alınır
     *-- TODO: 3-muzik idleri bilinen liste muzikTepository e verilerek tüm müzik listesi çekilir
     * TODO: YADA - bir @Query yazılarak aynı işlem tanımlanabilir
     * @param id
     * @return
     */
    public List<Muzik> findAllMuzikFromArtistId(Long id) {
        List<MuzikSanatci> muzikSanatciList = muzikSanatciRepository.findAllBySanatciId(id);
        List<Long> muzikIdList = muzikSanatciList.stream().map(MuzikSanatci::getMuzikId).toList();
        return repository.findAllById(muzikIdList);
    }
}
