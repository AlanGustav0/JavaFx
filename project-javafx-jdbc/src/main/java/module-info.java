module com.example.projectjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.projectjavafxjdbc to javafx.fxml;
    exports com.example.projectjavafxjdbc;
    exports com.example.projectjavafxjdbc.controller;
    opens com.example.projectjavafxjdbc.controller to javafx.fxml;
}