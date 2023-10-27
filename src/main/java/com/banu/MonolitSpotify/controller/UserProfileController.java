package com.banu.MonolitSpotify.controller;

import com.banu.MonolitSpotify.constants.RestApi;
import com.banu.MonolitSpotify.dto.request.SaveUserProfileRuquestDto;
import com.banu.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.banu.MonolitSpotify.exception.ErrorMessage;
import com.banu.MonolitSpotify.repository.entity.UserProfile;
import com.banu.MonolitSpotify.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import  static  com.banu.MonolitSpotify.constants.RestApi.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserProfileController {

    private  final UserProfileService userProfileService;
  // kontol etmeden save işlemi yapamayız
  //  @PostMapping(USER)
    //public ResponseEntity<UserProfile> save(String userName){
      //  UserProfile userProfile = UserProfile.builder()
        //        .userName(userName)
          //      .build();
       // userProfileService.save(userProfile);
       // return ResponseEntity.ok(userProfile);
    //}

//Kullanıcıya ihtiyacı olacak kadar bilgi dönmemiz lazım=> kullacı resim, adı ve kullanıcı adını göndermemiz ytereli
   // @GetMapping(FINDALL)
    //public ResponseEntity<List<UserProfile>> findAll(){
    //    return ResponseEntity.ok(userProfileService.findAll());
    //}

    @PostMapping(SAVE)
    public ResponseEntity<Void> saveUserProfile(@RequestBody @Valid SaveUserProfileRuquestDto dto){

        userProfileService.save(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<FindAllUserProfileResponseDto> findAllUserProfile(){
        return ResponseEntity.ok(userProfileService.findAllUserProfile());

    }
@GetMapping("/testException")
    public ResponseEntity<String> testException (String ifade){
        if (ifade.length()<10){
            throw new RuntimeException("girdiginiz ifade 10 karakterden az olamaz");
        }
        return ResponseEntity.ok("Aferin başarılı");
    }






}
