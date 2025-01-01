package com.example.spaceshootergui2.view;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class AbstactView {

    protected static ImageView backgroundView = setBackgroud();

    abstract void start(Stage stage);

    protected Button createButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 24));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-border-width: 2;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: white; -fx-border-width: 2;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2;"));
        return button;
    }

    protected Text createText(String text) {
        Text newText = new Text(text);
        newText.setFont(Font.font("Arial", FontWeight.BOLD, 80));
        newText.setFill(Color.YELLOW);

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(4);
        shadow.setOffsetY(4);
        shadow.setColor(Color.DARKGOLDENROD);
        newText.setEffect(shadow);

        return newText;
    }

    private static ImageView setBackgroud() {
        Image backgroundImage = new Image("/background.png"); // Ścieżka do obrazu tła
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);
        backgroundView.setPreserveRatio(false);

        return backgroundView;
    }
}
