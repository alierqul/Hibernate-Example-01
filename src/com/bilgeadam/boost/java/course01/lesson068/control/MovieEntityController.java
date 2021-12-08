package com.bilgeadam.boost.java.course01.lesson068.control;

import java.util.ArrayList;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import com.bilgeadam.boost.java.course01.lesson068.entity.MovieEntity;

public class MovieEntityController implements Controllable<MovieEntity> {
  @Override
  public void create(MovieEntity entity) {
    try {
      Session session = databaseConnectionHibernate();
      session.getTransaction().begin();
      System.out.println(session);
      session.persist(entity);
      session.getTransaction().commit();
      System.out.println("ekleme tamamdır" + Controllable.class);
    } catch (Exception e) {
      System.out.println("ekleme an�nda hata meydana geldi !!!!! " + Controllable.class);
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
      System.out.println("silme an�nda hata meydana geldi !!!!! " + Controllable.class);
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
      System.out.println("g�ncelleme an�nda hata meydana geldi !!!!! " + Controllable.class);
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<MovieEntity> list() {
    Session session = databaseConnectionHibernate();

    String hql = "select str from MovieEntity as str where str.movieid=16";
    TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);


    // typedQuery.setParameter("key", 0L);

    ArrayList<MovieEntity> arrayList = (ArrayList<MovieEntity>) typedQuery.getResultList();
    System.out.println("listelendi " + MovieEntity.class);
    return arrayList;
  }

  @Override
  public MovieEntity find(long id) {
    Session session = databaseConnectionHibernate();
    MovieEntity entity;
    try {
      entity = session.find(MovieEntity.class, id);

      if (entity != null) {
        System.out.println("bulundu... " + entity);
        session.close();
        return entity;
      } else {
        System.out.println("Aradığınız kriterde sonuçlar bulunamad� ...");
        session.close();
        return null;
      }
    } catch (Exception e) {
      System.out.println("find an�nda hata meydana geldi !!!!! " + Controllable.class);
      session.close();
      e.printStackTrace();
    }
    session.close();
    return null;
  }

  @Override
  public MovieEntity singleResult(long id) {
    return Controllable.super.singleResult(id);
  }

}
