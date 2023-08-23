package org.acme;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public List<Person> getAll() {
        return Person.listAll();
    }

    @POST
    @Transactional
    public Response add(Person pessoa) {
        pessoa.persist();
        return Response.ok(pessoa).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Person pessoa) {
        Person existingPerson = Person.findById(id);
        existingPerson.setEmail(pessoa.getEmail());
        existingPerson.setObservacao(pessoa.getObservacao());
        existingPerson.persist();
        return Response.ok(pessoa).status(Response.Status.OK).build();}

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        Person person = Person.findById(id);
        person.delete();
    }
}