package com.miu.userservice.controller;

import com.miu.userservice.entity.Login;
import com.miu.userservice.entity.Users;
import com.miu.userservice.service.KeyCloakService;
import com.miu.userservice.service.UserService;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Users, UserService> {

    private KeyCloakService keyCloakService;

    public UserController(UserService service,KeyCloakService keyCloakService) {
        super(service);
        this.keyCloakService = keyCloakService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login data) {

        var user = service.getAll().stream().filter(value -> value.getUserName().equals(data.getUserName()) && value.getPassword().equals(data.getPassword())).findFirst();

        if (user.isPresent()){
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("Content-Type",MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("client_id","authentication");
            map.add("client_secret","abcdefghijkl");
            map.add("username","john@test.com");
            map.add("password","123");
            map.add("grant_type","password");

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

            ResponseEntity<String> response =
                    restTemplate.exchange("http://localhost:8099/auth/realms/miu/protocol/openid-connect/token",
                            HttpMethod.POST,
                            entity,
                            String.class);

            return response;
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid");
        }
    }


    @Override
    @PostMapping("/register")
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
