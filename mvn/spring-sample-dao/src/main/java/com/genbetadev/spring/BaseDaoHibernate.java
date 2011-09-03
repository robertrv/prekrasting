package com.genbetadev.spring;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BaseDaoHibernate<T extends Serializable, E> extends HibernateDaoSupport implements BaseDao<T, E> {
    public void deleteAll(final Collection<T> instances) throws Exception {
        try {
            getHibernateTemplate().deleteAll(instances);
        } catch (final Exception e) {
            throw e;
        }
    }
    public int bulkUpdate(final String query) throws Exception {
        try {
            return getHibernateTemplate().bulkUpdate(query);
        } catch (final Exception e) {
            throw e;
        }
    }
    public E save(final T instance) throws Exception {
        try {
            return (E) getHibernateTemplate().save(instance);
        } catch (final Exception e) {
            throw e;
        }
    }
    public void saveOrUpdateAll(final Collection<T> instances) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdateAll(instances);
        } catch (final Exception e) {
            throw e;
        }
    }
    public void saveOrUpdate(final T instance) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(instance);
        } catch (final Exception e) {
            throw e;
        }
    }
    public void persist(final T transientInstance) throws Exception {
        try {
            getHibernateTemplate().persist(transientInstance);
        } catch (final Exception e) {
            throw e;
        }
    }
    public void attachDirty(final T instance) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(instance);
        } catch (final Exception e) {
            throw e;
        }
    }
    public void attachClean(final T instance) throws Exception {
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
        } catch (final Exception e) {
            throw e;
        }
    }
    public void delete(final T persistentInstance) throws Exception {
        try {
            getHibernateTemplate().delete(persistentInstance);
        } catch (final Exception e) {
            throw e;
        }
    }
    public T merge(final T detachedInstance) throws Exception {
        try {
            final T result = getHibernateTemplate().merge(detachedInstance);
            return result;
        } catch (final Exception e) {
            throw e;
        }
    }
    public List<T> findByExample(final T instance) throws Exception {
        try {
            final List<T> results = getHibernateTemplate().findByExample(instance);
            return results;
        } catch (final Exception e) {
            throw e;
        }
    }
    public List<T> findByQuery(final String queryString) throws Exception {
        try {
            final List<T> results = getHibernateTemplate().find(queryString);
            return results;
        } catch (final Exception e) {
            throw e;
        }
    }
    public List<Map<String, Object>> findMapByQuery(final String queryString) throws Exception {
        try {
            final List<Map<String, Object>> results = getHibernateTemplate().find(queryString);
            return results;
        } catch (final Exception e) {
            throw e;
        }
    }
    public List<T> findByCriteria(final DetachedCriteria criteria) throws Exception {
        try {
            return getHibernateTemplate().findByCriteria(criteria);
        } catch (final Exception e) {
            throw e;
        }
    }
    public abstract List<T> findAll() throws Exception;
    public abstract T findById(E id) throws Exception;
}