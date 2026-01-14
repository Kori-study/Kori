package com.kori.kori;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class KoriApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KoriApplication.class.getResource("kori-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600, Color.WHITE);
        
        // Load CSS stylesheet
        scene.getStylesheets().add(KoriApplication.class.getResource("kori-styles.css").toExternalForm());

        Image icon = new Image(String.valueOf(KoriApplication.class.getResource("assets/icon/favicon.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Kori");
        stage.setScene(scene);

        stage.setResizable(false);
        stage.setFullScreen(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}