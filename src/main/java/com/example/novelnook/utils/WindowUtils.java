package com.example.novelnook.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.MouseEvent;

public class WindowUtils {

    private double xOffset = 0;
    private double yOffset = 0;

    public void setWindow(String fileName) {
        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/novelnook/" + fileName));
            // Setting stage style to undecorated
            stage.initStyle(StageStyle.UNDECORATED);

            // Adding mouse event handlers to make the window draggable
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
