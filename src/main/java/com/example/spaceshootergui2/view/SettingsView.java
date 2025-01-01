package com.example.spaceshootergui2.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingsView extends AbstactView{

    private CheckBox musicCheckBox;
    private CheckBox soundCheckBox;
    private Button backButton;

    public SettingsView() {
        musicCheckBox = new CheckBox("MUSIC");
        soundCheckBox = new CheckBox("SOUNDS");
        backButton = createButton("BACK");

    }

    public void start(Stage primaryStage) {
        VBox settingsBox = new VBox(15);
        settingsBox.setAlignment(Pos.CENTER);

        Text settingsText = createText("SETTINGS");
        settingsText.setTranslateY(-50);

        musicCheckBox.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-padding: 10px;");
        musicCheckBox.setMaxWidth(200);

        soundCheckBox.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-padding: 10px;");
        soundCheckBox.setMaxWidth(200);


        backButton.setOnAction(e -> primaryStage.close());
        backButton.setMinWidth(200);
        backButton.setTranslateY(50);

        settingsBox.getChildren().addAll(settingsText, musicCheckBox, soundCheckBox, backButton);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, settingsBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Settings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public CheckBox getMusicCheckBox() {
        return musicCheckBox;
    }

    public CheckBox getSoundCheckBox() {
        return soundCheckBox;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setMusicCheckBox(Boolean select) {
        this.musicCheckBox.setSelected(select);
    }

    public void setSoundCheckBox(Boolean select) {
        this.soundCheckBox.setSelected(select);
    }
}
