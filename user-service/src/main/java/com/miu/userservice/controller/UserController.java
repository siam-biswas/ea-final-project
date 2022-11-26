package com.miu.userservice.controller;

import com.miu.userservice.entity.Users;
import com.miu.userservice.service.KeyCloakService;
import com.miu.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Users, UserService> {

    private KeyCloakService keyCloakService;

    public UserController(UserService service,KeyCloakService keyCloakService) {
        super(service);
        this.keyCloakService = keyCloakService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody Users data) {
        if (service.create(data)){
            //keyCloakService.addUser(data);
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        if (service.delete(id)){
            var userName = service.get(id).get().getUserName();
            var userId = keyCloakService.getUser(userName).get(0).getId();
            //keyCloakService.deleteUser(userId);
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody Users data) {
        if (service.update(data)) {
            var userName = service.get(data.getId()).get().getUserName();
            var userId = keyCloakService.getUser(userName).get(0).getId();
            //keyCloakService.updateUser(userId,data);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
