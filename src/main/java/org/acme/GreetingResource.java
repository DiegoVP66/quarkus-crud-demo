package org.acme;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/h2")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> hello() {
        return Person.listAll();
    }
    
}
