package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.model.User;

import io.smallrye.mutiny.Multi;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Path("/users")
public class UsersResource {

    private Logger logger = LoggerFactory.getLogger(UsersResource.class);
    
    @GET
    public Multi<User> getAllUsers(){
        logger.info("reading all users");
        return Multi.createFrom()
            .items(
                new User(1,"Fernanda"),
                new User(2,"Mariana"));
    }
}