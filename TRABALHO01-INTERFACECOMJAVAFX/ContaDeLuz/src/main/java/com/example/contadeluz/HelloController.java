package com.example.contadeluz;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML private TextField txtNome;
    @FXML private TextField txtKwh;
    @FXML private ComboBox<String> comboTipo;
    @FXML private Label lblResultado;

    @FXML
    public void initialize() {
        comboTipo.getItems().addAll("Residencial", "Comercial", "Industrial");
    }

    @FXML
    public void calcular() {
        String nome = txtNome.getText().trim();
        String kwhStr = txtKwh.getText().trim();
        String tipo = comboTipo.getValue();

        if (nome.isEmpty() || kwhStr.isEmpty() || tipo == null) {
            lblResultado.setText("Preencha todos os campos!");
            return;
        }

        double kwh;
        try {
            kwh = Double.parseDouble(kwhStr);
        } catch (NumberFormatException e) {
            lblResultado.setText("kWh inválido!");
            return;
        }

        double valor = 0;

        switch (tipo) {
            case "Residencial":
                valor = kwh * 0.60;
                break;
            case "Comercial":
                valor = kwh * 0.48;
                break;
            case "Industrial":
                valor = kwh * 0.75;
                break;
        }

        lblResultado.setText(
                String.format("Cliente: %s — Tipo: %s — Consumo: %.0f kWh — Valor: R$ %.2f",
                        nome, tipo, kwh, valor)
        );
    }
}
