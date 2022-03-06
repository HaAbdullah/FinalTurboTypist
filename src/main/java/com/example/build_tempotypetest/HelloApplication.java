package com.example.build_tempotypetest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

//add an option in the leaderboard to clear all records
public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        //Group root = new Group();

        Scene scene = new Scene(root, Color.DARKBLUE);
        Image icon = new Image("keyboard.png");
        // Stage
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("TurboTypist");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}