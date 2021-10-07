package ch.sowatec.controller;

import ch.sowatec.entity.Answer;
import ch.sowatec.service.AnswerService;
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
@Path("/answers")
public class AnswerController implements IController<Answer> {

    @Inject
    AnswerService answerService;

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Answer create(Answer entity) {
        return answerService.create(entity);
    }

    @Override
    @GET
    @Produces(APPLICATION_JSON)
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Answer find(@PathParam("id") Long id) {
        return answerService.find(id);
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Answer update(Answer entity) {
        return answerService.update(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        answerService.delete(id);
    }
}
