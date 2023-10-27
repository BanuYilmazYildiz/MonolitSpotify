package com.banu.MonolitSpotify.service;

import com.banu.MonolitSpotify.repository.MuzikRepository;
import com.banu.MonolitSpotify.repository.MuzikSanatciRepository;
import com.banu.MonolitSpotify.repository.entity.MuzikSanatci;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikSanatciSevice {

    private final MuzikSanatciRepository repository;

    public void save(MuzikSanatci entity){
        repository.save(entity);
    }
}
