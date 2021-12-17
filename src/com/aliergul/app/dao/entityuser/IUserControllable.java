package com.aliergul.app.dao.entityuser;

import java.util.Optional;
import java.util.Set;
import org.hibernate.Session;
import com.aliergul.app.entity.MovieEntity;
import com.aliergul.app.entity.UserEntity;
import com.aliergul.app.utils.HibernateUtils;

public interface IUserControllable {
  public Optional<UserEntity> onLogin(UserEntity u);

  public boolean onRegister(UserEntity u);

  public Set<MovieEntity> getMyMovies(UserEntity u);

  public UserEntity find(long id);

  default Session databaseConnectionHibernate() {
    return HibernateUtils.getSessionFactory().openSession();
  }
}
