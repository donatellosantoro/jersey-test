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
    private User user;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorld(@QueryParam("name") String name) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        user.setName(name);
        return Response
                .ok("Hello " + user.getName())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }

}
