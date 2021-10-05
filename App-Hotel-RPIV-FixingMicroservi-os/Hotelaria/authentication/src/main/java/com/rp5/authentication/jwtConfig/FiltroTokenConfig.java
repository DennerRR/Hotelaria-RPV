package com.rp5.authentication.jwtConfig;


import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class FiltroTokenConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private Token token;

    public FiltroTokenConfig(Token token) {
        this.token = token;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        FiltroToken customFilter = new FiltroToken(token);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}