package com.comments.service;

import com.comments.entity.Identifiable;

import java.util.ArrayList;
import java.util.Optional;

public interface CrudServiceInterface<T extends Identifiable> {

    public ArrayList<T> getAll();
    public Optional<T> get(Long id);
    public Boolean delete(Long id);
    public Boolean update(T data);
    public Boolean create(T data);
}
