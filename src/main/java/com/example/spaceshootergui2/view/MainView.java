package com.example.spaceshootergui2.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainView extends AbstactView{

    private final Button playButton;
    private final Button settingsButton;
    private final Button historyButton;
    private final Button exitButton;

    public MainView() {
        playButton = createButton("PLAY");
        settingsButton = createButton("SETTINGS");
        historyButton = createButton("HISTORY");
        exitButton = createButton("EXIT");
    }

    public void start(Stage stage) {
        VBox menuBox = new VBox(15);
        menuBox.setAlignment(Pos.CENTER);

        Text menuText = createText("MENU");
        menuText.setTranslateY(-50);

        menuBox.getChildren().addAll(menuText, playButton, settingsButton, historyButton, exitButton);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, menuBox);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }


    public Button getPlayButton() {
        return playButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    public Button getHistoryButton() {
        return historyButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}


