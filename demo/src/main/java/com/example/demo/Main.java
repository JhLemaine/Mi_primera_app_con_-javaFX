package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("AgendaView.fxml"));

        Scene scene = new Scene(
                fxmlLoader.load(),
                1200,
                600);

        stage.setTitle("Agenda de contacto!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){

        launch(args);
    }
}