package com.example.spaceshootergui2.view;

import com.example.spaceshootergui2.models.HistoryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryView extends AbstactView{
    private final Button backButton;
    private final TableView<HistoryModel> tableView;
    private final ObservableList<HistoryModel> historyData;

    public HistoryView() {
        this.historyData = FXCollections.observableArrayList();
        this.backButton = createButton("BACK");
        this.tableView = new TableView<>();
        tableView.setMaxHeight(300);
        tableView.setStyle("-fx-background-color: #2b2b2b; -fx-control-inner-background: #2b2b2b; -fx-table-cell-border-color: transparent;");
    }

    public void start(Stage stage) {
        Text historyText = createText("HISTORY");
        historyText.setTranslateY(-50);

        backButton.setOnAction(e -> stage.close());

        configureTable();
        tableView.setItems(historyData);

        VBox Historybox = new VBox(20, historyText, tableView, backButton);
        Historybox.setStyle("-fx-padding: 20;");
        Historybox.setAlignment(javafx.geometry.Pos.CENTER);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, Historybox);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Game History");
        stage.setScene(scene);
        stage.show();
    }


    private void configureTable() {
        tableView.getColumns().clear();
        // Kolumna z datą gry
        TableColumn<HistoryModel, LocalDate> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setMinWidth(150);

        // Kolumna z wynikiem
        TableColumn<HistoryModel, Integer> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreColumn.setMinWidth(100);

        // Kolumna z wynikiem końcowym
        TableColumn<HistoryModel, String> resultColumn = new TableColumn<>("Result");
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        resultColumn.setMinWidth(150);

        // Dodanie kolumn do tabeli
        tableView.getColumns().addAll(dateColumn, scoreColumn, resultColumn);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public Button getBackButton() {
        return backButton;
    }

    public void addGameHistory(LocalDateTime date, int score, boolean win) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        HistoryModel history = new HistoryModel(date.format(formatter), score, win? "Win" : "Game Over");
        historyData.add(history);
    }
}