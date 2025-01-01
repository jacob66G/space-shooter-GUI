package com.example.spaceshootergui2.controller;

import com.example.spaceshootergui2.audio.SoundPlayer;
import com.example.spaceshootergui2.models.GameModel;
import com.example.spaceshootergui2.view.GameView;
import com.example.spaceshootergui2.view.HistoryView;
import com.example.spaceshootergui2.view.MainView;
import com.example.spaceshootergui2.view.SettingsView;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import static com.example.spaceshootergui2.audio.SoundPlayer.setMusicEnabled;
import static com.example.spaceshootergui2.audio.SoundPlayer.setSoundsEnabled;

public class GameController {
    private final Stage stage;
    private final GameModel model;
    private final GameView view;
    private final MainView mainView;
    private final SettingsView settingsView;
    private final HistoryView historyView;
    private AppState currentState = AppState.MENU;
    private boolean musicEnabled = true;
    private boolean soundEnabled = true;
    private AnimationTimer animationTimer;

    public GameController(Stage stage1, GameModel model, GameView view, MainView mainView, SettingsView settingsView, HistoryView historyView) {
        this.stage = stage1;
        this.model = model;
        this.view = view;
        this.mainView = mainView;
        this.settingsView = settingsView;
        this.historyView = historyView;
        stage.setResizable(false);

        SoundPlayer.playSoundLoop("/audio/musicGame2.wav");
    }

    public void start() {
        showMenu();
    }

    private void showMenu() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        mainView.start(stage);
        mainView.getPlayButton().setOnAction(e -> startGame());
        mainView.getSettingsButton().setOnAction(e -> showSettings());
        mainView.getHistoryButton().setOnAction(e -> showHistory());
        mainView.getExitButton().setOnAction(e -> stage.close());
    }

    private void startGame() {
        currentState = AppState.GAME;
        view.start(stage);
        view.getScene().setOnKeyPressed(this::handleKeyPressed);
        startGameLoop();
    }

    public void startGameLoop() {
        if (animationTimer != null) {
            animationTimer.stop();
        }

        model.initGameModel();

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!model.isPasue()) {
                    view.render();
                    model.updateGameState();
                }
                if(model.isGameOver() || model.isWin()){
                    handleGameButtons();
                }
            }
        };
        animationTimer.start();
    }

    private void showSettings() {
        currentState = AppState.SETTINGS;

        settingsView.start(stage);

        settingsView.getBackButton().setOnAction(e -> {
            currentState = AppState.MENU;
            showMenu();
        });

        settingsView.setMusicCheckBox(musicEnabled);
        settingsView.setSoundCheckBox(soundEnabled);


        settingsView.getMusicCheckBox().setOnAction(e -> {
            musicEnabled = settingsView.getMusicCheckBox().isSelected();
            setMusicEnabled(musicEnabled);
        });

        settingsView.getSoundCheckBox().setOnAction(e -> {
            soundEnabled = settingsView.getSoundCheckBox().isSelected();
            setSoundsEnabled(soundEnabled);
        });
    }

    private void showHistory() {
        currentState = AppState.HISTORY;
        historyView.start(stage);

        historyView.getBackButton().setOnAction(e -> {
            currentState = AppState.MENU;
            showMenu();
        });
    }

    public void handleKeyPressed(KeyEvent event) {
        if (currentState == AppState.GAME) {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case LEFT -> model.movePlayerLeft();
                case RIGHT -> model.movePlayerRight();
                case SPACE -> model.shoot(model.getPlayer().getX(), model.getPlayer().getY() - 1, 1);
                case ESCAPE -> { if(!model.isPasue() && !model.isWin() && !model.isGameOver()) pauseGame(); }
            }
        }
    }

    private void pauseGame() {
        model.pauseGame();
        view.displayPausedGameInfo();
        handleGameButtons();
    }


    public void handleGameButtons() {

        view.getContinueButton().setOnAction(e -> {
            if (model.isGameOver()) {
                historyView.addGameHistory(model.getGameDate(), model.getScore(), model.isWin());
                model.initGameModel();
                view.removeButtons();
                startGameLoop();
            } else if (model.isPasue()) {
                model.restartPauseGame();
                view.removeButtons();
                view.removePauseText();
            }
        });

        view.getMenuButton().setOnAction(e -> {
            historyView.addGameHistory(model.getGameDate(), model.getScore(), model.isWin());
            currentState = AppState.MENU;
            showMenu();
        });
    }

}
