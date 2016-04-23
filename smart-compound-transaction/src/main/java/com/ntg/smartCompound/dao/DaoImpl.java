package com.ntg.smartCompound.dao;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ntg.smartCompound.entity.User;


@Transactional
@Repository(value="dao")
public class DaoImpl implements Dao {	
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	public void insertUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		System.out.println("User is successfully added to database");
	
	}

}