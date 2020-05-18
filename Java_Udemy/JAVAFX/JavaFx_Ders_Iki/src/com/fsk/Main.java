package com.fsk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Button tamam = new Button("Tamam");
        Button cikis = new Button("Cikis");

        //Stack Pane'ni özelliği elemanları üst üste eklemesidir.
        //Yani aşağıdaki kod bize üst üste dizilmiş 2 tane buton nesnesi gösterir.
        /*
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(tamam);
        stackPane.getChildren().add(cikis);
        Scene scene = new Scene(stackPane, 500, 600);
        stage.setScene(scene);
        */

        tamam.setOnAction((val)->{
            System.out.println("Tamam'a tiklandi." + val.toString());
        });

        tamam.setId("btnTamam");

        cikis.setOnAction((a)->{
            System.out.println("Cikis'a tiklandi.");
            System.exit(0);
        });


        HBox hBox = new HBox();
        hBox.getChildren().add(tamam);
        hBox.getChildren().add(cikis);
        Scene scene = new Scene(hBox, 400, 350);
        scene.getStylesheets().add(getClass().getResource("styleDosyasi.css").toExternalForm());
        stage.setScene(scene);

        stage.setTitle("Furkan Sahin Kulaksiz");
        stage.show();
    }
}
