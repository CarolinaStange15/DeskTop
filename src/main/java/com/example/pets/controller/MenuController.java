package com.example.pets.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    public void sair(){
        System.exit(0);
    }

    public void abrirMenuTesteApiBanco(ActionEvent event) throws Exception{
        System.out.println(" Abrindo tela do professor");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pets/testeapibanco-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
    public void abrirConfiguracaoAdmin(ActionEvent event) throws Exception{
        System.out.println(" Abrindo de configuração de admin");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pets/configuracaoadmin-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }


}
