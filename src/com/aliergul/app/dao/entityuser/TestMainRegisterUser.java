package com.aliergul.app.dao.entityuser;

import com.aliergul.app.entity.UserEntity;

public class TestMainRegisterUser {

  public static void main(String[] args) {
    UserDAOImpl dao = new UserDAOImpl();
    dao.onRegister(new UserEntity("alierqul", "alierqul", "123"));


  }

}
