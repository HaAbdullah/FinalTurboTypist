package com.example.build_tempotypetest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SettingsController implements Initializable{

    @FXML
    private RadioButton rButton1, rButton2, rButton3, rButton4;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private Label timerText;

    @FXML
    private Slider timerSlider;

    private Media media;
    private MediaPlayer mediaPlayer;

    String theme;
    public String getTheme(){

        if(rButton1.isSelected()) {
            theme = rButton1.getText();
            return theme;
        }
        else if(rButton2.isSelected()) {
            theme = rButton2.getText();
            return theme;
        }
        else if(rButton3.isSelected()) {
            theme = rButton3.getText();
            return theme;
        }
        else if(rButton4.isSelected()) {
            theme = rButton4.getText();
            try {
                // Creates a FileWriter
                FileWriter file = new FileWriter("C:\\Users\\admin\\Documents\\TurboTypistResources\\LocalScores.txt", true);

                // Creates a BufferedWriter
                BufferedWriter output = new BufferedWriter(file);

                // Writes the string to the file
                output.write("-00-00");

                // Closes the writer
                output.close();
            }

            catch (Exception e) {
                e.getStackTrace();
            }
            return theme;
        }
        else
            return "Normal";
    }

    public void saveTheme(){
        getTheme();
        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter("C:\\Users\\admin\\Documents\\TurboTypistResources\\localThemes.txt");

            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            // Writes the string to the file
            output.write(theme);
            System.out.println(theme);

            // Closes the writer
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }




    private String[] food = {"pizza","sushi","ramen"};

    int timerValue;
    int timerSaveValue;
    @Override
    public void initialize(URL url, ResourceBundle resources) {

        File file = new File("C:\\Users\\admin\\Documents\\TurboTypistResources\\gamerMusic.mp3");

        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        timerValue = (int) timerSlider.getValue();
        timerText.setText(Integer.toString(timerValue));

        timerSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {
                timerValue = (int) timerSlider.getValue();
                timerText.setText(Integer.toString(timerValue));
                giveTimer();
            }
        });
    }

    public void playMedia() {
        mediaPlayer.play();
    }

    public void pauseMedia() {
        mediaPlayer.pause();
    }

    public void resetMedia() {
        mediaPlayer.seek(Duration.seconds(0));
    }

    public void giveTimer(){
        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter("C:\\Users\\admin\\Documents\\TurboTypistResources\\localTimers.txt");

            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            // Writes the string to the file
            String stringTimer = String.valueOf(timerValue);
            output.write(stringTimer);
            System.out.println(timerValue);

            // Closes the writer
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchtoUserProfile(ActionEvent event) throws IOException {
        saveTheme();
        root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToGame(ActionEvent event) throws IOException {
        saveTheme();
        root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}