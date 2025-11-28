/*
package po.samochodgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private ImageView imageView;

    @FXML
    private Label welcomeText;

    @FXML
    private Label textLabel;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Slider slider;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onPressButtonClick() {
        welcomeText.setText("Cześć!");
    }

    // Inicjalizacja kontrolera
    @FXML
    private void initialize() {
        // Dodaj opcje do ComboBox
        comboBox.getItems().addAll("Opcja 1", "Opcja 2", "Opcja 3");

        // Reakcja na zmianę wybranej opcji
        comboBox.setOnAction(event -> {
            String selected = comboBox.getSelectionModel().getSelectedItem();
            welcomeText.setText("Wybrano: " + selected);
        });

        // Slider steruje tekstem i kolorem
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int value = newVal.intValue();
            textLabel.setText("Slider: " + value);

            // Kolor tekstu zależny od wartości slidera
            if (value == 0) {textLabel.setTextFill(Color.RED);}
            else if (value == 1) {textLabel.setTextFill(Color.DARKGREEN);}
            else {textLabel.setTextFill(Color.BLUE);}
        });

        Image image = new Image(getClass().getResourceAsStream("/logo.png"));
        imageView.setImage(image);
    }


    @FXML
    private void onAddCar() {
        System.out.println("Dodaj nowy samochód");
    }

    @FXML
    private void onRemoveCar() {
        System.out.println("Usuń samochód");
    }

    @FXML
    private void onStartCar() {
        System.out.println("Samochód włączony");
    }

    @FXML
    private void onStopCar() {
        System.out.println("Samochód wyłączony");
    }

    @FXML
    private void onStartEngine() {
        System.out.println("Silnik włączony");
    }

    @FXML
    private void onStopEngine() {
        System.out.println("Silnik wyłączony");
    }

    @FXML
    private void onEngageGearbox() {
        System.out.println("Skrzynia biegów włączona");
    }

    @FXML
    private void onDisengageGearbox() {
        System.out.println("Skrzynia biegów wyłączona");
    }

    @FXML
    private void onEngageClutch() {
        System.out.println("Sprzęgło włączone");
    }

    @FXML
    private void onDisengageClutch() {
        System.out.println("Sprzęgło wyłączone");
    }

}
*/

package po.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    private ComboBox<String> carComboBox;

    @FXML private TextField modelField, regField, weightField, speedField;
    @FXML private Button onBtn, offBtn, otherBtn;

    @FXML private TextField gbNameField, gbPriceField, gbWeightField, gbGearField;
    @FXML private Button gearUpBtn, gearDownBtn;

    @FXML private TextField engNameField, engPriceField, engWeightField, engRPMField;
    @FXML private Button gasBtn, noGasBtn;

    @FXML private TextField clNameField, clPriceField, clWeightField, clStateField;
    @FXML private Button pressBtn, releaseBtn;

    @FXML
    private ImageView carImageView;

    @FXML
    public void initialize()
    {
        Image samIkona = new Image(getClass().getResourceAsStream("/samochod.png"));
        carImageView.setImage(samIkona);
    }
}

