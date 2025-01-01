package com.example.spaceshootergui2.models;

import java.time.LocalDateTime;

public class HistoryModel {

    private String date;
    private int score;
    private String result;

    public HistoryModel(String date, int score, String result) {
        this.date = date;
        this.score = score;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public String getResult() {
        return result;
    }
}
