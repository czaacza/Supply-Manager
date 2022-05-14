package pl.pio.supplymanager;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

public class DescriptionButton extends Button {

    private final String description;

    public DescriptionButton(String text, String description) {
        super(text);
        this.description = description;
        setPrefWidth(200);
        setPrefHeight(200);
        setStyle(".button{\n" +
                "    -fx-border-color: transparent;\n" +
//                "    -fx-font-color: #333;\n" +
                "    -fx-border-width: 0;\n" +
                "    -fx-background-radius: 0;\n" +
                "    -fx-background-color: transparent;\n" +
                "    -fx-font-family:\"Segoe UI\", Helvetica, Arial, sans-serif;\n" +
                "    -fx-font-size: 1em; /* 12 */\n" +
                "    -fx-text-fill: #333;\n" +
                "}"
        );
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: #0096C9;\n"+
                        "-fx-text-fill: #fff");
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: transparent;");
            }
        });

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(getDescription());
                AnchorPane descriptionPane = new AnchorPane();
                descriptionPane.setLayoutX(500);
                descriptionPane.setLayoutY(150);
                descriptionPane.setPrefHeight(145);
                descriptionPane.setPrefWidth(260);
                descriptionPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));

            }
        });
    }

    public String getDescription() {
        return description;
    }
}
