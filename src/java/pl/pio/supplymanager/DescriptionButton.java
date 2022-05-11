package pl.pio.supplymanager;

import javafx.scene.control.Button;

public class DescriptionButton extends Button {

    private final String description;

    public DescriptionButton(String text, String description) {
        super(text);
        this.description = description;
        setStyle(".button{\n" +
                "    -fx-border-color: transparent;\n" +
                "    -fx-border-width: 0;\n" +
                "    -fx-background-radius: 0;\n" +
//                "    -fx-background-color: transparent;\n" +
                "    -fx-font-family:\"Segoe UI\", Helvetica, Arial, sans-serif;\n" +
                "    -fx-font-size: 1em; /* 12 */\n" +
                "    -fx-text-fill: #828282;\n" +
                "}"
        );






    }
}
