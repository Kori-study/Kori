package com.kori.kori;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class KoriApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KoriApplication.class.getResource("kori-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400, Color.WHITE);
        
        scene.getStylesheets().add(Objects.requireNonNull(KoriApplication.class.getResource("kori-styles.css")).toExternalForm());

        Image icon = new Image(String.valueOf(KoriApplication.class.getResource("assets/icon/favicon.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Kori");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}