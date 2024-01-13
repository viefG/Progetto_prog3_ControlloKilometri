package com.example.demo1;
import javafx.scene.control.Label;


public interface ResponseStrategy {
    void handleResponse(String response, Label rispostaLabel);
}
