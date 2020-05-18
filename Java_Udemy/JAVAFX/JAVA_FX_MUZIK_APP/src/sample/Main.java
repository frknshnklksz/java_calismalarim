package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.DataSource;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Controller controller = fxmlLoader.getController();
        controller.tumSarkicilariGetir();
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("MUZIK APP");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if (!DataSource.getInstance().veriTabaniniAc()){
            System.err.print("Veritabanına baglantı hatası.!!!");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        DataSource.getInstance().veriTabaniniKapat();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
