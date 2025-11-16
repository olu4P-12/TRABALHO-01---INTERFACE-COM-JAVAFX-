package com.example.cadastrosimples;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private ComboBox<String> cbCurso;

    @FXML private TableView<String[]> tabelaAlunos;
    @FXML private TableColumn<String[], String> colNome;
    @FXML private TableColumn<String[], String> colIdade;
    @FXML private TableColumn<String[], String> colCurso;

    private ObservableList<String[]> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        cbCurso.getItems().addAll("Informática", "Administração", "Enfermagem", "Sistemas");

        // Define como cada coluna pega o valor do String[]
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[0]));
        colIdade.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[1]));
        colCurso.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[2]));

        tabelaAlunos.setItems(lista);
    }

    @FXML
    public void adicionarAluno() {
        try {
            String nome = txtNome.getText();
            String idade = txtIdade.getText();
            String curso = cbCurso.getValue();

            if (nome.isEmpty() || idade.isEmpty() || curso == null) {
                mostrarAlerta("Preencha todos os campos!");
                return;
            }

            // Adiciona linha nova na tabela
            lista.add(new String[]{nome, idade, curso});

            // Limpar campos
            txtNome.clear();
            txtIdade.clear();
            cbCurso.setValue(null);

        } catch (Exception e) {
            mostrarAlerta("Erro: verifique os dados.");
        }
    }

    @FXML
    public void excluirAluno() {
        String[] selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();

        if (selecionado != null) {
            lista.remove(selecionado);
        } else {
            mostrarAlerta("Selecione um aluno na tabela!");
        }
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK);
        alert.show();
    }
}
