package com.bilgeadam.boost.java.course01.lesson068.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bilgeadam.boost.java.course01.lesson068.entity.LinkEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.MovieEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.RatingsEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.TagEntity;

public class HibernateUtils {
  private static final SessionFactory sessionFactory = sessionFactory();

  private static SessionFactory sessionFactory() {
    try {
      Configuration configuration = new Configuration();

      // entity class'lar�m�z� buraya ekleyece�iz

      configuration.addAnnotatedClass(MovieEntity.class);
      configuration.addAnnotatedClass(RatingsEntity.class);
      configuration.addAnnotatedClass(TagEntity.class);
      configuration.addAnnotatedClass(LinkEntity.class);
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
