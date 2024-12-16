package com.ssaxel03.simplequote.daos;

import com.ssaxel03.simplequote.model.Model;

import java.util.List;

/**
 * Base interface for data access objects, provides methods to manage models
 * @param <T> the model type
 */
public interface Dao<T extends Model> {
    List<T> findAll();
    T findById(Integer id);
    T saveOrUpdate(T modelObject);
    void delete(T modelObject);
}
