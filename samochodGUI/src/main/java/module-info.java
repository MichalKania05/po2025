module po.samochodgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens po.samochodgui to javafx.fxml;
    exports po.samochodgui;
}