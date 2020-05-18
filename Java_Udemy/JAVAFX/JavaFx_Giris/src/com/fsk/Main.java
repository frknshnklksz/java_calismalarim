package com.fsk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Pane roodNode = loader.load();

        Scene scene = new Scene(roodNode, 600, 600);
        stage.setScene(scene);
        stage.setTitle("FRKNSHNKLKSZ");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
