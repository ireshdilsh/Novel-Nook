module com.example.novelnook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires java.mail;

    opens com.example.novelnook to javafx.fxml;
    exports com.example.novelnook;
}