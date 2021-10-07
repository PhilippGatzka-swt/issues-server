package ch.sowatec.controller;

import java.util.List;

public interface IController<T> {

    T create(T entity);

    List<T> findAll();

    T find(Long id);

    T update(T entity);

    void delete(Long id);


}
