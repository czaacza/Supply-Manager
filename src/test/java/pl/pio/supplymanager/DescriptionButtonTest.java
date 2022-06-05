package pl.pio.supplymanager;

import javafx.application.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescriptionButtonTest {

    @Test
    public void mouseTest() {
        try {
            Platform.startup(() -> {}); // init javafx toolkit
        } catch (Exception e) { // the only error is when the toolkit has been already initialised
        }

        String expectedTitle = "Opis produktu";
        String expectedProductName = "Produkt";
        String expectedProductDescription = "Przykładowy Opis";

        DescriptionButton descriptionButton = new DescriptionButton("Produkt", "Przykładowy Opis");
        descriptionButton.showDescriptionAlert();

        Assertions.assertEquals(descriptionButton.getDescriptionAlert().getTitle(), expectedTitle);
        Assertions.assertEquals(descriptionButton.getDescriptionAlert().getHeaderText(), expectedProductName);
        Assertions.assertEquals(descriptionButton.getDescriptionAlert().getContentText(), expectedProductDescription);
    }

}