package com.example.build_tempotypetest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class localLeaderboardController {

    @FXML
    private Text firstNamet;
    @FXML
    private Text firstAccuracyt;
    @FXML
    private Text firstWPMt;
    @FXML
    private Text secondNamet;
    @FXML
    private Text secondAccuracyt;
    @FXML
    private Text secondWPMt;
    @FXML
    private Text thirdNamet;
    @FXML
    private Text thirdAccuracyt;
    @FXML
    private Text thirdWPMt;
    @FXML
    private Text fourthNamet;
    @FXML
    private Text fourthAccuracyt;
    @FXML
    private Text fourthWPMt;
    @FXML
    private Text fifthNamet;
    @FXML
    private Text fifthAccuracyt;
    @FXML
    private Text fifthWPMt;
    @FXML
    private Text sixthNamet;
    @FXML
    private Text sixthAccuracyt;
    @FXML
    private Text sixthWPMt;
    @FXML
    private Text seventhNamet;
    @FXML
    private Text seventhAccuracyt;
    @FXML
    private Text seventhWPMt;
    @FXML
    private Text eigthNamet;
    @FXML
    private Text eightAccuracyt;
    @FXML
    private Text eigthWPMt;
    @FXML
    private Text ninthNamet;
    @FXML
    private Text ninthAccuracyt;
    @FXML
    private Text ninthWPMt;
    @FXML
    private Text tenthNamet;
    @FXML
    private Text tenthAccuracyt;
    @FXML
    private Text tenthWPMt;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Connection connect() {
        // Replace "your_database_url", "your_username", and "your_password" with your database credentials
        String url = "jdbc:mysql://your_database_url";
        String username = "your_username";
        String password = "your_password";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void switchToStats(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("afterGameStats.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        ArrayList<String> Names = new ArrayList<>();
        ArrayList<Integer> WPM = new ArrayList<>();
        ArrayList<String> Accuracy = new ArrayList<>();

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM leaderboard ORDER BY WPM DESC LIMIT 10")) {

            while (resultSet.next()) {
                Names.add(resultSet.getString("name"));
                WPM.add(resultSet.getInt("wpm"));
                Accuracy.add(resultSet.getString("accuracy"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Clear previous data from Text elements
        clearTextElements();

        int leaderboardSize = Names.size();
        for (int i = 0; i < leaderboardSize; i++) {
            String name = Names.get(i);
            int wpm = WPM.get(i);
            String accuracy = Accuracy.get(i);

            setTextElement(i + 1, name, wpm, accuracy);
        }
    }

    private void clearTextElements() {
        firstNamet.setText("");
        firstWPMt.setText("");
        firstAccuracyt.setText("");
        secondNamet.setText("");
        secondWPMt.setText("");
        secondAccuracyt.setText("");
        thirdNamet.setText("");
        thirdWPMt.setText("");
        thirdAccuracyt.setText("");
        fourthNamet.setText("");
        fourthWPMt.setText("");
        fourthAccuracyt.setText("");
        fifthNamet.setText("");
        fifthWPMt.setText("");
        fifthAccuracyt.setText("");
        sixthNamet.setText("");
        sixthWPMt.setText("");
        sixthAccuracyt.setText("");
        seventhNamet.setText("");
        seventhWPMt.setText("");
        seventhAccuracyt.setText("");
        eigthNamet.setText("");
        eigthWPMt.setText("");
        eightAccuracyt.setText("");
        ninthNamet.setText("");
        ninthWPMt.setText("");
        ninthAccuracyt.setText("");
        tenthNamet.setText("");
        tenthWPMt.setText("");
        tenthAccuracyt.setText("");
    }

    private void setTextElement(int position, String name, int wpm, String accuracy) {
        switch (position) {
            case 1:
                firstNamet.setText(name);
                firstWPMt.setText(String.valueOf(wpm));
                firstAccuracyt.setText(accuracy);
                break;
            case 2:
                secondNamet.setText(name);
                secondWPMt.setText(String.valueOf(wpm));
                secondAccuracyt.setText(accuracy);
                break;
            case 3:
                thirdNamet.setText(name);
                thirdWPMt.setText(String.valueOf(wpm));
                thirdAccuracyt.setText(accuracy);
                break;
            case 4:
                fourthNamet.setText(name);
                fourthWPMt.setText(String.valueOf(wpm));
                fourthAccuracyt.setText(accuracy);
                break;
            case 5:
                fifthNamet.setText(name);
                fifthWPMt.setText(String.valueOf(wpm));
                fifthAccuracyt.setText(accuracy);
                break;
            case 6:
                sixthNamet.setText(name);
                sixthWPMt.setText(String.valueOf(wpm));
                sixthAccuracyt.setText(accuracy);
                break;
            case 7:
                seventhNamet.setText(name);
                seventhWPMt.setText(String.valueOf(wpm));
                seventhAccuracyt.setText(accuracy);
                break;
            case 8:
                eigthNamet.setText(name);
                eigthWPMt.setText(String.valueOf(wpm));
                eightAccuracyt.setText(accuracy);
                break;
            case 9:
                ninthNamet.setText(name);
                ninthWPMt.setText(String.valueOf(wpm));
                ninthAccuracyt.setText(accuracy);
                break;
            case 10:
                tenthNamet.setText(name);
                tenthWPMt.setText(String.valueOf(wpm));
                tenthAccuracyt.setText(accuracy);
                break;
            default:
                break;
        }
    }
}
