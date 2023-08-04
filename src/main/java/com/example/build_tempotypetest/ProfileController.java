package com.example.build_tempotypetest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProfileController {

    @FXML
    private Label enterUsername, tooShort, tooLong, hasDashes;
    @FXML
    private TextField username;
    @FXML
    private Button playButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button styleRectangle;


    public void initialize() {
        playButton.setVisible(false);
        settingsButton.setVisible(false);
        tooShort.setVisible(false);
        tooLong.setVisible(false);
        hasDashes.setVisible(false);
    }


    String enteredUsername;
    Boolean submit = false;
    String data;
    public void submitUsername(KeyEvent ke){
        if (ke.getCode().equals(KeyCode.ENTER)) {
            enteredUsername = username.getText();

            if(enteredUsername.length() < 2){
                tooShort.setVisible(false);
                tooLong.setVisible(false);
                hasDashes.setVisible(false);

                tooShort.setVisible(true);
                submit = false;
            }
            else if(enteredUsername.length() > 11){
                tooShort.setVisible(false);
                tooLong.setVisible(false);
                hasDashes.setVisible(false);

                tooLong.setVisible(true);
                submit = false;
            }
            else if(enteredUsername.contains("-")){
                tooShort.setVisible(false);
                tooLong.setVisible(false);
                hasDashes.setVisible(false);

                hasDashes.setVisible(true);
                submit = false;
            }
            else
                submit = true;

            if(submit) {
                System.out.println(enteredUsername);
                tooShort.setVisible(false);
                tooLong.setVisible(false);
                hasDashes.setVisible(false);

                username.setVisible(false);
                enterUsername.setVisible(false);
                playButton.setVisible(true);
                settingsButton.setVisible(true);

                data = "\n" + enteredUsername;
            }

            //you have to also make it so that if there is a line with just a name then it should delete it



            try {
                // Creates a FileWriter
                FileWriter file = new FileWriter("C:\\Users\\abdul\\OneDrive\\Documents\\TurboTypistResources\\LocalScores.txt", true);

                // Creates a BufferedWriter
                BufferedWriter output = new BufferedWriter(file);

                // Writes the string to the file
                output.write(data);

                // Closes the writer
                output.close();
            }

            catch (Exception e) {
                e.getStackTrace();
            }

        }

    }

    /*
    public void writeName(){
        String data = "\n" + enteredUsername;

        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter("C:\\Users\\admin\\Desktop\\Java\\IdeaProjects\\build_TempoTypeTest\\src\\main\\resources\\LocalScores.txt", true);

            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            // Writes the string to the file
            output.write(data);

            // Closes the writer
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }
    */


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getValue() {
        return this.enteredUsername;
    }

}

