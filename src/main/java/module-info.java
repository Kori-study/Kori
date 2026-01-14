module com.kori.kori {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.kori.kori to javafx.fxml;
    exports com.kori.kori;
}