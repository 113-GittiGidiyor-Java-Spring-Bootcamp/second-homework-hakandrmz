package dev.patika.dao;

import java.util.List;

public interface BaseDAO<T>{

    List<T> findAll();

    T findById(int id);

    T save(T t);

    void delete(int id);

    void update(T t);

}
