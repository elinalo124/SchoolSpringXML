package com.elina.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


public abstract class AbstractJPARepository< T extends Serializable> implements CourseRepository<T> {

    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public final void setClazz(Class<T> clazzToSet){
        this.clazz = clazzToSet;
    }

    @Override
    public T findById(Long id){
        return entityManager.find( clazz, id );
    }
    @Override
    public List findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    @Override
    @Transactional
    public void save(T entity){
        entityManager.persist( entity );
    }

    @Override
    public T update(T entity){
        return entityManager.merge( entity );
    }

    @Override
    public void delete(T entity){
        entityManager.remove( entity );
    }
    @Override
    public void deleteById(long entityId){
        T entity = findById( entityId );
        delete( entity );
    }
}
