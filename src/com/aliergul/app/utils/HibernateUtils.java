package com.aliergul.app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.aliergul.app.entity.LinkEntity;
import com.aliergul.app.entity.MovieEntity;
import com.aliergul.app.entity.RatingsEntity;
import com.aliergul.app.entity.TagEntity;
import com.aliergul.app.entity.UserEntity;

public class HibernateUtils {
  private static final SessionFactory sessionFactory = sessionFactory();

  private static SessionFactory sessionFactory() {
    try {
      Configuration configuration = new Configuration();

      // entity class'larımızı buraya ekleyeceğiz

      configuration.addAnnotatedClass(MovieEntity.class);
      configuration.addAnnotatedClass(RatingsEntity.class);
      configuration.addAnnotatedClass(TagEntity.class);
      configuration.addAnnotatedClass(LinkEntity.class);
      configuration.addAnnotatedClass(UserEntity.class);
      SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

      return factory;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
