module po.samochodgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens po.samochodgui to javafx.fxml;
    exports po.samochodgui;
}