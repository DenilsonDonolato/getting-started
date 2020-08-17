package org.acme.getting.started.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Login {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
    
}
