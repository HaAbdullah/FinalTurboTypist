package com.example.build_tempotypetest;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;



public class StatsController implements Initializable{

    @FXML
    public Text WPMTEXT;
    @FXML
    public Text AccuracyText, perfectText, perfectRanking;
    @FXML
    public Text ranking;
    @FXML
    public Button globalLeaderboard;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToLLeaderboard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("localLeaderboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        


    }
    public void switchToGLeaderboard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("globalLeaderboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoUserProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //GLOBAL LEADER BOARD:
        globalLeaderboard.setDisable(true);
        perfectText.setVisible(false);
        perfectRanking.setVisible(false);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\admin\\Documents\\TurboTypistResources\\LocalScores.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String lastLine = "";
        String sCurrentLine = "--";
        while (true)
        {
            try {
                if (!((sCurrentLine = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sCurrentLine);
            lastLine = sCurrentLine;
        }
        String[] ArrayLine = lastLine.split("-");
        String giveWPM = ArrayLine[1];
        String giveAccuracy = ArrayLine[2];
        WPMTEXT.setText(giveWPM);
        if (Integer.parseInt(giveAccuracy) < 100){
            AccuracyText.setText(giveAccuracy + "%");
        }
        else{
            AccuracyText.setVisible(false);
            perfectText.setText(giveAccuracy + "%");
            perfectText.setVisible(true);
            perfectText.setStyle("-fx-text-fill: green;");
        }
        //resultInfo.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");

        int IntWPM = Integer.valueOf(giveWPM);
        if(IntWPM < 20){
            ranking.setText("92%");
        }
        else if(IntWPM <= 30){
            ranking.setText("64%");
        }
        else if(IntWPM <= 40){
            ranking.setText("28%");
        }
        else if(IntWPM <= 50){
            ranking.setText("10%");
        }
        else if(IntWPM <= 60){
            ranking.setText("5%");
        }
        else if(IntWPM <= 70){
            ranking.setText("3%");
        }
        else if(IntWPM <= 80){
            ranking.setText("1%");
        }
        else if(IntWPM <= 90){
            ranking.setText("0.5%");
            ranking.setVisible(false);
            perfectRanking.setVisible(true);
        }
        else if(IntWPM <= 95){
            ranking.setText("0.1%");
            ranking.setVisible(false);
            perfectRanking.setVisible(true);
        }
        else if(IntWPM <= 100){
            ranking.setText("0.01%");
            ranking.setVisible(false);
            perfectRanking.setVisible(true);
        }
        else{
            ranking.setText("Error");
            ranking.setVisible(false);
            perfectRanking.setVisible(true);
        }

        
    }
}
