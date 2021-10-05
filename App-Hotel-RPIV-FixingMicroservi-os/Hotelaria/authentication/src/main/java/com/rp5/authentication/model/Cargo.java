package com.rp5.authentication.model;

import org.springframework.security.core.GrantedAuthority;

public enum Cargo implements GrantedAuthority {
    CARGO_ADM, CARGO_CLIENTE;

    @Override
    public String getAuthority() {
        return name();
    }
}
