package org.acme.getting.started;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.getting.started.model.Login;
import org.acme.getting.started.model.LoginResponse;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/mobile/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @POST
    public Uni<Response> login(Login login) {
        LoginResponse response = new LoginResponse(
                "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1OTIyNTQyNTcsImF1ZCI6ImdtLWFwcC1hc3Npc3RlZCIsInN1YiI6IjEifQ.Zo6j3Yio5_TYeh45TFjCUoMQe0g3sxVZ82rfwnK7ypw",
                1, "Fernanda");

        if (login.getUsername() == null || login.getPassword() == null) {
            return Uni.createFrom().item(() -> Response.status(Status.UNAUTHORIZED).build());
        }

        return Uni.createFrom().item(() -> Response.ok(response).build());
    }

    @POST
    @Path("/{delay}")
    public Uni<Response> loginWithDelay(Login login, @PathParam long delay) {
        if (delay <= 0) {
            return Uni.createFrom().item(() -> Response.status(Status.BAD_REQUEST).build());
        }

        LoginResponse response = new LoginResponse(
                "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1OTIyNTQyNTcsImF1ZCI6ImdtLWFwcC1hc3Npc3RlZCIsInN1YiI6IjEifQ.Zo6j3Yio5_TYeh45TFjCUoMQe0g3sxVZ82rfwnK7ypw",
                1, "Mariana");

        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            return Uni.createFrom().item(() -> Response.status(Status.INTERNAL_SERVER_ERROR).build());
        }

        if (login.getUsername() == null || login.getPassword() == null) {
            return Uni.createFrom().item(() -> Response.status(Status.UNAUTHORIZED).build());
        }

        return Uni.createFrom().item(() -> Response.ok(response).build());
    }
}