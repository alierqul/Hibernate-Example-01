package com.aliergul.app.dao.entitymovie;

import java.util.ArrayList;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import com.aliergul.app.entity.MovieEntity;

public enum MovieDAOImpl implements MovieControllable<MovieEntity> {
  getInstance;

  @Override
  public void create(MovieEntity entity) {
    try {
      Session session = databaseConnectionHibernate();
      session.getTransaction().begin();
      System.out.println(session);
      session.persist(entity);
      session.getTransaction().commit();
      System.out.println("ekleme tamamdır" + MovieControllable.class);
    } catch (Exception e) {
      System.out.println("ekleme an�nda hata meydana geldi !!!!! " + MovieControllable.class);
      e.printStackTrace();
    }
  }

  @Override
  public void delete(MovieEntity entity) {

    try {
      MovieEntity findEntity = find(entity.getMovieid());
      if (findEntity != null) {
        Session session = databaseConnectionHibernate();
        session.getTransaction().begin();
        session.remove(findEntity);
        session.getTransaction().commit();
        System.out.println("Silme Ba�ar�l� " + MovieEntity.class);
      }
    } catch (Exception e) {
      System.out.println("silme an�nda hata meydana geldi !!!!! " + MovieControllable.class);
      e.printStackTrace();
    }

  }

  @Override
  public void update(MovieEntity entity) {
    try {
      MovieEntity findEntity = find(entity.getMovieid());
      if (findEntity != null) {
        findEntity.setGenres(entity.getGenres());
        // findEntity.setLinks(entity.getLinks());
        // findEntity.setRatings(entity.getRatings());
        // findEntity.setTags(entity.getTags());
        findEntity.setTitle(entity.getTitle());

        Session session = databaseConnectionHibernate();
        session.getTransaction().begin();
        session.merge(findEntity);
        session.getTransaction().commit();
        System.out.println("G�ncelleme Ba�ar�l� " + MovieEntity.class);
      }

    } catch (Exception e) {
      System.out.println("g�ncelleme an�nda hata meydana geldi !!!!! " + MovieControllable.class);
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<MovieEntity> list(long startCount, long finishCount) {
    Session session = databaseConnectionHibernate();

    String hql =
        "select str from MovieEntity as str where str.movieid>=:startCount and str.movieid<=:finishCount";
    TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);
    typedQuery.setParameter("startCount", startCount);
    typedQuery.setParameter("finishCount", finishCount);
    ArrayList<MovieEntity> arrayList = (ArrayList<MovieEntity>) typedQuery.getResultList();

    return arrayList;
  }

  @Override
  public MovieEntity find(long id) {
    Session session = databaseConnectionHibernate();
    MovieEntity entity;
    try {
      entity = session.find(MovieEntity.class, id);

      if (entity != null) {
        return entity;
      } else {
        return null;
      }
    } catch (Exception e) {

    }
    return null;
  }

  @Override
  public MovieEntity singleResult(long id) {
    return MovieControllable.super.singleResult(id);
  }

  @Override
  public ArrayList<MovieEntity> search(String tag) {
    Session session = databaseConnectionHibernate();

    String hql =
        "select str from MovieEntity as str where LIKE str.title :searchKEY OR str.tag :searchKEY";
    TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);
    typedQuery.setParameter("searchKEY", "%" + tag + "%");
    ArrayList<MovieEntity> arrayList = (ArrayList<MovieEntity>) typedQuery.getResultList();

    return arrayList;
  }


}
