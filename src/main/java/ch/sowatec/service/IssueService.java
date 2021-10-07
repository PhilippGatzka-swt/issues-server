package ch.sowatec.service;

import ch.sowatec.entity.Issue;
import net.internalerror.MyLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
@ApplicationScoped
public class IssueService implements IService<Issue> {

    @Inject
    EntityManager entityManager;

    @Override
    public Issue create(Issue entity) {
        LOGGER.log(MyLogger.Level.INFO, "Issue -> create");
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Issue> findAll() {
        LOGGER.log(MyLogger.Level.INFO, "Issue -> findAll");
        return entityManager.createNamedQuery("Issue.findAll").getResultList();
    }

    @Override
    public Issue find(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "Issue -> find");
        return entityManager.find(Issue.class, id);
    }

    @Override
    public Issue update(Issue entity) {
        LOGGER.log(MyLogger.Level.INFO, "Issue -> update");
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "Issue -> delete");
        entityManager.remove(find(id));
    }
}
