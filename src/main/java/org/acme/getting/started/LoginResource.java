package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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

@ApplicationScoped
@Path("/mobile/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    @Inject
    ValidationService validationService;

    @POST
    public Uni<Response> login(Login login) {
        return Uni.createFrom().item(login)
            .onItem().transform(l -> {
                if (validationService.validateLogin(l)) {
                    return Response.status(Status.BAD_REQUEST).build();
                }
                LoginResponse response = new LoginResponse(
                "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1OTIyNTQyNTcsImF1ZCI6ImdtLWFwcC1hc3Npc3RlZCIsInN1YiI6IjEifQ.Zo6j3Yio5_TYeh45TFjCUoMQe0g3sxVZ82rfwnK7ypw",
                1, "Fernanda");
                return Response.ok(response).build();
            });
    }

    @POST
    @Path("/{delay}")
    public Uni<Response> loginWithDelay(Login login, @PathParam long delay) {
        return Uni.createFrom().item(login).onItem()
            .transform(l -> {
                if (delay<=0) {
                    return Response.status(Status.BAD_REQUEST).build();
                }
                try {
                    Thread.sleep(delay);
                } catch (Exception e) {
                    return Response.status(Status.BAD_REQUEST).build();
                }
                if (validationService.validateLogin(l)) {
                    return Response.status(Status.UNAUTHORIZED).build();
                }
                LoginResponse response = new LoginResponse(
                "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1OTIyNTQyNTcsImF1ZCI6ImdtLWFwcC1hc3Npc3RlZCIsInN1YiI6IjEifQ.Zo6j3Yio5_TYeh45TFjCUoMQe0g3sxVZ82rfwnK7ypw",
                1, "Mariana");
                return Response.ok(response).build();
            });
    }
}