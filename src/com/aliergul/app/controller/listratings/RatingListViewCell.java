package com.aliergul.app.controller.listratings;

import com.aliergul.app.entity.RatingsEntity;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class RatingListViewCell extends ListCell<RatingsEntity> {

  private final RatingLineViewController ticketCellController = new RatingLineViewController();
  private final Node view = ticketCellController.getView();

  @Override
  protected void updateItem(RatingsEntity item, boolean empty) {
    // super.updateItem(item, empty);
    if (empty) {
      setGraphic(null);
    } else {
      ticketCellController.setTicket(item);
      setGraphic(view);
    }
  }



}
