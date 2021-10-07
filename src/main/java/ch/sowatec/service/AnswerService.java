package ch.sowatec.service;

import ch.sowatec.entity.Answer;
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
public class AnswerService implements IService<Answer> {

    @Inject
    EntityManager entityManager;

    @Override
    public Answer create(Answer entity) {
        LOGGER.log(MyLogger.Level.INFO,"Answer -> create");
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Answer> findAll() {
        LOGGER.log(MyLogger.Level.INFO,"Answer -> findAll");
        return entityManager.createNamedQuery("Answer.findAll").getResultList();
    }

    @Override
    public Answer find(Long id) {
        LOGGER.log(MyLogger.Level.INFO,"Answer -> find");
        return entityManager.find(Answer.class,id);
    }

    @Override
    public Answer update(Answer entity) {
        LOGGER.log(MyLogger.Level.INFO,"Answer -> update");
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        LOGGER.log(MyLogger.Level.INFO,"Answer -> delete");
        entityManager.remove(find(id));
    }
}
