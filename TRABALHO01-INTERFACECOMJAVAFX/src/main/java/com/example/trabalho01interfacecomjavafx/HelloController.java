package com.example.trabalho01interfacecomjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField campo1;

    @FXML
    private TextField campo2;

    @FXML
    private Label resultado;

    @FXML
    private Button btnSoma;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnMult;

    @FXML
    private Button btnDiv;

    @FXML
    public void initialize() {

        btnSoma.setOnAction(e -> calcular("+"));
        btnSub.setOnAction(e -> calcular("-"));
        btnMult.setOnAction(e -> calcular("*"));
        btnDiv.setOnAction(e -> calcular("/"));
    }

    private void calcular(String operacao) {
        try {
            double n1 = Double.parseDouble(campo1.getText());
            double n2 = Double.parseDouble(campo2.getText());
            double res = 0;

            switch (operacao) {
                case "+" -> res = n1 + n2;
                case "-" -> res = n1 - n2;
                case "*" -> res = n1 * n2;
                case "/" -> {
                    if (n2 == 0) {
                        resultado.setText("Erro: divisão por zero!");
                        return;
                    }
                    res = n1 / n2;
                }
            }

            resultado.setText("Resultado: " + res);

        } catch (NumberFormatException ex) {
            resultado.setText("Digite apenas números!");
        }
    }
}
