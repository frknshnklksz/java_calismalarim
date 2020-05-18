package com.fsk.filmler;

import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane anaPencere;
    @FXML
    private JFXListView<Film> filmListesi;
    @FXML
    private Label labelCikisTarihi;
    @FXML
    private Label txtFilmDetay;
    @FXML
    private ContextMenu listeSilMenusu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listeSilMenusu = new ContextMenu();
        MenuItem filmSil = new MenuItem("Filmi Listeden Kaldir");

        filmSil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Film silinecekFilm = filmListesi.getSelectionModel().getSelectedItem();
                secilenFilmiSil(silinecekFilm);
            }
        });

        listeSilMenusu.getItems().add(filmSil);
        filmListesi.setItems(FilmData.getInstance().getFilmListesi());
        txtFilmDetay.setVisible(false);
        filmListesi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observableValue, Film film, Film t1) {
                Film secilenFilm = filmListesi.getSelectionModel().getSelectedItem();
                txtFilmDetay.setText(secilenFilm.getDetay());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                labelCikisTarihi.setText(secilenFilm.getCikisTarihi().format(formatter));

                filmListesi.setCellFactory(new Callback<ListView<Film>, ListCell<Film>>() {
                    @Override
                    public ListCell<Film> call(ListView<Film> filmListView) {
                        ListCell<Film> yeniFilmListesi = new ListCell<>(){
                            @Override
                            protected void updateItem(Film item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty ||item == null){
                                    setText(null);
                                }else{
                                    setText(film.getDetay());
                                }
                            }
                        };
                        yeniFilmListesi.setContextMenu(listeSilMenusu);
                        return yeniFilmListesi;
                    }
                });
            }
        });
    }

    private void secilenFilmiSil(Film silinecekFilm) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Emin Misiniz.?");
        alert.setHeaderText("Silinecek Film = " + silinecekFilm.getAdi());

        Optional<ButtonType> sonuc = alert.showAndWait();
        if (sonuc.get() == ButtonType.OK){
            FilmData.getInstance().filmSil(silinecekFilm);
        }
    }

    @FXML
    public void filmEkleDialog(ActionEvent actionEvent){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(anaPencere.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("yeniFilmDialog.fxml"));
        dialog.setTitle("Yeni Film Ekle");
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.APPLY);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> sonuc = dialog.showAndWait();

        if (sonuc.get() == ButtonType.APPLY){
            YeniFilmController dialogController = fxmlLoader.getController();
            Film eklenecekFilm = dialogController.yeniDegerleriEkle();
            filmListesi.getSelectionModel().select(eklenecekFilm);
        }
    }

    @FXML
    public void uygulamayiKapat(ActionEvent actionEvent){
        Platform.exit(); //JAVA FX uygulamalarında başarılı bir şekilde uygulamayı kapatma şekli.
    }

}
