package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Note;

import java.util.List;


public interface BaseDaoCrud<T, ID>{

    List<T> findAll();

    T findById(ID id);

    T save(T toAdd);

    void deleteById(ID id);

    T update(T toUpdate);
}
