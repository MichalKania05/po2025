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
    @FXML private javafx.scene.control.ComboBox<Silnik> engineComboBox;
    @FXML private javafx.scene.control.ComboBox<SkrzyniaBiegow> gearboxComboBox;
    @FXML private Button cancelButton;

    private ObservableList<Samochod> samochody; // Lista samochodów

    // Elementy do wyboru
    private Silnik sil;
    private Silnik sil_1;
    private Silnik sil_2;
    private SkrzyniaBiegow sb;
    private SkrzyniaBiegow sb_1;
    private SkrzyniaBiegow sb_2;

    // Settery
    private HelloController mainController;
    public void setMainController(HelloController controller) {
        this.mainController = controller;
    }
    public void setSamochody(ObservableList<Samochod> samochody) {
        this.samochody = samochody;
    }

    // Przycisk potwierdzający utworzenie samochodu
    @FXML
    private void onConfirmButton(ActionEvent event) {
        // Pobrane dane
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double speed;
        double rpm;

        // Walidacja szybkości
        try {
            speed = Double.parseDouble(speedTextField.getText());
        } catch (NumberFormatException e) {
            pokazBlad("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        // Walidacja obrotów
        try {
            rpm = Double.parseDouble(rpmTextField.getText());
        } catch (NumberFormatException e) {
            pokazBlad("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        // Wybrane elementy z ComboBoxów
        Silnik wybranySilnik = engineComboBox.getValue();
        SkrzyniaBiegow wybranaSkrzynia = gearboxComboBox.getValue();

        if (wybranySilnik == null || wybranaSkrzynia == null) {
            pokazBlad("Wybierz silnik i skrzynię biegów");
            return;
        }

        int rpmUser = (int) rpm; // Własne nadpisane RPM
        wybranySilnik.setLimitObrotow(rpmUser); // Własny limit
        int rpmLimit = wybranySilnik.getMaxObroty(); // Maksymalne RPM, których nie można przekroczyć

        // Czy własne RPM nie przekraczają maksymalnych
        if (rpmUser > rpmLimit) {
            pokazBlad(
                    "Maksymalne obroty nie mogą przekraczać "
                            + rpmLimit + " dla wybranego silnika! "
            );
            return;
        }

        Silnik sil = new Silnik(
                "COPY",
                "COPY",
                wybranySilnik.getNazwa(),
                wybranySilnik.getWaga(),
                wybranySilnik.getCena(),
                rpmLimit
        );

        // Sprzęgło jedno dla każdej skrzyni biegów
        Sprzeglo spr = new Sprzeglo("P", "Sprzeglo",
                "Sprzeglo", 0.01, 100);

        SkrzyniaBiegow sb = new SkrzyniaBiegow(
                "COPY",
                "COPY",
                wybranaSkrzynia.getNazwa(),
                wybranaSkrzynia.getWaga(),
                wybranaSkrzynia.getCena(),
                wybranaSkrzynia.getIloscBiegow(),
                spr
        );

        Samochod nowySam = new Samochod(registration, model, speed, wybranySilnik, wybranaSkrzynia);

        boolean dodano = false;
        if (mainController != null) {
            mainController.dodajSamochod(nowySam);
        }

        if (dodano) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    // Anulowanie
    @FXML
    private void onCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // Obsługa pop-upów
    private void pokazBlad(String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Inicjalizacja
    @FXML
    public void initialize()
    {
        // Własne silniki do wyboru w ComboBoxie
        sil = new Silnik(
                "SIL", "SIL", "Silnik",
                73000, 50000, 4700); // Własne maxObroty można nadpisać

        sil_1 = new Silnik(
                "PS1", "EcoBoost", "EcoBoost 1.6",
                12000, 16500, 5600); // Własne maxObroty można nadpisać

        sil_2 = new Silnik(
                "PS2", "M Power", "M Power 3.0",
                18000, 34000, 7100); // Własne maxObroty można nadpisać

        engineComboBox.getItems().addAll(sil, sil_1, sil_2);
        engineComboBox.getSelectionModel().selectFirst();

        // Sprzęgło jedno dla każdej skrzyni biegów
        Sprzeglo spr = new Sprzeglo("P", "Sprzeglo", "Sprzeglo", 0.01, 100); // Pozostanie takie samo

        // Własne skrzynie do wyboru w ComboBoxie
        sb = new SkrzyniaBiegow(
                "SB", "SB", "Skrzynia",
                4300, 10000, 6, spr
        );

        sb_1 = new SkrzyniaBiegow(
                "PSB1", "Manual", "Manualna 4-biegowa",
                7700, 5000, 4, spr
        );

        sb_2 = new SkrzyniaBiegow(
                "PSB2", "Sport", "Manualna 5-biegowa",
                9200, 9000, 5, spr
        );

        gearboxComboBox.getItems().addAll(sb, sb_1, sb_2);
        gearboxComboBox.getSelectionModel().selectFirst();
    }
}
