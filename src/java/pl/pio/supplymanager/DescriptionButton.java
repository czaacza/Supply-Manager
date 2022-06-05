package pl.pio.supplymanager;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DescriptionButton extends Button {

    private final String productName;
    private final String description;
    private Alert descriptionAlert;

    public DescriptionButton(String productName, String description) {
        super("Pokaż");
        this.productName = productName;
        this.description = description;
        setPrefWidth(200);
        setPrefHeight(200);
        setDefaultStyle();
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPressedBackgroundColor();
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setDefaultBackgroundColor();
            }
        });

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                showDescriptionAlert();
            }
        });
    }

    private void setDefaultStyle(){
        setStyle(".button{\n" +
                        "    -fx-border-color: transparent;\n" +
                        "    -fx-border-width: 0;\n" +
                        "    -fx-background-radius: 0;\n" +
                        "    -fx-background-color: transparent;\n" +
                        "    -fx-font-family:\"Segoe UI\", Helvetica, Arial, sans-serif;\n" +
                        "    -fx-font-size: 1em; /* 12 */\n" +
                        "    -fx-text-fill: #333;\n" +
                        "}"
        );
    }

    private void setPressedBackgroundColor(){
        setStyle("-fx-background-color: #0096C9;\n"+
                "-fx-text-fill: #fff");
    }

    private void setDefaultBackgroundColor(){
        setStyle("-fx-background-color: transparent;");
    }

    public void showDescriptionAlert(){
        descriptionAlert = new Alert(Alert.AlertType.INFORMATION);
        descriptionAlert.setTitle("Opis produktu");
        descriptionAlert.setHeaderText(productName);
        descriptionAlert.setContentText(getDescription());
        descriptionAlert.showAndWait();
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    public Alert getDescriptionAlert() {
        return descriptionAlert;
    }
}
