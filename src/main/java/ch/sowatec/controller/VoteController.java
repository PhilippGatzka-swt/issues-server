package ch.sowatec.controller;


import ch.sowatec.entity.Vote;
import ch.sowatec.service.VoteService;
import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
@Authenticated
@Path("/votes")
public class VoteController implements IController<Vote> {

    @Inject
    VoteService voteService;

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Vote create(Vote entity) {
        return voteService.create(entity);
    }

    @Override
    @GET
    @Produces(APPLICATION_JSON)

    public List<Vote> findAll() {
        return voteService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Vote find(@PathParam("id") Long id) {
        return voteService.find(id);
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Vote update(Vote entity) {
        return voteService.update(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        voteService.delete(id);
    }
}
