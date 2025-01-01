module com.example.spaceshootergui2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.spaceshootergui2 to javafx.fxml;
    exports com.example.spaceshootergui2;
    exports com.example.spaceshootergui2.models;
}