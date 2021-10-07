package ch.sowatec.controller;

import ch.sowatec.entity.Issue;
import ch.sowatec.service.IssueService;
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
@Path("/issues")
@Authenticated
public class IssueController implements IController<Issue> {

    @Inject
    IssueService issueService;

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Issue create(Issue entity) {
        return issueService.create(entity);
    }

    @Override
    @GET
    @Produces(APPLICATION_JSON)
    public List<Issue> findAll() {
        return issueService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Issue find(@PathParam("id") Long id) {
        return issueService.find(id);
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Issue update(Issue entity) {
        return issueService.update(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        issueService.delete(id);
    }
}
