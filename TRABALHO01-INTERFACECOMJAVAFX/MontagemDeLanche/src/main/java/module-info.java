module com.example.montagemdelanche {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.montagemdelanche to javafx.fxml;
    exports com.example.montagemdelanche;
}