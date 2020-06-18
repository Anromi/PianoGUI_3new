module org.anr {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;

    opens org.anr.controller to javafx.fxml;
    opens org.anr.model to javafx.fxml;
    exports org.anr.controller;
    exports org.anr.model;
}