package com.aliergul.app.controller.listratings;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.controlsfx.control.Rating;
import com.aliergul.app.entity.RatingsEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class RatingLineViewController implements Initializable {

  private AnchorPane anchorPane;
  @FXML
  private Label rating_detail_date;

  @FXML
  private Rating rating_detail_rating;

  @FXML
  private Label rating_detail_title;

  public RatingLineViewController() {

    try {
      // assumes FXML file is in same package as this controller
      // (also make sure name of FXML resource is correct)
      FXMLLoader loader = new FXMLLoader(getClass().getResource("RatingLineView.fxml"));
      loader.setController(this);
      anchorPane = loader.load();
    } catch (IOException exc) {
      // pretty much fatal here...
      throw new UncheckedIOException(exc);
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Logger logger = LogManager.getLogger(RatingLineViewController.class);
    BasicConfigurator.configure();

  }

  public void setTicket(RatingsEntity item) {
    rating_detail_date.setText(new Date(item.getTimestamp()).toString());
    rating_detail_title.setText(item.getMovie().getTitle());
    rating_detail_rating.setRating(item.getRating());
  }

  public Node getView() {
    return anchorPane;
  }

}
