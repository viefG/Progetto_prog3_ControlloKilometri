package com.example.demo1;

import javafx.scene.control.Label;

public class NotFoundStrategy implements ResponseStrategy {
    @Override
    public void handleResponse(String response, Label rispostaLabel) {
        rispostaLabel.setText("Auto non trovata");
    }
}