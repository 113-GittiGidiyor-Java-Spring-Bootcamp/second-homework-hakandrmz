package dev.patika.dao;

import java.util.List;

public interface BaseDAO<T>{

    List<T> findAll();

    T findById(long id);

    T save(T t);

    void delete(long id);

    void update(T t);

}
