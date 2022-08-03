package com.picolite.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Repository
public interface CRUDDao<T, ID> {

    public T create(T object);
    public void update(T object);
    public List<T> findAll();
    public T getById(ID id);
    public void delete(ID id) throws Exception;

}
