package com.picolite.services;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CRUDService<T, ID> {

    public T create(T object);
    public void update(T object);
    public List<T> findAll();
    public T findById(ID id);
    public void delete(ID id) throws Exception;
}
