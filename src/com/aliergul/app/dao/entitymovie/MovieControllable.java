package com.aliergul.app.dao.entitymovie;

import java.util.ArrayList;
import org.hibernate.Session;
import com.aliergul.app.utils.HibernateUtils;

public interface MovieControllable<T> {
  public void create(T entity);// ekleme

  public void delete(T entity);// silmek

  public void update(T entity);// g�ncelleme

  public ArrayList<T> list(long startCount, long finishCount);


  default T find(long id) {
    return null;
  }

  default T singleResult(long id) {
    return null;
  }

  default Session databaseConnectionHibernate() {
    return HibernateUtils.getSessionFactory().openSession();
  }
}