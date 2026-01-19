package po.samochodgui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import symulator.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloController implements Listener {

    @Override
    public void update() {Platform.runLater(this::refresh);}

    private Samochod aktSam;
    private Samochod defaultSam;

    @FXML private ComboBox<Samochod> carComboBox;

    @FXML private TextField modelField, regField, weightField, speedField;
    @FXML private Button onBtn, offBtn;

    @FXML private TextField gbNameField, gbPriceField, gbWeightField, gbGearField;
    @FXML private Button GearUpBtn, GearDownBtn;

    @FXML private TextField engNameField, engPriceField, engWeightField, engRPMField;
    @FXML private Button gasBtn, noGasBtn;

    @FXML private TextField clNameField, clPriceField, clWeightField, clStateField;
    @FXML private Button pressBtn, releaseBtn;

    @FXML private Button addNewBtn, removeBtn;
    @FXML private AnchorPane mapPane;

    private ObservableList<Samochod> samochody = FXCollections.observableArrayList();
    private Map<Samochod, ImageView> samochodIcons = new HashMap<>();

    // jedno źródło obrazu dla wszystkich ikon
    private Image carImage;

    @FXML
    private void onRemoveCar() {
        if (aktSam == null || aktSam == defaultSam) return;

        // usunięcie ikony z mapy
        ImageView icon = samochodIcons.remove(aktSam);
        if (icon != null) {
            mapPane.getChildren().remove(icon);
        }

        // usunięcie listenera
        aktSam.removeListener(this);

        // (opcjonalnie) zatrzymanie wątku
        aktSam.stopSamochod();

        // usunięcie z listy
        samochody.remove(aktSam);

        // powrót do defaultowego
        aktSam = defaultSam;
        carComboBox.getSelectionModel().select(defaultSam);

        updateRemoveButtonState();
        refresh();
    }

    @FXML
    public void initialize() {

        // ===== Załaduj obraz RAZ =====
        carImage = new Image(getClass().getResourceAsStream("/samochod.png"));

        Sprzeglo spr = new Sprzeglo("SPR", "SPR", "Sprzęgło", 0.005, 250);
        SkrzyniaBiegow sb = new SkrzyniaBiegow("SB", "SB", "Skrzynia", 25, 5000, 6, spr);
        Silnik sil = new Silnik("SIL", "SIL", "Silnik", 10000, 50000, 4000);

        // Defaultowy samochód
        Samochod sam = new Samochod("SAM-001", "Default", 250, sil, sb);

        defaultSam = sam;
        samochody.add(sam);
        aktSam = sam;

        dodajIkoneSamochodu(sam);

        // ===== ComboBox =====
        carComboBox.setItems(samochody);
        carComboBox.getSelectionModel().selectFirst();
        carComboBox.setOnAction(e -> {
            aktSam = carComboBox.getSelectionModel().getSelectedItem();
            refresh();
            updateRemoveButtonState();
        });

        // ===== Kliknięcie na mapę =====
        mapPane.setOnMouseClicked(event -> {
            if (aktSam != null) {
                aktSam.jedzDo(new Pozycja(event.getX(), event.getY()));
            }
        });

        // ===== Przycisk dodawania =====
        addNewBtn.setOnAction(e -> {
            try {
                openAddCarWindow();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        updateRemoveButtonState();
        refresh();
    }

    // ================= IKONY =================

    private void dodajIkoneSamochodu(Samochod sam) {
        ImageView iv = new ImageView(carImage);
        iv.setFitWidth(60);
        iv.setFitHeight(40);
        iv.setPreserveRatio(true);

        iv.setTranslateX(sam.getPozycja().get_x());
        iv.setTranslateY(sam.getPozycja().get_y());

        mapPane.getChildren().add(iv);
        samochodIcons.put(sam, iv);

        sam.addListener(this);
    }


    // ================= REFRESH =================
    private void refresh() {
        if (aktSam == null) return;

        modelField.setText(aktSam.getModel());
        regField.setText(aktSam.getNrRejest());
        weightField.setText(String.format("%.2f", aktSam.getWaga()));
        speedField.setText(String.format("%.2f", aktSam.getAktPredkosc()));

        SkrzyniaBiegow sb = aktSam.getSkrzynia();
        gbNameField.setText(sb.getNazwa());
        gbPriceField.setText(String.format("%.2f", sb.getCena()));
        gbWeightField.setText(String.format("%.2f", sb.getWaga()));
        gbGearField.setText(String.valueOf(sb.getAktBieg()));

        Silnik sil = aktSam.getSilnik();
        engNameField.setText(sil.getNazwa());
        engPriceField.setText(String.format("%.2f", sil.getCena()));
        engWeightField.setText(String.format("%.2f", sil.getWaga()));
        engRPMField.setText(String.valueOf(sil.getObroty()));

        Sprzeglo spr = sb.getSprzeglo();
        clNameField.setText(spr.getNazwa());
        clPriceField.setText(String.format("%.2f", spr.getCena()));
        clWeightField.setText(String.format("%.2f", spr.getWaga()));
        clStateField.setText(spr.stanSprzegla() ? "Wciśnięte" : "Zwolnione");

        ImageView icon = samochodIcons.get(aktSam);
        if (icon != null) {
            icon.setTranslateX(aktSam.getPozycja().get_x());
            icon.setTranslateY(aktSam.getPozycja().get_y());
        }
    }

    // ================= AKCJE =================

    @FXML
    private void onOnButton() {
        if (aktSam == null) return;
        try {
            aktSam.wlacz();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML
    private void onOffButton() {
        if (aktSam == null) return;
        try {
            aktSam.wylacz();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML private void onGearUpBtn() {
        try {
            aktSam.getSkrzynia().zwiekszBieg();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML private void onGearDownBtn() {
        try {
            aktSam.getSkrzynia().zmniejszBieg();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML private void onPressClutch() {
        try {
            aktSam.getSkrzynia().getSprzeglo().wcisnij();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML private void onReleaseClutch() {
        try {
            aktSam.getSkrzynia().getSprzeglo().zwolnij();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML
    private void gasUp() {
        try {
            aktSam.getSilnik().zwiekszObroty();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }

    @FXML
    private void gasDown() {
        if (aktSam == null) return;
        try {
            aktSam.getSilnik().zmniejszObroty();
            refresh();
        } catch (IllegalStateException e) {
            pokazBlad(e.getMessage());
        }
    }


    // ================= OKNO DODAWANIA =================

    public void openAddCarWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Dodaj samochód");
        stage.show();

        DodajSamochodController c = loader.getController();
        c.setMainController(this);
    }

    public void dodajSamochod(Samochod nowySam) {
        samochody.add(nowySam);
        carComboBox.getSelectionModel().select(nowySam);
        aktSam = nowySam;
        dodajIkoneSamochodu(nowySam);
    }

    private void pokazBlad(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Zablokuj usuwanie defaultowego samochodu
    private void updateRemoveButtonState() {
        removeBtn.setDisable(aktSam == null || aktSam == defaultSam);
    }
}
