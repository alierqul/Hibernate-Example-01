package com.aliergul.app.dao.entityuser;

import java.util.Optional;
import org.hibernate.Session;
import com.aliergul.app.entity.UserEntity;
import com.aliergul.app.utils.HibernateUtils;

public interface IUserControllable {
  public Optional<UserEntity> onLogin(UserEntity u);

  public boolean onRegister(UserEntity u);

  default Session databaseConnectionHibernate() {
    return HibernateUtils.getSessionFactory().openSession();
  }
}
