package com.miu.userservice.repository;

import com.miu.userservice.entity.Identifiable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Optional;

@NoRepositoryBean
public interface CrudRepositoryInterface<T extends Identifiable> extends Repository<T, Long> {

    public ArrayList<T> getAll();
    public Optional<T> get(Long id);
    public Boolean create(T course);
    public Boolean delete(Long id);
    public Boolean update(T course);
}