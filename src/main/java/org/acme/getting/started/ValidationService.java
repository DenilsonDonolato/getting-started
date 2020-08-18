package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

import org.acme.getting.started.model.Login;

@ApplicationScoped
public class ValidationService {

    public boolean validateLogin(Login login) {
        return login.getUsername().isBlank() || login.getPassword().isBlank();
    }
}