package com.perfiltic.oiprado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableResourceServer
@EnableScheduling
@EnableTransactionManagement
public class PerfilTICApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PerfilTICApplication.class, args);
    }

}
