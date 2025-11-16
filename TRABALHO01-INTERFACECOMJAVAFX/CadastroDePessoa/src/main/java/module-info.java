module com.example.cadastrodepessoa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cadastrodepessoa to javafx.fxml;
    exports com.example.cadastrodepessoa;
}