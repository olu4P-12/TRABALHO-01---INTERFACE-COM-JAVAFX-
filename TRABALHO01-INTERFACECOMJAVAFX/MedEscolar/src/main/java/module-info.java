module com.example.medescolar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.medescolar to javafx.fxml;
    exports com.example.medescolar;
}