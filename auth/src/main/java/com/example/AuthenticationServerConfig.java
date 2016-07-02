package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Authentication configuration
 */
@Configuration
public class AuthenticationServerConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Autowired // DO NOT REMOVE THIS OR SPRING WILL USE DEFAULT AUTHENTICATION MANAGER
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new ZingSSOAuthenticationProvider(new UserService()));
    }
}

