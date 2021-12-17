package com.aliergul.app.dao.entityuser;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.persistence.TypedQuery;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.aliergul.app.entity.MovieEntity;
import com.aliergul.app.entity.UserEntity;

/**
 * rating ve movis tablosunda user kodu 610 yeni değer 611 olmalı
 * 
 * @author alier
 *
 */

public enum UserDAOImpl implements IUserControllable {
  getInstance;

  /*
   * import org.apache.log4j.LogManager; import org.apache.log4j.Logger;
   */
  private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);
  private static final String TAG = "UserDAOImpl=";

  @Override
  public Optional<UserEntity> onLogin(UserEntity u) {
    try {
      Session session = databaseConnectionHibernate();
      String hql =
          "select u from UserEntity as u where u.userEmail=:email and u.userPassword=:password";
      TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
      typedQuery.setParameter("email", u.getUserEmail().toLowerCase().trim());
      typedQuery.setParameter("password", u.getUserPassword());
      Optional<UserEntity> user = Optional.of(typedQuery.getSingleResult());
      logger.info(TAG + "/ onLogin / isSuccesful \n" + user.get().toString());
      return user;
    } catch (Exception e) {
      logger.error(TAG + "/ onLogin / ERROR:\n" + u.toString() + "\n" + e.getMessage());

    }
    return Optional.empty();
  }

  @Override
  public boolean onRegister(UserEntity u) {
    try {
      Session session = databaseConnectionHibernate();
      session.getTransaction().begin();

      session.persist(u);
      session.getTransaction().commit();
      logger.info(TAG + "/ onRegister / isSuccesful \n" + u.toString());
      return true;
    } catch (Exception e) {
      logger.error(TAG + "/ onRegister / ERROR:\n" + u.toString() + "\n" + e.getMessage());

    }
    return false;
  }

  @Override
  public Set<MovieEntity> getMyMovies(UserEntity u) {
    Set<MovieEntity> list = new HashSet<>();
    Session session = databaseConnectionHibernate();
    String hql =
        "select tag.movie from TagEntity as tag where tag.user =:searchKEY order by timestamp desc";
    TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);
    typedQuery.setParameter("searchKEY", u);
    typedQuery.setMaxResults(5);
    List<MovieEntity> arrayList = typedQuery.getResultList();
    list.addAll(arrayList);
    session = databaseConnectionHibernate();
    String hql2 =
        "select ra.movie from RatingsEntity as ra where ra.user =:searchKEY order by timestamp desc";
    TypedQuery<MovieEntity> typedQuery2 = session.createQuery(hql2, MovieEntity.class);
    typedQuery2.setParameter("searchKEY", u);
    typedQuery2.setMaxResults(5);
    List<MovieEntity> arrayList2 = typedQuery2.getResultList();
    list.addAll(arrayList2);
    return list;
  }

  @Override
  public UserEntity find(long id) {
    // TODO Auto-generated method stub
    return null;
  }

}
