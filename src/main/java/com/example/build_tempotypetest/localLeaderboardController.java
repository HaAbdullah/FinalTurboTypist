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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void switchToStats(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("afterGameStats.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {

        ArrayList<String> Names = new ArrayList<String>();
        ArrayList<Integer> WPM = new ArrayList<Integer>();
        ArrayList<String> Accuracy = new ArrayList<String>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\admin\\Documents\\TurboTypistResources\\LocalScores.txt"));
            String line = reader.readLine();
            while (line != null && line.contains("-") == true) {
                String[] ArrayLine = line.split("-");

                Names.add(ArrayLine[0]);
                WPM.add(Integer.valueOf(ArrayLine[1]));
                Accuracy.add(ArrayLine[2]);
                // read next line
                line = reader.readLine();
            }

            System.out.println("Names:" + Names);
            System.out.println("WPMS:" + WPM);
            System.out.println("Accuracy:" + Accuracy);

            int firstWPM = Collections.max(WPM);
            int highestIteration = WPM.indexOf(firstWPM);


            String firstName = Names.get(highestIteration);

            String firstAccuracy = Accuracy.get(highestIteration);

            WPM.set(highestIteration, 0);
            //--------------------------

            int secondWPM = Collections.max(WPM);
            int secondHighestIteration = WPM.indexOf(secondWPM);


            String secondName = Names.get(secondHighestIteration);
            String secondAccuracy = Accuracy.get(secondHighestIteration);


            WPM.set(secondHighestIteration, 0);
            //--------------------------


            int thirdWPM = Collections.max(WPM);
            int thirdHighestIteration = WPM.indexOf(thirdWPM);


            String thirdName = Names.get(thirdHighestIteration);
            String thirdAccuracy = Accuracy.get(thirdHighestIteration);

            WPM.set(thirdHighestIteration, 0);
            //--------------------------


            int fourthWPM = Collections.max(WPM);
            int fourthHighestIteration = WPM.indexOf(fourthWPM);


            String fourthName = Names.get(fourthHighestIteration);
            String fourthAccuracy = Accuracy.get(fourthHighestIteration);

            WPM.set(fourthHighestIteration, 0);
            //--------------------------


            int fifthWPM = Collections.max(WPM);
            int fifthHighestIteration = WPM.indexOf(fifthWPM);


            String fifthName = Names.get(fifthHighestIteration);
            String fifthAccuracy = Accuracy.get(fifthHighestIteration);

            WPM.set(fifthHighestIteration, 0);
            //--------------------------


            int sixthWPM = Collections.max(WPM);
            int sixthHighestIteration = WPM.indexOf(sixthWPM);


            String sixthName = Names.get(sixthHighestIteration);
            String sixthAccuracy = Accuracy.get(sixthHighestIteration);

            WPM.set(sixthHighestIteration, 0);
            //--------------------------


            int seventhWPM = Collections.max(WPM);
            int seventhHighestIteration = WPM.indexOf(seventhWPM);


            String seventhName = Names.get(seventhHighestIteration);
            String seventhAccuracy = Accuracy.get(seventhHighestIteration);

            WPM.set(seventhHighestIteration, 0);
            //--------------------------


            int eigthWPM = Collections.max(WPM);
            int eigthHighestIteration = WPM.indexOf(eigthWPM);


            String eigthName = Names.get(eigthHighestIteration);
            String eigthAccuracy = Accuracy.get(eigthHighestIteration);


            WPM.set(eigthHighestIteration, 0);
            //--------------------------


            int ninthWPM = Collections.max(WPM);
            int ninthHighestIteration = WPM.indexOf(ninthWPM);


            String ninthName = Names.get(ninthHighestIteration);
            String ninthAccuracy = Accuracy.get(ninthHighestIteration);

            WPM.set(ninthHighestIteration, 0);
            //--------------------------


            int tenthWPM = Collections.max(WPM);
            int tenthHighestIteration = WPM.indexOf(tenthWPM);


            String tenthName = Names.get(tenthHighestIteration);

            String tenthAccuracy = Accuracy.get(tenthHighestIteration);


            WPM.set(ninthHighestIteration, 0);

            firstNamet.setText(firstName);
            secondNamet.setText(secondName);
            thirdNamet.setText(thirdName);
            fourthNamet.setText(fourthName);
            fifthNamet.setText(fifthName);
            sixthNamet.setText(sixthName);
            seventhNamet.setText(seventhName);
            eigthNamet.setText(eigthName);
            ninthNamet.setText(ninthName);
            tenthNamet.setText(tenthName);

            firstAccuracyt.setText(firstAccuracy);
            secondAccuracyt.setText(secondAccuracy);
            thirdAccuracyt.setText(thirdAccuracy);
            fourthAccuracyt.setText(fourthAccuracy);
            fifthAccuracyt.setText(fifthAccuracy);
            sixthAccuracyt.setText(sixthAccuracy);
            seventhAccuracyt.setText(seventhAccuracy);
            eightAccuracyt.setText(eigthAccuracy);
            ninthAccuracyt.setText(ninthAccuracy);
            tenthAccuracyt.setText(tenthAccuracy);

            firstWPMt.setText(String.valueOf(firstWPM));
            secondWPMt.setText(String.valueOf(secondWPM));
            thirdWPMt.setText(String.valueOf(thirdWPM));
            fourthWPMt.setText(String.valueOf(fourthWPM));
            fifthWPMt.setText(String.valueOf(fifthWPM));
            sixthWPMt.setText(String.valueOf(sixthWPM));
            seventhWPMt.setText(String.valueOf(seventhWPM));
            eigthWPMt.setText(String.valueOf(eigthWPM));
            ninthWPMt.setText(String.valueOf(ninthWPM));
            tenthWPMt.setText(String.valueOf(tenthWPM));
            //--------------------------

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
