package com.picolite.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Repository
public interface CRUDDao<T, ID> {

    T create(T object);
    void update(T object);
    List<T> findAll();
    T getById(ID id);
    void delete(ID id) throws Exception;

}
