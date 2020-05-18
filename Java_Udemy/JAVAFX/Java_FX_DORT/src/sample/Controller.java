package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {


    @FXML
    private JFXButton btnGiris;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField sifre;
    @FXML
    private Label sonuc;

    @FXML
    public void btnGirisYap(ActionEvent actionEvent){
        if (email.getText().equals("furkankulaksiz68@gmail.com") && sifre.getText().equals("123456")){
            sonuc.setText("WELCOME");
        }else{
            sonuc.setText("Opppps.!! TRY AGAIN");
        }
    }
}
