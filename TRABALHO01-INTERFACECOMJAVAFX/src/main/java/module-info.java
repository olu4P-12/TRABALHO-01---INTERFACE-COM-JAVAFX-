module com.example.trabalho01interfacecomjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabalho01interfacecomjavafx to javafx.fxml;
    exports com.example.trabalho01interfacecomjavafx;
}