package com.fsk;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    public void beniTiklaMethodu(ActionEvent actionEvent){

        String buttonText = ((Button)(actionEvent.getSource())).getText();
        if (buttonText.equals("CLICK ME")){
            System.out.println("Kirmizi buton tiklandi");
        }else if(buttonText.equals("MERHABA")){
            System.out.println("Yesil buton tiklandi");
        }else System.out.println("Mavi Buton tiklandi");

    }
}
