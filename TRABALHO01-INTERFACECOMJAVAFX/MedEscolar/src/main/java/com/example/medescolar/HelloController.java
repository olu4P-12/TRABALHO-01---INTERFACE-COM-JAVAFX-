package com.example.medescolar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoN1;

    @FXML
    private TextField campoN2;

    @FXML
    private TextField campoN3;

    @FXML
    private Button btnCalcular;

    @FXML
    private Label resultado;

    @FXML
    public void initialize() {
        btnCalcular.setOnAction(e -> calcularMedia());
    }

    private void calcularMedia() {
        String nome = campoNome.getText();

        if (nome.isEmpty()) {
            resultado.setText("Digite o nome do aluno!");
            return;
        }

        double n1, n2, n3;

        try {
            n1 = Double.parseDouble(campoN1.getText());
            n2 = Double.parseDouble(campoN2.getText());
            n3 = Double.parseDouble(campoN3.getText());
        } catch (NumberFormatException e) {
            resultado.setText("Digite apenas números nas notas!");
            return;
        }

        double media = (n1 + n2 + n3) / 3;

        String situacao;
        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media >= 4) {
            situacao = "Recuperação";
        } else {
            situacao = "Reprovado";
        }

        resultado.setText(
                String.format("Aluno %s — média: %.2f — %s.", nome, media, situacao)
        );
    }
}
