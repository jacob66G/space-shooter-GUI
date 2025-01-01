package com.example.spaceshootergui2.view;

import com.example.spaceshootergui2.models.*;
import com.example.spaceshootergui2.models.Character;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class GameView extends AbstactView {

    private Canvas canvas;
    private Pane root;
    private final GameModel model;
    private final Image playerImage;
    private final Image bulletImage;
    private final Image heartImage;
    private final Image explosionImage;
    private final Image backgroundImage;
    private Scene scene;
    private final Text pauseText;
    private Timeline timeline;

    private Button continueButton;
    private Button menuButton;
    private boolean animationStart;

    public GameView(GameModel model) {
        this.model = model;
        this.backgroundImage = new Image("/background.png");
        this.playerImage = new Image("/player.png");
        this.bulletImage = new Image("/laser.png");
        this.heartImage = new Image("/heart.png");
        this.explosionImage = new Image("/explosion.png");
        this.pauseText = new Text("PAUSED");
    }

    public Scene getScene() {
        return scene;
    }

    public void start(Stage stage) {
        this.root = new Pane();
        this.canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);
        this.scene = new Scene(root, 800, 600);
        createButtons();
        stage.setScene(scene);

        System.out.println(canvas.getWidth());
        System.out.println(canvas.getHeight());
    }


    public void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(backgroundImage, 0, 0, canvas.getWidth(), canvas.getHeight());

        if ((model.isDisplayNextLevel() || model.isDisplayNextAttack()  || model.isWin() || model.isGameOver()) && !model.isPasue() && !animationStart) {
            displayMessages(model, gc);
        }

        if((!model.isDisplayNextLevel() && !model.isDisplayNextAttack()) && !model.isGameOver() && !model.isGameOver()) {
            animationStart = false;
        }

        renderPlayer(gc);
        renderBullets(gc);
        renderAliens(gc);
        displayGameInfo(gc);
    }

    private void renderPlayer(GraphicsContext gc) {
        double playerX = model.getPlayer().getX();
        double playerY = model.getPlayer().getY();
        double playerWidth = model.getPlayer().getCharacterWidth();
        double playerHeight = model.getPlayer().getCharacterHeight();

        if (model.getPlayer().isDestroy() && !model.getPlayer().isExplosionStarted()) {
            model.getPlayer().setExplosionStarted(true);
            renderExplosion(gc, playerX, playerY, model.getPlayer());
        }
        else if (model.getPlayer().isHit()) {
            hit(gc, playerX, playerY, model.getPlayer());
        }
        else if(!model.isGameOver()){
            Image image = playerImage;
            gc.drawImage(image, playerX, playerY, playerWidth, playerHeight);
        }
    }

    private void renderBullets(GraphicsContext gc) {
        for (Bullet bullet : model.getBullets()) {
            double bulletX = bullet.getX();
            double bulletY = bullet.getY();
            double bulletWidth = bullet.getBulletWidth();
            double bulletHeight = bullet.getBulletHeight();
            gc.drawImage(bulletImage, bulletX, bulletY, bulletWidth, bulletHeight);
        }
    }

    private void renderAliens(GraphicsContext gc) {
        for (Alien alien : model.getAliens()) {
            double alienX = alien.getX();
            double alienY = alien.getY();
            double alienWidth = alien.getCharacterWidth();
            double alienHeight = alien.getCharacterHeight();


            if (alien.isHit()) {
                hit(gc, alienX, alienY, alien);
            } else if (alien.isDestroy() && !alien.isExplosionStarted()) {
                alien.setExplosionStarted(true);
                renderExplosion(gc, alienX, alienY, alien);
            }
             else if (!alien.isDestroy()) {
                Image alienImage = new Image("/" + alien.getImagePath());
                gc.drawImage(alienImage, alienX, alienY, alienWidth, alienHeight);
            }
        }
    }

    private void displayGameInfo(GraphicsContext gc) {
        int playerLives = model.getPlayer().getHealth();
        for (int i = 0; i < playerLives; i++) {
            double heartX = 10 + (i * 20);
            double heartY = canvas.getHeight() - 40;
            gc.drawImage(heartImage, heartX, heartY, 20, 20);
        }

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        String levelText = "LEVEL: " + model.getCurrentLevelNumber();
        String scoreText = "SCORE: " + model.getScore();
        gc.fillText(levelText, canvas.getWidth() - 150, 30);
        gc.fillText(scoreText, canvas.getWidth() - 150, 60);
    }

    public void displayPausedGameInfo() {
        pauseText.setFont(Font.font("Impact", FontWeight.BOLD, 70));
        pauseText.setFill(Color.YELLOW);
        pauseText.setStroke(Color.BLACK);
        pauseText.setStrokeWidth(2.0);

        pauseText.setX((canvas.getWidth() - pauseText.getLayoutBounds().getWidth()) / 2);
        pauseText.setY((canvas.getHeight() - pauseText.getLayoutBounds().getHeight()) / 2 - 50);

        root.getChildren().addAll(pauseText);
        displayGameButtons();

         timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e -> pauseText.setVisible(false)),
                new KeyFrame(Duration.seconds(1), e -> pauseText.setVisible(true))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void displayGameButtons() {
        root.getChildren().addAll(continueButton, menuButton);
    }

    public void createButtons() {
        double centerX = canvas.getWidth() / 2;

        continueButton = createButton("CONTINUE");
        continueButton.setMinWidth(200);
        continueButton.setLayoutX(centerX - continueButton.getMinWidth() / 2);
        continueButton.setLayoutY(canvas.getHeight() / 2);

        menuButton = createButton("MENU");
        menuButton.setMinWidth(200);
        menuButton.setLayoutX(centerX - menuButton.getMinWidth() / 2);
        menuButton.setLayoutY(canvas.getHeight() / 2 + 70);
    }

    private void displayMessages(GameModel model, GraphicsContext gc) {
        String text;

        if(model.isDisplayNextLevel())
            text = "LEVEL " + model.getCurrentLevelNumber();

        else if(model.isDisplayNextAttack())
            text = "ATTACK";

        else if(model.isWin())
            text = "WIN !";

        else {
            text = "GAME OVER";
        }


        double textX = canvas.getWidth() / 2;
        double textY = canvas.getHeight() / 2 - 50;

        AnimationTimer levelAnimation = new AnimationTimer() {
            private double scale = 0.1;
            private final double maxScale = 1.0;
            private boolean finishedScaling = false;

            @Override
            public void handle(long now) {
                gc.setFont(Font.font("Impact", FontWeight.BOLD, 50 * scale));
                gc.setLineWidth(4);
                gc.strokeText(text, textX - (50 * scale * text.length()) / 4, textY);
                gc.setFill(Color.YELLOW);
                gc.fillText(text, textX - (50 * scale * text.length()) / 4, textY);

                if (!finishedScaling) {
                    scale += 0.02;

                    if (scale >= maxScale) {
                        scale = maxScale;
                        finishedScaling = true;

                        if(model.isGameOver()){
                            displayGameButtons();
                        }
                    }
                }
                if (!animationStart) {
                    stop();
                }
            }
        };

        levelAnimation.start();
        animationStart = true;
    }

    public void removeButtons() {
        root.getChildren().removeAll(continueButton, menuButton);
    }

    public void removePauseText() {
        timeline.stop();
        root.getChildren().remove(pauseText);
    }

    public Button getContinueButton() {
        return continueButton;
    }

    public Button getMenuButton() {
        return menuButton;
    }


    private void renderExplosion(GraphicsContext gc, double x, double y, Character character) {
        new AnimationTimer() {
            private double scale = 0.1;
            private boolean finishedScaling = false;

            @Override
            public void handle(long now) {
                gc.drawImage(
                        explosionImage,
                        x - (50 * scale),
                        y - (50 * scale),
                        100 * scale,
                        100 * scale
                );

                if (!finishedScaling) {
                    scale += 0.05;

                    if (scale >= 1.5) {

                        finishedScaling = true;
                    }
                } else {
                    stop();
                    if((character) instanceof Alien){
                        model.removeAlien((Alien) character);
                    }

                    if((character) instanceof Player){
                        model.gameOver();
                    }
                }
            }
        }.start();
    }

    private void hit(GraphicsContext gc, double x, double y, Character character) {
        Image hitImage = new Image("/hit-" + character.getImagePath());
        gc.drawImage(hitImage, x, y, character.getCharacterWidth(), character.getCharacterHeight());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            character.setHit(false);
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
