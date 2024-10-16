package com.example.novelnook;

import com.example.novelnook.utils.MailUtil;
import com.example.novelnook.utils.WindowUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       new WindowUtils().setWindow("Main-View.fxml");
    }

    public static void main(String[] args) throws Exception {
        launch();
    }

    public void onHelloButtonClick(ActionEvent actionEvent) throws Exception {
        MailUtil.sendMail("ireshdilshan46@gmail.com");
    }
}