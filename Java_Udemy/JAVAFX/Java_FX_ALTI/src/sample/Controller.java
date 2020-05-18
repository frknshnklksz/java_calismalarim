package sample;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;

import java.util.ArrayList;


public class Controller {
    @FXML
    private JFXListView<String> listView;
    @FXML
    private JFXTextArea textArea;

    public void initialize(){
        listView.getItems().addAll("Domates", "Sucuk", "Peynir", "Mısır", "Zeytin", "Kasar");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    @FXML
    void listeElemanlariniTasi(ActionEvent event) {
        String txtAreaMetni = "";
        /*
        ObservableList-> ArrayList'ten çok bir farkı yoktur. Kullanımda vs. arrayList'e benzer ama
        Liste'de elemanlar güncellendiğinde otomatik olarak listeyi günceller.
         */
        ObservableList<String> secilenler = listView.getSelectionModel().getSelectedItems();
        System.out.println(secilenler);
        for (String tmp:
             secilenler) {
            txtAreaMetni = txtAreaMetni + tmp + "\n";
        }
        textArea.setText(txtAreaMetni);
    }
}
