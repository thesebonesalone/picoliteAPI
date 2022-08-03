package com.picolite.services;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CRUDService<T, ID> {

    T create(T object);
    void update(T object);
    List<T> findAll();
    T findById(ID id);
    void delete(ID id) throws Exception;
}
