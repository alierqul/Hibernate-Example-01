package com.aliergul.app.dao.entityuser;


import java.util.Optional;
import javax.persistence.TypedQuery;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.aliergul.app.entity.UserEntity;

/**
 * rating ve movis tablosunda user kodu 610 yeni değer 611 olmalı
 * 
 * @author alier
 *
 */

public class UserDAOImpl implements IUserControllable {
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
      logger.info(TAG + "/ onLogin / isSuccesful \n" + u.toString());
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

}
