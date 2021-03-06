package com.kttk.bookScrollsSwap.services;

import java.util.Set;

/**
 * Created by Tom - 06.03.2021
 */
public interface BaseCrud<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T author);

    T deleteById(ID id);
}
