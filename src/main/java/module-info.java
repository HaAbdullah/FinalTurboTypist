module com.example.build_tempotypetest {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.build_tempotypetest to javafx.fxml;
    exports com.example.build_tempotypetest;
}