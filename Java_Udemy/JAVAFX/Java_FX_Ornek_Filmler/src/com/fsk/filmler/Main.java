package com.fsk.filmler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void init() throws Exception { //Pencere gözükmeden işlem yapan method
        super.init();
        FilmData.getInstance().dosyadanFilmleriGetir();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        /*
        LocalDate localDate = LocalDate.now();
        Film f1 = new Film("GORA", "Uzay Filmi", "Komedi", localDate, "Cem Yılmaz");
        FilmData.getInstance().filmEkle(f1);
         */

        FilmData.getInstance().dosyayaFilmleriYaz();
        super.stop();
    }
}
