package com.miu.authenticationservice;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthenticationController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/auth")
    public String getTokenDetails(@RequestHeader HttpHeaders headers) {
        return headers.toString();
    }

}