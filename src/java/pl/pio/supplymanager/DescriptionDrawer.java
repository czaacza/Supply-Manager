package pl.pio.supplymanager;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

public class DescriptionDrawer {

    DescriptionButton descriptionButton;

    public DescriptionDrawer(DescriptionButton descriptionButton) {
        this.descriptionButton = descriptionButton;
    }

    public void drawDescription(){

        descriptionButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(descriptionButton.getDescription());
                AnchorPane descriptionPane = new AnchorPane();
                descriptionPane.setLayoutX(500);
                descriptionPane.setLayoutY(150);
                descriptionPane.setPrefHeight(145);
                descriptionPane.setPrefWidth(260);
                descriptionPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));

            }
        });

    }

}
