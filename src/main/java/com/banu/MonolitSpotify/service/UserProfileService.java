package com.banu.MonolitSpotify.service;

import com.banu.MonolitSpotify.dto.request.SaveUserProfileRuquestDto;
import com.banu.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.banu.MonolitSpotify.exception.ErrorType;
import com.banu.MonolitSpotify.exception.MonolitSpotifyException;
import com.banu.MonolitSpotify.repository.UserProfileRepository;
import com.banu.MonolitSpotify.repository.entity.UserProfile;
import com.banu.MonolitSpotify.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DİKKATTT!!!!
 *
 * servis sınıflarının belirtilmesi ve bunlardan birerre Bean oluşturulması için spring bu sınıfların üzerinde @ Service
 * anotasyonu olup olmadığına bakar. eğer boş geçilirse hata fırlatır ve uygulamanız ayaüa kalkmaz
 */

@Service
@RequiredArgsConstructor
public class UserProfileService {

    /*
       DİKKATTTT
        Spring Bean olarak işaretlediği ( qRepository, @Service, @Configuration, @Component vs)
         tüm sınıflardan nese yaratabilmek için 3 farklı yönteö izler
         1- Değişken üzerinde @Autowired ekleyerek
         2- Değişkenin constructor a parametre olarak geçilmesi ile yapılır. (constructar injection)
         3- 2. yöntem in 3. taraf uygulamlar ile sağlanması. yazımı daha koladır. kod sayfasının daha temiz
         görünmesini sağlar
     */

//    @Autowired
//    private UserProfileRepository userProfileRepositoryYontem_1;
//    private UserProfileRepository repositoryYontem_2;
//
//    private UserProfileService(UserProfileRepository userProfileRepositoryYontem_2){
//        this.repositoryYontem_2=userProfileRepositoryYontem_2;
//    }

    // anotasyın ile initialize etmeden yapılabiliyor. o kısmı anotasyon yapıyor
    private final UserProfileRepository repository;


    /**
     * Save işlemi iki şekilde çalışır
     * 1- Eğer kendisine verilen nesne id bilgisini içermiyor ise yani null ise kaydetme işlemi yapar
     * 2- Eğer nesne içindeki id bir değer içeriyor ise bu seferde güncelleme işlemi yapar
     * @param userProfile
     */
    public void save(UserProfile userProfile){
        repository.save(userProfile);
    }


    public void save(SaveUserProfileRuquestDto dto){
        if (!dto.getPassword().equals(dto.getRePassword())){
            throw new MonolitSpotifyException(ErrorType.SIFRE_UYUSMUYOR);
        }
        if (repository.existsByUserName(dto.getUserName())){
            throw new MonolitSpotifyException(ErrorType.KAYITLI_KULLANICI_ADI);
        }

        UserProfile userProfile = UserProfile.builder()
                .userName(dto.getUserName())
                .userType(dto.getUserType())
                .createAt(System.currentTimeMillis())
                .updateAt(System.currentTimeMillis())
                .resimUrl(dto.getResimUrl())
                .state(State.ACTIVE)
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();

        repository.save(userProfile);
    }
    public List<UserProfile> findAll(){
        return repository.findAll();
    }

    public List<UserProfile> findAllByCreateAtGreaterThan(Long kayitZamani){
        return repository.findAllByCreateAtGreaterThan(kayitZamani);
    }

    public FindAllUserProfileResponseDto findAllUserProfile() {
        return FindAllUserProfileResponseDto.builder()
                .statusCode(100)
                .message("Listeler başarılı şekilde çekildi")
                .data(repository.findAllFromUserProfileView())
                .build();

//        List<FindAllUserProfileResponseDto> result = new ArrayList<>();
//        repository.findAll().forEach(u->{

//        repository.findAllFromUserProfile().forEach(u->{
//            result.add(
//                    FindAllUserProfileResponseDto.builder()
//                            .id(u.getId())
//                            .userName(u.getUserName())
//                            .resimUrl(u.getResimUrl()).build()
//            );
//        });
//         return result;
//        return repository.findAllFromUserProfile();
    }
}
