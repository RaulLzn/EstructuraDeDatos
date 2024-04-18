module wellnessoasis {
    requires javafx.controls;
    requires javafx.fxml;

    opens wellnessoasis to javafx.fxml;
    exports wellnessoasis;
}
