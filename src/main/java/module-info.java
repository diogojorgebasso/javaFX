module com.org.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.org.javafxdemo to javafx.fxml;
    exports com.org.javafxdemo;
}