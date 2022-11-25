package com.miu.authenticationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class AuthenticationCredentials {
    String client_id;
    String client_secret;
    String username;
    String password;
    String grant_type;
}
