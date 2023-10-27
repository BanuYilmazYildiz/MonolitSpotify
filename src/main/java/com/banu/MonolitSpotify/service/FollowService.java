package com.banu.MonolitSpotify.service;

import com.banu.MonolitSpotify.repository.FollowRepository;
import com.banu.MonolitSpotify.repository.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository repository;

    public void sace(Follow entity){
        repository.save(entity);
    }
}
