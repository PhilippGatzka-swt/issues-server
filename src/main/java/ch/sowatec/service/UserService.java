package ch.sowatec.service;

import ch.sowatec.entity.User;
import net.internalerror.MyLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class UserService implements IService<User> {

    @Inject
    EntityManager entityManager;

    @Override
    public User create(User entity) {
        LOGGER.log(MyLogger.Level.INFO, "User -> create");
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        LOGGER.log(MyLogger.Level.INFO, "User -> findAll");
        return entityManager.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User find(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "User -> find");
        return entityManager.find(User.class, id);
    }

    public User find(User user) {
        LOGGER.log(MyLogger.Level.INFO, "User -> find");
        Query query = entityManager.createQuery("select u from User u where u.username = :username and u.password = :password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return (User) query.getSingleResult();
    }

    @Override
    public User update(User entity) {
        LOGGER.log(MyLogger.Level.INFO, "User -> update");
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "User -> update");
        entityManager.remove(find(id));
    }
}
