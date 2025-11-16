module com.example.cadastrosimples {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cadastrosimples to javafx.fxml;
    exports com.example.cadastrosimples;
}