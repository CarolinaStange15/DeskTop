package com.example.pets.controller;

import com.example.pets.model.DAO.EnderecoDAO;
import com.example.pets.model.DAO.UsuarioDAO;
import com.example.pets.model.Endereco;
import com.example.pets.model.Usuario;
import com.example.pets.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ConfiguracaoAdminController {


    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtCpf;


    public void cadastrarAdmin(ActionEvent event) {
        try {
            EntityManager entityManager = JPAUtils.getEntityManager();
            UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);

            Usuario usuarioBanco = new Usuario();
            usuarioBanco.setNome(txtNome.getText());
            usuarioBanco.setEmail(txtEmail.getText());
            usuarioBanco.setSenha(txtSenha.getText());
            usuarioBanco.setCpf(txtCpf.getText());
            usuarioBanco.setRole("ADMIN"); // adiciona role automático

            usuarioDAO.salvar(usuarioBanco);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Administrador cadastrado com sucesso!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Falha ao cadastrar o administrador");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void voltar(ActionEvent event) throws Exception{
        System.out.println(" Voltando para a página inicial");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pets/menu-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
}