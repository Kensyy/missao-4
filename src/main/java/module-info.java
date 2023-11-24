module com.kensy.trabalhojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;

    opens com.kensy.trabalhojavafx to javafx.fxml;
    exports com.kensy.trabalhojavafx;
}