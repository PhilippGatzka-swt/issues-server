package ch.sowatec.service;

import ch.sowatec.entity.Tag;
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
public class TagService implements IService<Tag> {

    @Inject
    EntityManager entityManager;

    @Override
    public Tag create(Tag entity) {
        LOGGER.log(MyLogger.Level.INFO, "Tag -> create");
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tag> findAll() {
        LOGGER.log(MyLogger.Level.INFO, "Tag -> findAll");
        return entityManager.createNamedQuery("Tag.findAll").getResultList();
    }

    @Override
    public Tag find(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "Tag -> find");
        return entityManager.find(Tag.class, id);
    }

    @Override
    public Tag update(Tag entity) {
        LOGGER.log(MyLogger.Level.INFO, "Tag -> update");
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        LOGGER.log(MyLogger.Level.INFO, "Tag -> delete");
        entityManager.remove(find(id));
    }
}
