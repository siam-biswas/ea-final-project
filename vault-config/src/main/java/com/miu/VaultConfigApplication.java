package com.miu;

import com.miu.config.VaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VaultConfigApplication {

    private static Logger logger = LoggerFactory.getLogger(VaultConfigApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VaultConfigApplication.class,args);
        VaultConfig vaultConfig= context.getBean(VaultConfig.class);
        logger.info("Login: "+vaultConfig.getLogin());
        logger.info("Password: "+vaultConfig.getPassword());
    }
}