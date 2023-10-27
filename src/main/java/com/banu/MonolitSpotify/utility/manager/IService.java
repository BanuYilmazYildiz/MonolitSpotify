package com.banu.MonolitSpotify.utility.manager;

import java.util.List;

public interface IService <T,ID>{

    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entites);

    // update kullanacağız servis katmanında güncelleme yaparız

    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    List<T> findAll();
}
