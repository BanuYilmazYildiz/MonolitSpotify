package com.banu.MonolitSpotify.service;

import com.banu.MonolitSpotify.repository.MuzikTuruRepository;
import com.banu.MonolitSpotify.repository.entity.MuzikTuru;
import com.banu.MonolitSpotify.utility.manager.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/**
 * kodlarımızı supei bu yazıyordu ama extends alınca repositoryyi belirtmemiz gerekli
 */
//public class MuzikTuruService  extends ServiceManager<MuzikTuru,Long> {
public class MuzikTuruService  {
    private final MuzikTuruRepository repository;

    //public MuzikTuruService(MuzikTuruRepository repository){
      //  super(repository);
        //this.repository=repository;
    //}

    public void save(MuzikTuru entity){
        repository.save(entity);
    }
}
