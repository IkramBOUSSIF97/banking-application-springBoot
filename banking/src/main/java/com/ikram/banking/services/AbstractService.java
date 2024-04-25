package com.ikram.banking.services;

import java.util.List;

public interface AbstractService<T> {
    Integer save(T dto);  // used for save and edit
    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);
}
