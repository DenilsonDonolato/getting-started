package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

import org.acme.getting.started.model.Login;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@ApplicationScoped
public class ValidationService {

    private Logger logger = LoggerFactory.getLogger(ValidationService.class);

    public boolean validateLogin(Login login) {
        logger.info("Validando user "+login);
        return login.getUsername().isBlank() || login.getPassword().isBlank();
    }
}