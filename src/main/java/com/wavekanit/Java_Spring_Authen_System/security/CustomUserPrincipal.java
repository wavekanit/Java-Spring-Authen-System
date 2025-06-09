package com.wavekanit.Java_Spring_Authen_System.security;

import lombok.Getter;

@Getter
class CustomUserPrincipal {
    private final String username;
    private final int access;

    public CustomUserPrincipal(String username, int access) {
        this.username = username;
        this.access = access;
    }
}