package com.ntgclarity.smartcompound.dataaccess.base;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Repository
@Transactional
public abstract class BaseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Object saveOrUpdate(Object entity) {
		getCurrentSession().persist(entity);
		return entity;
	}

	public List getAll(Class cls) {
		Query query = getCurrentSession().createQuery(
				"from " + cls.getCanonicalName());
		List result = query.list();
		return result;
	}

	public Object get(Class<? extends BaseEntity> clazz, Long id) {
		return getCurrentSession().get(clazz, id);
	}

}
