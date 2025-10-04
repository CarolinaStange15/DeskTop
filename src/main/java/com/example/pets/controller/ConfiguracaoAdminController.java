package com.example.pets.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

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
            var urlEndereco = "http://localhost:8080/usuarios";
            URL url = new URL(urlEndereco);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Type", "application/json");

            String json = String.format("{\"nome\" : \"%s\",\"email\" : \"%s\",\"senha\" : \"%s\",\"cpf\" : \"%s\" } ", txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtCpf.getText());

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
            } catch (Exception e) {
                throw e;
            }

            conn.getResponseMessage();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dados digitados!");

            alert.showAndWait();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}