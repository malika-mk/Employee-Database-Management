module org.example.dataprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.dataprogram to javafx.fxml;
    exports org.example.dataprogram;
}