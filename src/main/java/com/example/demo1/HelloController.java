package com.example.demo1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField targa_da_inserire;

    @FXML
    private Label showTarga;

    @FXML
    private Label risposta1;

    String testo;




    @FXML
    private void avantiOnClick(){
        String targa = "La targa che hai inseiro e' " +targa_da_inserire.getText();
        showTarga.setText(targa);
        testo=targa_da_inserire.getText();
        System.out.println(targa_da_inserire.getText());
        SitoCom sito = new SitoCom();
        System.out.println(testo);
        String risposta= sito.richiestaAlSito(testo);
        System.out.println(risposta);
        Gson gson=new Gson();
        JsonObject jsonObject = gson.fromJson(risposta,JsonObject.class);

        System.out.println(risposta);
        System.out.println(jsonObject);

         ResponseStrategy notFoundStrategy = new NotFoundStrategy();
         ResponseStrategy foundStrategy = new FoundStrategy();


        if (risposta.equals("{\"codice\":\"499\",\"esito\":\"OK\",\"informations\":[],\"messaggio\":\"Per il veicolo selezionato non risultano revisioni effettuate dopo il 1 giugno 2018\",\"result\":null,\"verifica\":false}")) {
            notFoundStrategy.handleResponse(risposta, risposta1);
        } else {
            foundStrategy.handleResponse(risposta, risposta1);
        }



        /*if (risposta.equals("{\"codice\":\"499\",\"esito\":\"OK\",\"informations\":[],\"messaggio\":\"Per il veicolo selezionato non risultano revisioni effettuate dopo il 1 giugno 2018\",\"result\":null,\"verifica\":false}")){
            System.out.println("auto non trovata");
            risposta1.setText("Auto non trovata");
        } */

        /*JsonArray informationsArray = jsonObject.getAsJsonArray("informations");

        for (JsonElement informationElement : informationsArray) {
            JsonObject informationObject = informationElement.getAsJsonObject();
            String numKmiPcsRvs = informationObject.get("numKmiPcsRvs").getAsString();
            System.out.println("numKmiPcsRvs: " + numKmiPcsRvs);
            risposta1.setText(numKmiPcsRvs);
        } */




    }






}

