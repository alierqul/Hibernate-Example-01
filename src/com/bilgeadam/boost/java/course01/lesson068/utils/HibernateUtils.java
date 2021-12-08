package com.bilgeadam.boost.java.course01.lesson068.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.boost.java.course01.lesson068.entity.GenreEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.LinkEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.MovieEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.TagEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.UserEntity;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = sessionFactory();

	private static SessionFactory sessionFactory() {
		try {
			Configuration configuration = new Configuration();

			// entity class'larýmýzý buraya ekleyeceðiz
			configuration.addAnnotatedClass(MovieEntity.class);
			configuration.addAnnotatedClass(UserEntity.class);
			configuration.addAnnotatedClass(LinkEntity.class);
			configuration.addAnnotatedClass(TagEntity.class);
			configuration.addAnnotatedClass(GenreEntity.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
