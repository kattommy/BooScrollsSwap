package com.kttk.bookScrollsSwap.services;

import java.util.List;

/**
 * Created by Tom - 06.03.2021
 */
public interface BaseCrud<T,ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    T update(T object);

    void deleteById(ID id);
}
