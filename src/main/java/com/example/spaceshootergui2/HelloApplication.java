package com.example.spaceshootergui2;

import com.example.spaceshootergui2.controller.GameController;
import com.example.spaceshootergui2.models.GameModel;
import com.example.spaceshootergui2.view.GameView;
import com.example.spaceshootergui2.view.HistoryView;
import com.example.spaceshootergui2.view.MainView;
import com.example.spaceshootergui2.view.SettingsView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameModel gameModel = new GameModel();
        gameModel.initGameModel();

        GameView gameView = new GameView(gameModel);
        MainView mainView = new MainView();
        SettingsView settingsView = new SettingsView();
        HistoryView historyView = new HistoryView();
        GameController gameController = new GameController(stage, gameModel, gameView, mainView, settingsView, historyView);

        gameController.start();

    }

    public static void main(String[] args) {
        launch();
    }
}
