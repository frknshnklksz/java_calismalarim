package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class Controller {


    @FXML
    private JFXButton btnMerhaba;
    @FXML
    private JFXButton btnHoscakal;
    @FXML
    private JFXTextField adiniSoyle;
    @FXML
    private JFXTextField sonuc;
    @FXML
    private Button btnAdin;
    @FXML
    private JFXCheckBox chekBoxControl;

    /*
    Aşağıdaki initialize() methodu FX uygulaması çalıştırılmadan önce tetiklenen yer.
    Burada FX uygulaması çalışmadan önce ne istiyorsak onları yapabiliriz.
     */
    @FXML
    public void initialize(){
        btnMerhaba.setDisable(true);
        btnHoscakal.setDisable(true);
        btnAdin.setDisable(true);

    }

    @FXML
    void adinAction(ActionEvent event) {
        //System.out.println(event.getSource());
        String isim = adiniSoyle.getText();
        sonuc.setText("Ismin : " + isim.trim());
        if (chekBoxControl.isSelected() == true){
            adiniSoyle.clear();
            btnAdin.setDisable(true);
            btnHoscakal.setDisable(true);
            btnMerhaba.setDisable(true);
        }
    }

    @FXML
    void hoscakalAction(ActionEvent event) {
        sonuc.setText("Hoscakal " + adiniSoyle.getText().trim());
        if (chekBoxControl.isSelected() == true){
            adiniSoyle.clear();
            btnAdin.setDisable(true);
            btnHoscakal.setDisable(true);
            btnMerhaba.setDisable(true);
        }
    }

    @FXML
    void merhabaAction(ActionEvent event) {
        sonuc.setText("Merhaba " + adiniSoyle.getText().trim());
        if (chekBoxControl.isSelected() == true){
            adiniSoyle.clear();
            btnAdin.setDisable(true);
            btnHoscakal.setDisable(true);
            btnMerhaba.setDisable(true);
        }
    }

    public void textGirildi(KeyEvent keyEvent){
        String isim =adiniSoyle.getText();
        boolean butonlariDisableEt = isim.isEmpty() || isim.trim().isEmpty();
        btnMerhaba.setDisable(butonlariDisableEt);
        btnAdin.setDisable(butonlariDisableEt);
        btnHoscakal.setDisable(butonlariDisableEt);

    }

    public void chckBoxSecimi(ActionEvent event){
        chekBoxControl.isSelected();
    }

}
