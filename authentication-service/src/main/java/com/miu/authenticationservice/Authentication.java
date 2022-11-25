package com.miu.authenticationservice;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Authentication {
    String access_token;
    String refresh_token;
    String token_type;
    String expires_in;
    String refresh_expires_in;
    String session_state;
    String scope;

    @JsonProperty("not-before-policy")
    String not_before_policy;
}
