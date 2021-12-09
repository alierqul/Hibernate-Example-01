package com.aliergul.app.controller;

import java.io.IOException;
import java.util.Optional;
import com.aliergul.app.dao.entityuser.UserDAOImpl;
import com.aliergul.app.entity.UserEntity;
import com.aliergul.app.login.MainTest;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {
  private UserEntity user;
  @FXML
  private Button btn_login;

  @FXML
  private TextField edt_user_email;

  @FXML
  private PasswordField edt_user_password;

  @FXML
  private Button register_btn;

  @FXML
  private TextField register_edt_email;

  @FXML
  private PasswordField register_edt_pasword;

  @FXML
  private PasswordField register_edt_re_password;

  @FXML
  private TextField register_edt_username;



  @FXML
  void onRegisterClick(MouseEvent event) {
    register_btn.setDisable(true);
    UserDAOImpl dao = new UserDAOImpl();

    Alert alert = new Alert(AlertType.INFORMATION);

    if (regexUserInformation()) {
      if (dao.onRegister(user)) {
        alert.setAlertType(AlertType.INFORMATION);
        alert.setTitle("Kayıt Başarılı");

      } else {
        alert.setAlertType(AlertType.WARNING);
        alert.setTitle("Kayıt Başarısız");
        alert.setHeaderText("Lütfen Bilgilerinizi kontrol ediniz.");
      }
      alert.show();
    }
    register_btn.setDisable(false);

  }

  private boolean regexUserInformation() {
    String username = register_edt_username.getText();
    String email = register_edt_email.getText();
    String password = register_edt_pasword.getText();
    String rePassword = register_edt_re_password.getText();

    user = new UserEntity(username, email, password);

    if (password.equals(rePassword)) {
      return true;
    } else {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Şifreler Eşleşmiyor");
      alert.show();
    }
    return false;
  }

  @FXML
  void onClickBtnLogin(MouseEvent event) {

    btn_login.setDisable(true);
    UserDAOImpl dao = new UserDAOImpl();
    String email = edt_user_email.getText();
    String password = edt_user_password.getText();
    Alert alert = new Alert(AlertType.INFORMATION);
    Optional<UserEntity> opt = dao.onLogin(new UserEntity(email, password));

    if (!opt.isEmpty()) {
      alert.setAlertType(AlertType.INFORMATION);
      alert.setTitle("Giriş Başarılı");
      try {
        MainTest.setRoot("HomePage");
      } catch (IOException e) {
        e.printStackTrace();
      }

    } else {
      alert.setAlertType(AlertType.WARNING);
      alert.setTitle("Giriş Başarısız");

    }
    alert.show();
    btn_login.setDisable(false);
  }

}
