package com.ssaxel03.simplequote.daos;

import com.ssaxel03.simplequote.model.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class GenericDao<T extends Model> implements Dao<T> {

    protected Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;

    public GenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }


    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();

    }


    @Override
    public T findById(Integer id) {
        return em.find(modelType, id);
    }
    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(T modelObject) {
        em.remove(modelObject);
    }

    @Override
    public T findByField(String fieldName, Object value) {
        try {
            return em.createQuery(
                            "SELECT t FROM " + modelType.getSimpleName() + " t WHERE t." + fieldName + " = :value", modelType)
                    .setParameter("value", value)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
}
