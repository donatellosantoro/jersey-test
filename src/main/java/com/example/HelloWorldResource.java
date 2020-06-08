package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;

@ApplicationScoped
@Path("helloworld")
public class HelloWorldResource {

    @Inject
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorld(@QueryParam("name") String name) {
        if (userRepository == null) {
            throw new IllegalArgumentException();
        }
        return Response
                .ok("Hello " + name + " - " + userRepository)
                .type(MediaType.TEXT_PLAIN)
                .build();
    }

}
