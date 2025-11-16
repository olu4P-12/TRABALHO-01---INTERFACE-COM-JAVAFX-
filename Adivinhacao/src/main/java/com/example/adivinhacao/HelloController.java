package com.example.adivinhacao;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {

    @FXML private TextField inputNumber;
    @FXML private Label resultLabel;

    private int randomNumber;
    private final Random random = new Random();

    // Inicializa o número sorteado ao abrir o programa
    @FXML
    public void initialize() {
        randomNumber = random.nextInt(10) + 1;
        resultLabel.setText("");

        // Permite pressionar Enter no TextField para chamar check()
        inputNumber.setOnAction(e -> check());
    }

    @FXML
    public void check() {
        String raw = inputNumber.getText();
        if (raw == null) {
            resultLabel.setText("Digite um número válido!");
            return;
        }

        String text = raw.trim();

        if (text.isEmpty()) {
            resultLabel.setText("Digite um número válido!");
            return;
        }

        // tenta converter para inteiro com segurança
        int guess;
        try {
            guess = Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Digite um número válido!");
            return;
        }

        if (guess < 1 || guess > 10) {
            resultLabel.setText("Número deve ser entre 1 e 10!");
            return;
        }

        if (guess == randomNumber) {
            resultLabel.setText("Acertou!");
        } else {
            resultLabel.setText("Errou! O número era " + randomNumber);
        }
    }

    @FXML
    public void reset() {
        randomNumber = random.nextInt(10) + 1;
        resultLabel.setText("");
        inputNumber.clear();
        inputNumber.requestFocus();
    }
}
