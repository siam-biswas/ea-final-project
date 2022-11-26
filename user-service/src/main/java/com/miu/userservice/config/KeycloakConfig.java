package com.miu.userservice.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

import javax.ws.rs.client.ClientBuilder;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    final static String serverUrl = "http://localhost:8099/";
    public final static String realm = "miu";
    final static String clientId = "authentication";
    final static String clientSecret = "abcdefghijkl";
    final static String userName = "admin";
    final static String password = "admin";


    public KeycloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            var builder = ClientBuilder.newClient();

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(builder)
                    .build();
        }
        return keycloak;
    }
}