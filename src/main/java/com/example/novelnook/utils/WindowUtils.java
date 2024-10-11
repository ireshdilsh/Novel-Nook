package com.example.novelnook.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowUtils {
    public void setWindow(String fileName) {
       try {
           Stage stage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("/com/example/novelnook/"+fileName));
           stage.setScene(new Scene(root));
           stage.show();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
