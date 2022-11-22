package com.comments.service;

import com.comments.entity.Identifiable;
import com.comments.repository.CrudRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class CrudService<T extends Identifiable, R extends CrudRepositoryInterface<T>> implements CrudServiceInterface<T> {

    final R repository;

    public ArrayList<T> getAll(){
        return repository.getAll();
    }

    public Optional<T> get(Long id){
        return repository.get(id);
    }

    public Boolean delete(Long id){
        return repository.delete(id);
    }

    public Boolean update(T data){
        return repository.update(data);
    }

    public Boolean create(T data){
        return repository.create(data);
    }




}
