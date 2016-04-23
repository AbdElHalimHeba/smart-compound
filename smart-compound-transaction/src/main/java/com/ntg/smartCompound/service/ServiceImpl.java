package com.ntg.smartCompound.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.jackson.Formatted;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ntg.smartCompound.dao.*;
import com.ntg.smartCompound.service.ServiceInt;
import com.ntg.smartCompound.entity.User;

@Configuration
@ImportResource("classpath:/spring.xml")
@Transactional
@Path("/info")
@Service
public class ServiceImpl implements ServiceInt {

	@GET
	@Path("/print")
	@Produces("application/json")
	@Formatted
	public Response employeeDetailPrint() {
		User user = getUser();
		insertUser();
		return Response.ok(user).build();
	}

	private Dao dao;
	
	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public Dao getDao() {
		return dao;
	}

	public User getUser() {
		User user = new User();
		user.setEmail("email");
		user.setName("name");
		user.setPassword("password");
		user.setCreditCard("creditCard");

		return user;
	}
	
	public void insertUser(){
	
		User user = getUser();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceImpl.class);
		 try {
			 ServiceImpl serviceImpl = (ServiceImpl) context.getBean("serviceImpl");
			 dao = serviceImpl.getDao();
			 dao.insertUser(user);
	        } finally {
	            context.close();
	        }
	}
	
}
