package com.aliergul.app.controller.userlistmovie;

import com.aliergul.app.entity.MovieEntity;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class MovieListViewCell extends ListCell<MovieEntity> {

  private final MovieLineViewController movieLineViewController = new MovieLineViewController();
  private final Node view = movieLineViewController.getView();

  @Override
  protected void updateItem(MovieEntity item, boolean empty) {
    // super.updateItem(item, empty);
    if (empty) {
      setGraphic(null);
    } else {
      movieLineViewController.setTicket(item);
      setGraphic(view);
    }
  }



}
