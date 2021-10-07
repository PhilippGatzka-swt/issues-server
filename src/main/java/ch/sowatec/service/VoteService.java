package ch.sowatec.service;

import ch.sowatec.entity.Vote;
import net.internalerror.MyLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class VoteService implements IService<Vote> {

    @Inject
    EntityManager entityManager;

    @Override
    public Vote create(Vote entity) {
        LOGGER.log(MyLogger.Level.INFO, "Vote -> create");
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vote> findAll() {
        LOGGER.log(MyLogger.Level.INFO, "Vote -> findAll");
        return entityManager.createNamedQuery("Vote.findAll").getResultList();
    }

    @Override
    public Vote find(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "Vote -> find");
        return entityManager.find(Vote.class, id);
    }

    @Override
    public Vote update(Vote entity) {
        LOGGER.log(MyLogger.Level.INFO, "Vote -> update");
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "Vote -> delete");
        entityManager.remove(find(id));
    }
}
