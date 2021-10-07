package ch.sowatec.service;

import net.internalerror.MyLogger;

import java.util.List;

public interface IService<T> {

    MyLogger LOGGER = MyLogger.getLogger(IService.class.getName());

    T create(T entity);

    List<T> findAll();

    T find(Long id);

    T update(T entity);

    void delete(Long id);

}
