package ch.sowatec.controller;

import java.util.List;

/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
public interface IController<T> {

    T create(T entity);

    List<T> findAll();

    T find(Long id);

    T update(T entity);

    void delete(Long id);


}
