package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Model.DataSource;
import sample.Model.Sarkici;

import javax.xml.crypto.Data;

public class Controller {

    @FXML
    private TableView table;

    public void tumSarkicilariGetir() {
        Task<ObservableList<Sarkici>> task = new TumSarkicilariGetir();

        table.itemsProperty().bind(task.valueProperty());


        new Thread(task).start();
    }
}

class TumSarkicilariGetir extends Task { //JAVAFX ile thread'leri kullanabilmek için oluşturulan sınıf.

    @Override
    protected ObservableList<Sarkici> call() throws Exception {
        return FXCollections.observableArrayList(DataSource.getInstance().tumSarkicilariGoster(DataSource.SIRALA_ARTAN));
    }
}
