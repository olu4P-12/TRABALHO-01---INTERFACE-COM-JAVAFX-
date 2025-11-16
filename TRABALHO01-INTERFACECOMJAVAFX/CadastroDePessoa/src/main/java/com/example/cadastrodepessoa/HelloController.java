package com.example.cadastrodepessoa;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoIdade;

    @FXML
    private RadioButton rbMasc;

    @FXML
    private RadioButton rbFem;

    @FXML
    private CheckBox chkEsportes;

    @FXML
    private Button btnAnalisar;

    @FXML
    private Label resultado;

    private ToggleGroup grupoSexo;

    @FXML
    public void initialize() {
        // Criar grupo de sexo
        grupoSexo = new ToggleGroup();
        rbMasc.setToggleGroup(grupoSexo);
        rbFem.setToggleGroup(grupoSexo);

        // Evento do botão
        btnAnalisar.setOnAction(e -> analisar());
    }

    private void analisar() {
        String nome = campoNome.getText();
        String sexo = "";
        boolean gostaEsporte = chkEsportes.isSelected();

        if (grupoSexo.getSelectedToggle() == rbMasc)
            sexo = "masculino";
        else if (grupoSexo.getSelectedToggle() == rbFem)
            sexo = "feminino";

        // Validar nome
        if (nome.isEmpty()) {
            resultado.setText("Digite o nome!");
            return;
        }

        // Validar idade
        int idade;
        try {
            idade = Integer.parseInt(campoIdade.getText());
        } catch (NumberFormatException e) {
            resultado.setText("Idade inválida!");
            return;
        }

        // Montar resumo
        String resumo = String.format(
                "%s, %d anos, do sexo %s, %s esportes.",
                nome,
                idade,
                sexo,
                gostaEsporte ? "gosta de" : "não gosta de"
        );

        // Observação
        String observacao = idade < 18 ? "Menor de idade." : "Maior de idade.";

        // Mostrar resultado
        resultado.setText(resumo + "\n" + observacao);
    }
}
