module com.example.conversordetemperatura {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conversordetemperatura to javafx.fxml;
    exports com.example.conversordetemperatura;
}