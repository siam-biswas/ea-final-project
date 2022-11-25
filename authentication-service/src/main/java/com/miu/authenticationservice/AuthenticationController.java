package com.miu.authenticationservice;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private RestTemplate restTemplate;

    public AuthenticationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostMapping("/accesstoken")
    public ResponseEntity<String> accessToken() {

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
    }
}
