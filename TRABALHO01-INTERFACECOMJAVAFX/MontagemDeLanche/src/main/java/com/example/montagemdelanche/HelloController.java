package com.example.montagemdelanche;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML private TextField txtNome;
    @FXML private ComboBox<String> comboPao;

    @FXML private RadioButton rbBovina;
    @FXML private RadioButton rbFrango;
    @FXML private RadioButton rbSoja;

    @FXML private CheckBox chkQueijo;
    @FXML private CheckBox chkBacon;
    @FXML private CheckBox chkSalada;
    @FXML private CheckBox chkMolho;

    @FXML private Label lblResultado;

    @FXML
    public void initialize() {
        comboPao.getItems().addAll("Francês", "Integral", "Australiano");
    }

    @FXML
    public void gerarPedido() {

        String nome = txtNome.getText();
        String pao = comboPao.getValue();

        String carne = rbBovina.isSelected() ? "bovina" :
                rbFrango.isSelected() ? "frango" :
                        rbSoja.isSelected() ? "soja"   : "nenhuma";

        // Adicionais
        String adicionais = "";

        if (chkQueijo.isSelected()) adicionais += "queijo, ";
        if (chkBacon.isSelected()) adicionais += "bacon, ";
        if (chkSalada.isSelected()) adicionais += "salada, ";
        if (chkMolho.isSelected()) adicionais += "molho, ";

        if (adicionais.endsWith(", "))
            adicionais = adicionais.substring(0, adicionais.length() - 2);

        lblResultado.setText("Pedido de " + nome + ": pão " + pao +
                " com carne " + carne +
                (adicionais.isEmpty() ? "" : ", com " + adicionais) + ".");
    }
}
