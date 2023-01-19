module com.example.laborator12 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.laborator12 to javafx.fxml;
    exports com.example.laborator12;
}