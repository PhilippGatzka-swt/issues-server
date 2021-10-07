package ch.sowatec.controller;

import ch.sowatec.entity.Tag;
import ch.sowatec.service.TagService;
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
@Path("/tags")
public class TagController implements IController<Tag> {

    @Inject
    TagService tagService;

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Tag create(Tag entity) {
        return tagService.create(entity);
    }

    @Override
    @GET
    @Produces(APPLICATION_JSON)
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Tag find(@PathParam("id") Long id) {
        return tagService.find(id);
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Tag update(Tag entity) {
        return tagService.update(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        tagService.delete(id);
    }
}
