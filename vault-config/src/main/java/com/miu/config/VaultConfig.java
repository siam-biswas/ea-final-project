package com.miu.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class VaultConfig {

    @Value("${login}")
    private String login;
    @Value("${password}")
    private String password ;

}
