package com.aliergul.app.controller;

import com.aliergul.app.entity.UserEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HomePageController {
  private UserEntity user = new UserEntity("", "", "");


  @FXML
  private Button homepage_home_btn_search;

  @FXML
  private TextField homepage_home_edt_searchkey;

  @FXML
  private Label homepage_home_tv_email;

  @FXML
  private Label homepage_home_tv_password;

  @FXML
  private Label homepage_home_tv_username;

  @FXML
  void onClickSearchBtn(MouseEvent event) {

  }

  public void initUserInfo(UserEntity user) {
    this.user = user;
    homepage_home_tv_username.setText(user.getUserName());
    homepage_home_tv_email.setText(user.getUserEmail());
  }
}
