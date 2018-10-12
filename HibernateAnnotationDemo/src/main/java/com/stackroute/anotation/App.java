package com.stackroute.anotation;

import java.util.Date;

import org.hibernate.Session;

import com.stackroute.anotation.HibernateUtil;
import com.stackroute.model.User;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUserId(1);
		user.setUsername("Manik");
		user.setCreatedBy("Stackroute");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
	}
}
