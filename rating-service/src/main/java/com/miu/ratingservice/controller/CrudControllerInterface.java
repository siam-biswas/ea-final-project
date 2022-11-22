package com.miu.ratingservice.controller;


import com.miu.ratingservice.entity.Identifiable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CrudControllerInterface<T extends Identifiable> {


    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> get(@PathVariable Long id);
    public ResponseEntity<Boolean> create(@RequestBody T data);
    public ResponseEntity<Boolean> delete(@PathVariable Long id);
    public ResponseEntity<Boolean> update(@RequestBody T data);
}
