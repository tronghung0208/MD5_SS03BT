package com.ra.service;

import com.ra.entity.Category;

import java.util.List;

public interface IGennericService <T,ID>{
    List<T> findAll();

    T saveOrUpdate(T t);
    T findById(ID id);

    void delete(ID id);
}
