package com.example;

import java.util.List;

/**
 * User entity
 */
public class User {
    private String userName;

    private List<String> authorities;

    public User(String userName, List<String> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public String userName() {
        return this.userName;
    }

    public List<String> authorities() {
        return this.authorities;
    }
}
