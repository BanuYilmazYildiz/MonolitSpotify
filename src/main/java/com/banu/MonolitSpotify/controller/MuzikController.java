package com.banu.MonolitSpotify.controller;

import com.banu.MonolitSpotify.dto.request.AddMusicForArtistsRequestDto;
import com.banu.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.banu.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.banu.MonolitSpotify.repository.entity.Muzik;
import com.banu.MonolitSpotify.service.MuzikSevice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.banu.MonolitSpotify.constants.RestApi.*;

@RestController
@RequestMapping(MUZIK)
@RequiredArgsConstructor
public class MuzikController {

    private final MuzikSevice muzikSevice;

    @PostMapping(SAVE)
    public ResponseEntity<Void> saveMuzik(@RequestBody @Valid SaveMuzikRequestDto dto){
        muzikSevice.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<FindAllMuzikResponseDto> findAll(){
        return ResponseEntity.ok(muzikSevice.findAll());
    }

    @PostMapping(ADDMUSICFORARTIST)
    public ResponseEntity<Void> addMusicForArtist(@RequestBody @Valid AddMusicForArtistsRequestDto dto){
        muzikSevice.addMusicForArtist(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllMusicFromArtistId/{id}")
    public ResponseEntity<List<Muzik>> getAllMusizFromArtistId(@PathVariable("id") Long id){
        List<Muzik> result = muzikSevice.findAllMuzikFromArtistId(id);
        return ResponseEntity.ok().build();
    }
}
