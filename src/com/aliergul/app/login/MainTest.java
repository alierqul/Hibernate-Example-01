package com.aliergul.app.login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// VM Arguments
// --module-path "D:\Eclipse2021\library\openjfx-17.0.1_windows-x64_bin-sdk\javafx-sdk-17.0.1\lib"
// --add-modules javafx.controls,javafx.fxml
public class MainTest extends Application {
  private static Scene scene;


  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {
    scene = new Scene(loadFXML("LoginPage"), 800, 600);
    stage.setScene(scene);
    stage.show();

  }

  public static void setRoot(String fxml) throws IOException {

    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainTest.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }


}
