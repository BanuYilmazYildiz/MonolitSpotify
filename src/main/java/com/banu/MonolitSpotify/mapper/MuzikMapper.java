package com.banu.MonolitSpotify.mapper;

import com.banu.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.banu.MonolitSpotify.repository.entity.Muzik;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * componentModel -> Mapper in bu sınıftan bir nesne yaratmakla ilgili yapısının spring model şeklinde olduğunu belityiotuz.
 * unmappedTargetPolicy -> eğer atama yapılacak olan sınıfın içindeki alanlar kaynak nesne ile uyuşmuyor
 * ise hata vermemesi uyumsuz olanları ignore etmesi(nullgeçmesi) için kullanılır.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MuzikMapper {
    /**
     * İlgili sınıfın bir impl yaratacak nesnenin INSTANCE a atar. Yani size bir nesne döner
     */
    MuzikMapper INSTANCE = Mappers.getMapper(MuzikMapper.class);

//    @Mappings({
//            @Mapping(target = " ",source = " ")
//    })
    Muzik muzikFromDto(final SaveMuzikRequestDto dto);
}
