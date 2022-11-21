package com.miu.userservice.repository;

import com.miu.userservice.entity.Identifiable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Optional;


public class CrudRepository<T extends Identifiable> extends SimpleJpaRepository<T, Long> implements CrudRepositoryInterface<T>  {


    public CrudRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public ArrayList<T> getAll(){
        var result = new ArrayList<T>();
        findAll().forEach(result::add);
        return result;

    }

    public Optional<T> get(Long id){
        return findById(id);
    }

    public Boolean delete(Long id){
        if (get(id).isPresent()){
            deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Boolean update(T data){
        if (get(data.getId()).isPresent()){
            save(data);
            return true;
        }else{
            return false;
        }
    }

    public Boolean create(T data) {
        if (!get(data.getId()).isPresent()){
            save(data);
            return true;
        }else{
            return false;
        }

    }
}