package com.aliergul.app.controller.userlistmovie;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.controlsfx.control.Rating;
import com.aliergul.app.dao.entitymovie.MovieDAOImpl;
import com.aliergul.app.entity.MovieEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MovieLineViewController implements Initializable {
  private static final String TAG = "MovieLineViewController";
  private Logger logger = LogManager.getLogger(MovieLineViewController.class);

  private AnchorPane anchorPane;

  @FXML
  private Label movie_tv_date;

  @FXML
  private Label movie_tv_genre;

  @FXML
  private Rating movie_tv_rating;

  @FXML
  private Label movie_tv_rating_sum;

  @FXML
  private Label movie_tv_tag;

  @FXML
  private Label movie_tv_title;

  public MovieLineViewController() {

    try {
      // assumes FXML file is in same package as this controller
      // (also make sure name of FXML resource is correct)
      FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieLineView.fxml"));
      loader.setController(this);
      anchorPane = loader.load();
    } catch (IOException exc) {
      // pretty much fatal here...
      throw new UncheckedIOException(exc);
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    BasicConfigurator.configure();

  }


  public void setTicket(MovieEntity item) {
    movie_tv_date.setText(
        item.getTitle().substring(item.getTitle().length() - 5, item.getTitle().length() - 1));
    movie_tv_genre.setText(item.getGenres());
    movie_tv_rating.setRating(MovieDAOImpl.getInstance.getAVGRating(item));
    movie_tv_rating_sum.setText("Kullanılan Oy: " + MovieDAOImpl.getInstance.getSumRating(item));
    // movie_tv_tag.setText(MovieDAOImpl.getInstance.getAllTag(item));
    movie_tv_title.setText(item.getTitle());
  }

  public Node getView() {
    return anchorPane;
  }

}
