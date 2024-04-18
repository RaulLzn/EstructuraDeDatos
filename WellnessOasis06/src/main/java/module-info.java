module Hi {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.logging;

    opens Hi to javafx.fxml;
    exports Hi;
}
