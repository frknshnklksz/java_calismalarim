package com.fsk.filmler;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.time.LocalDate;

public class YeniFilmController {
    @FXML
    private JFXTextField txtFilmDetay;
    @FXML
    private JFXTextField txtFilmAdi;
    @FXML
    private JFXTextField txtTuru;
    @FXML
    private JFXTextField txtYonetmen;
    @FXML
    private JFXDatePicker dateCikisTarihi;

    public Film yeniDegerleriEkle() {
        String filmAdi = txtFilmAdi.getText().trim();
        String filmDetayi = txtFilmDetay.getText().trim();
        String filmTuru = txtTuru.getText().trim();
        String filmYonetmeni = txtYonetmen.getText().trim();
        LocalDate filmCikisTarihi =  dateCikisTarihi.getValue();

        Film eklenecekFilm = new Film(filmAdi, filmDetayi, filmTuru, filmCikisTarihi, filmYonetmeni);
        FilmData.getInstance().filmEkle(eklenecekFilm);
        return eklenecekFilm;
    }
}
