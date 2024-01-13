package com.example.demo1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.scene.control.Label;

public class FoundStrategy implements ResponseStrategy {
    @Override
    public void handleResponse(String response, Label rispostaLabel) {
        Gson gson=new Gson();
        JsonObject jsonObject = gson.fromJson(response,JsonObject.class);

        JsonArray informationsArray = jsonObject.getAsJsonArray("informations");

        for (JsonElement informationElement : informationsArray) {
            JsonObject informationObject = informationElement.getAsJsonObject();
            String numKmiPcsRvs = informationObject.get("numKmiPcsRvs").getAsString();
            System.out.println("numKmiPcsRvs: " + numKmiPcsRvs);
            rispostaLabel.setText(numKmiPcsRvs);
        }
    }
}
