package com.aliergul.app.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.aliergul.app.controller.listratings.RatingListViewCell;
import com.aliergul.app.controller.userlistmovie.MovieListViewCell;
import com.aliergul.app.dao.entityuser.UserDAOImpl;
import com.aliergul.app.entity.MovieEntity;
import com.aliergul.app.entity.RatingsEntity;
import com.aliergul.app.entity.TagEntity;
import com.aliergul.app.entity.UserEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class HomePageController {

  private static final String TAG = "HomePageController";

  Logger logger = LogManager.getLogger(HomePageController.class);
  private UserEntity user = new UserEntity("", "", "");

  ObservableList<RatingsEntity> ratings = FXCollections.observableArrayList();
  ObservableList<MovieEntity> movies = FXCollections.observableArrayList();

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
  private ListView<TagEntity> homepage_home_lv_tags;

  @FXML
  private ListView<RatingsEntity> homepage_home_lv_ratings;

  @FXML
  private ListView<MovieEntity> homepage_home_lv_movie;

  @FXML
  void onClickSearchBtn(MouseEvent event) {

  }



  public void initUserInfo(UserEntity user) {
    this.user = user;
    homepage_home_tv_username.setText(user.getUserName());
    homepage_home_tv_email.setText(user.getUserEmail());

    ratings.setAll(user.getRatings());
    homepage_home_lv_ratings.setItems(ratings);
    homepage_home_lv_ratings
        .setCellFactory(new Callback<ListView<RatingsEntity>, ListCell<RatingsEntity>>() {

          @Override
          public ListCell<RatingsEntity> call(ListView<RatingsEntity> param) {
            return new RatingListViewCell();
          }
        });

    movies.addAll(UserDAOImpl.getInstance.getMyMovies(user));

    homepage_home_lv_movie.setItems(movies);
    homepage_home_lv_movie
        .setCellFactory(new Callback<ListView<MovieEntity>, ListCell<MovieEntity>>() {

          @Override
          public ListCell<MovieEntity> call(ListView<MovieEntity> param) {
            return new MovieListViewCell();
          }
        });

  }


}
