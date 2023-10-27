package com.banu.MonolitSpotify.repository;

import com.banu.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.banu.MonolitSpotify.repository.entity.UserProfile;
import com.banu.MonolitSpotify.repository.view.ViewUserProfile;
import com.banu.MonolitSpotify.utility.enums.State;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * DİKKAT!!!
 * Spring 3.X ile birlikte Repository sınıfların üzerinde ekleme @Repository antosayonu kaldırışmıitır
 */
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

    /**
     * useeName -> UserName -> kullaniciAdi-> Kullanıcı
     * DİKKAT!!!
     * Spring Data Jpa içinde belli kelimeleri analiz ederek doğru sıralamada kullandığında
     * sorgulayı kelimeler yapabliriz.
     *
     * Kelimeleri kullanarak Sorgu Yazma Syntax;
     * 1- [find] yazılır
     * 2- [By] yazılır- "belli" koşullarda araya başka kelimeler gelebilir
     * 3-> [Entity - DeğişkenAdı] !!! Değişken adları büyük harf ile başlamalı
     * 4- () parantez içine istediğiniz türdeki değişken ya da değişkenlkeri yanımlıyosunuz
     *
     */

    Optional<UserProfile> findByResimUrl(String resimurlsi_girilecek);
   // Optional<UserProfile> findOptionalByUserName(String userName);
    // select*from tbl_userprofile where stat=?;
    List<UserProfile> findAllByState(State state);

    /**
     * select*from tvl_userprofile where cerateAt > now()-1000*60*40*24*30
     *
     * son [x] günde kayıt olanların listesi
     *
     * GreaterThan -> bundan büyük -> creatAt > xxx
     * LessThan -> bundan küçük -> creatAt < xxx
     * GreaterThanEquals -> creatAt >= xxx
     * LessThanEquals -> createAt <= xxx
     */
    List<UserProfile> findAllByCreateAtGreaterThan(Long kayitZamani);

    /**
     * Select*FROM tbl_userprofile WHERE username LIKE '%muh%'
     * !!!!!!
     * burada username ile parametre gödnerirken gelen değere spring %% ya da _ gibi
     * önerileri eklemez. bu nedenle sorhu yaparken şu sekilde kullanın;
     * findAllByUserNameLike(%muh%)
     */
    List<UserProfile> findAllByUserNameLike(String userName);

    /**
     * SELECT * FROM tbl_userprofile WHERE username = muh%
     */
    List<UserProfile> findAllByUserNameStartingWith(String userName);

    /**
     * SELECT * FROM tbl_userprofile WHERE creatAT >XXX and username LIKE 'muh%'
     */

    List<UserProfile> findAllByCreateAtGreaterThanAndUserNameLike(Long lastDate, String userName);

    /**
     * Optional
     */

    Optional<UserProfile> findOptionalByUserName(String userName);

    /**
     * Srıalama çok önemli olabiliyor
     * SELECT*FROM tvl_userprofile ORDER BY creatAt [ASCiDESC]
     * ASC -> A----Z
     * DESC -> Z---A
     */
    List<UserProfile> findAllByOrderByCreateAt();
    List<UserProfile> findAllByOrderByCreateAtDesc();

 /**
  * Belli kayıtların öncelenerek çekilmesi ya da kaytlarda kısıtlamaya gidilmesi
  * listelenirken performans sağlar ve çok daha anlamlıdır
  */
 List<UserProfile> findTop3By();
 List<UserProfile> findTop10ByOrderByCreateAt();

 UserProfile findTopByOrderByCreateAtDesc();

 Optional<UserProfile> findTopOptionalByOrderByCreateAtDesc();

 /**
  * Belli aralıklarda kısıtlamaya gidebilirz. bunun için and ile birleştirme yapabiliriz
  * ancak Spring data bunun için bize bir kolaylık sağlıyor
  * Üyelik tarihi 1 ile 2 yıl arasında olanları getir.
  *
  */
 List<UserProfile> findAllByCreateAtBetween(Long start, Long end);
 List<UserProfile> findAllByUserNameLikeAndCreateAtBetween(String userName, Long start, Long end);

 /**
  * isActive = true/false
  *  List<UerProfile> findAllByIsActive(boolean isActive);
  * List<UerProfile> findAllByIsActiveTrue();
  *  List<UerProfile> findAllByIsActiveFalse();
  */

 /**
  * Bir alanı sorgularken eşitlik için ek bir kodlama yapmaya gerek yoktur. Ancak bazen girilen
  * değer ile tutulmuş olan değer büyük küçük harf sorununa takılabilir. Bunun iin bu işlemi ignore etmke
  * gerekebilir
  */

 Optional<UserProfile> findOptionalByUserNameIgnoreCase(String userName);

 /**
  * Bazı kolonlar belki sonra doldurulmak üzere boş bırakılabilir bu nedenle
  * kontrol etmek ve kullanıcıya bunları doldurması yönünde telkinde bulunabiliriz
  * Null, IsNull, NotNull
  */
 List<UserProfile> findAllByResimUrlIsNull();

 /**
  * Spring Data Jpa kolaylık açısından kendi kelimelerini desteklede daha karmaşıık sorgular ve yapılar
  * için özel sorgu yazabilmenize de olanak tanımaktadır;
  * Bu işlemler için 3 farklı yöntem vardır:
  * 1- JPQL
  * 2- HQL
  * 3-NativeSQL
  */

 @Query("select u from UserProfile u where u.resimUrl IS NULL and u.userName=?1 and u.createAt>?2")
 UserProfile egerKullanicininResmiYokIseVeAdiMuhammetIseBul(String userName, Long createAt);


 @Query("SELECT new com.banu.MonolitSpotify.repository.view.ViewUserProfile(u.id,u.userName,u.resimUrl) FROM UserProfile u ")
 List<ViewUserProfile> findAllFromUserProfileView();

// @Query("SELECT new com.banu.MonolitSpotify.dto.response.FindAllUserProfileResponseDto(u.id,u.userName,u.resimUrl) FROM UserProfile u ")
// List<FindAllUserProfileResponseDto> findAllFromUserProfile();
 @Query("SELECT COUNT(u)>0 FROM  UserProfile u WHERE u.userName= ?1")
 boolean buKullaniciAdiVarMi(String userName);

boolean existsByUserName(String username);


}
