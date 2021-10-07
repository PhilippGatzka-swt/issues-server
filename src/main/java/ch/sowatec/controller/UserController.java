package ch.sowatec.controller;

import ch.sowatec.LoginViewModel;
import ch.sowatec.entity.User;
import ch.sowatec.service.AuthenticationService;
import ch.sowatec.service.UserService;
import net.internalerror.MyLogger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
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
@Path("/users")
public class UserController implements IController<User> {

    private static final MyLogger LOGGER = MyLogger.getLogger(UserController.class.getName());

    @Inject
    UserService userService;
    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/login")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public LoginViewModel login(User user){
        LOGGER.log(MyLogger.Level.INFO,"Attempting login of user: " + user.getUsername());
        User check = userService.find(user);
        if (check == null){
            NotAuthorizedException e = new NotAuthorizedException("User not found");
            LOGGER.log(MyLogger.Level.SEVERE,"Login attempt failed", e);
            throw e;
        }else{
            LOGGER.log(MyLogger.Level.SEVERE,"Login attempt succeeded");
            return new LoginViewModel(authenticationService.generateJWTToken(user.getUsername()),check.getId());
        }
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public User create(User entity) {
        return userService.create(entity);
    }

    @Override
    @GET
    @Produces(APPLICATION_JSON)
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public User find(@PathParam("id") Long id) {
        return userService.find(id);
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public User update(User entity) {
        return userService.update(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        userService.delete(id);
    }
}
