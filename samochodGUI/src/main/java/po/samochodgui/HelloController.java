
package po.samochodgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import symulator.*;

public class HelloController {

    private Samochod aktSam;

    @FXML
    private ComboBox<Samochod> carComboBox;

    @FXML
    private TextField modelField, regField, weightField, speedField;
    @FXML
    private Button onBtn, offBtn;

    @FXML
    private TextField gbNameField, gbPriceField, gbWeightField, gbGearField;
    @FXML
    private Button GearUpBtn, GearDownBtn;

    @FXML
    private TextField engNameField, engPriceField, engWeightField, engRPMField;
    @FXML
    private Button gasBtn, noGasBtn;

    @FXML
    private TextField clNameField, clPriceField, clWeightField, clStateField;
    @FXML
    private Button pressBtn, releaseBtn;

    @FXML
    private ImageView carImageView;

    private ObservableList<Samochod> samochody = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Sprzeglo spr1 = new Sprzeglo("P", "SP1", "Sprzeglo1", 0.005, 250);
        SkrzyniaBiegow sb1 = new SkrzyniaBiegow("P", "SB1", "Skrzynia1", 25, 5000, 6, spr1);
        Silnik sil1 = new Silnik("S", "SIL1", "Silnik1", 10000, 50000, 8000);
        Samochod sam1 = new Samochod("XYZ-1234", "Golf 5", 250, sil1, sb1);

        samochody.add(sam1);

        carComboBox.setItems(samochody);

        carComboBox.setOnAction(event -> {
            aktSam = carComboBox.getValue();
            pokazDaneSamochodu();
        });

        Image samIkona = new Image(getClass().getResourceAsStream("/samochod.png"));
        carImageView.setImage(samIkona);
    }

    @FXML
    private void onOnButton() {
        if (aktSam != null) {
            aktSam.wlacz();
            pokazDaneSamochodu();
        }
    }

    @FXML
    private void onOffButton() {
        if (aktSam != null) {
            aktSam.wylacz();
            pokazDaneSamochodu();
        }
    }

    @FXML
    private void onGearUpBtn() {
        if (aktSam != null) {
            aktSam.getSkrzynia().zwiekszBieg();
            pokazDaneSamochodu();
        }
    }

    @FXML
    private void onGearDownBtn() {
        if (aktSam != null) {
            aktSam.getSkrzynia().zmniejszBieg();
            pokazDaneSamochodu();
        }
    }

    @FXML
    private void onPressClutch() {
        if (aktSam != null) {
            aktSam.getSkrzynia().getSprzeglo().wcisnij();
            pokazDaneSamochodu();
        }
    }

    @FXML
    private void onReleaseClutch() {
        if (aktSam != null) {
            aktSam.getSkrzynia().getSprzeglo().zwolnij();
            pokazDaneSamochodu();
        }
    }

    private void pokazDaneSamochodu() {
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
    }
}
