/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 *
 * @author oiprado
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/admin/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers()
//            .antMatchers(SECURED_PATTERN).and().authorizeRequests()
//            .antMatchers(HttpMethod.POST, SECURED_PATTERN)
//            .access(SECURED_WRITE_SCOPE)
//            .anyRequest()Completed 400 BAD_REQUEST
//            .access(SECURED_READ_SCOPE);

//        http.requestMatchers()
//                .antMatchers(SECURED_PATTERN)
//                .and().authorizeRequests()
//                    .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
//                    .anyRequest().access(SECURED_READ_SCOPE)
//                .and()
//                    .authorizeRequests()
//                    .antMatchers("/public/**").permitAll();
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/login", "/oauth/authorize").permitAll()
//            .antMatchers("/", "/login**").permitAll()
            .antMatchers(SECURED_PATTERN).authenticated()
            .and().authorizeRequests().antMatchers("/api/**").permitAll();
//            .and().authorizeRequests().antMatchers("/oauth/**").permitAll();
        /*.antMatchers(HttpMethod.POST, SECURED_PATTERN)
            .access(SECURED_WRITE_SCOPE)
            .anyRequest()
            .access(SECURED_READ_SCOPE)*/
    }
}
