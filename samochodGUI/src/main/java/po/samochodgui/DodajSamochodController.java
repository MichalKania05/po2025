package po.samochodgui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.Samochod;
import symulator.Silnik;
import symulator.SkrzyniaBiegow;
import symulator.Sprzeglo;

public class DodajSamochodController {

    @FXML private TextField modelTextField;
    @FXML private TextField registrationTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    private ObservableList<Samochod> samochody;

    public void setSamochody(ObservableList<Samochod> samochody) {
        this.samochody = samochody;
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double weight;
        int speed;

        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        // Tworzymy nowy samochód z domyślnym silnikiem i skrzynią
        Sprzeglo spr = new Sprzeglo("P", "Sprzeglo", "Sprzeglo", 0.01, 100);
        SkrzyniaBiegow sb = new SkrzyniaBiegow("P", "Skrzynia", "Skrzynia", 20, 2000, 6, spr);
        Silnik sil = new Silnik("S", "Silnik", "Silnik", 1000, 5000, 8000);
        Samochod nowy = new Samochod(registration, model, speed, sil, sb);

        samochody.add(nowy);

        // Zamknij okno
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
