package com.example.crud2tablespringboot.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void remove(Long id);
    void save (T t);
}
