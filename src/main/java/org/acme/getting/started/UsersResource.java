package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.model.User;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Path("/users")
public class UsersResource {
    
    @GET
    public Multi<User> getAllUsers(){
        return Multi.createFrom()
            .items(
                new User(1,"Fernanda"),
                new User(2,"Mariana"));
    }
}