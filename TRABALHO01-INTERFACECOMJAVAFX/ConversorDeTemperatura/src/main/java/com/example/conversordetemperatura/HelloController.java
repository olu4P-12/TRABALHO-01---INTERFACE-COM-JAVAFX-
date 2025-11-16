package com.example.conversordetemperatura;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField campoTemp;

    @FXML
    private Label resultado;

    @FXML
    private Button btnParaF;

    @FXML
    private Button btnParaC;

    @FXML
    public void initialize() {
        btnParaF.setOnAction(e -> converterParaF());
        btnParaC.setOnAction(e -> converterParaC());
    }

    private void converterParaF() {
        try {
            double celsius = Double.parseDouble(campoTemp.getText());
            double fahrenheit = celsius * 1.8 + 32;
            resultado.setText(String.format("%.2f°F", fahrenheit));
        } catch (NumberFormatException e) {
            resultado.setText("Digite um número válido!");
        }
    }

    private void converterParaC() {
        try {
            double fahrenheit = Double.parseDouble(campoTemp.getText());
            double celsius = (fahrenheit - 32) / 1.8;
            resultado.setText(String.format("%.2f°C", celsius));
        } catch (NumberFormatException e) {
            resultado.setText("Digite um número válido!");
        }
    }
}
