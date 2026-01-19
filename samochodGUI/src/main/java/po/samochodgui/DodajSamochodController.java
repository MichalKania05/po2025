package po.samochodgui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.Samochod;
import symulator.Silnik;
import symulator.SkrzyniaBiegow;
import symulator.Sprzeglo;

import javafx.event.ActionEvent;

public class DodajSamochodController {

    @FXML private TextField modelTextField;
    @FXML private TextField registrationTextField;
    @FXML private TextField speedTextField;
    @FXML private TextField rpmTextField;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    private ObservableList<Samochod> samochody;

    private HelloController mainController;
    public void setMainController(HelloController controller) {
        this.mainController = controller;
    }
    public void setSamochody(ObservableList<Samochod> samochody) {
        this.samochody = samochody;
    }

    @FXML
    private void onConfirmButton(ActionEvent event) {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double speed;
        double rpm;

        try {
            speed = Double.parseDouble(speedTextField.getText());
        } catch (NumberFormatException e) {
            pokazBlad("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        try {
            rpm = Double.parseDouble(rpmTextField.getText());
        } catch (NumberFormatException e) {
            pokazBlad("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        Sprzeglo spr = new Sprzeglo("P", "Sprzeglo", "Sprzeglo", 0.01, 100);
        SkrzyniaBiegow sb = new SkrzyniaBiegow("P", "Skrzynia", "Skrzynia", 4700, 10000, 6, spr);
        Silnik sil = new Silnik("S", "Silnik", "Silnik", 73000, 50000,  (int)rpm); // Własne maxObroty
        Samochod nowySam = new Samochod(registration, model, speed, sil, sb);

        if (mainController != null) {
            mainController.dodajSamochod(nowySam);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void pokazBlad(String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
