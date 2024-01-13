package com.example.demo1;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class SitoCom {

    public String richiestaAlSito(String targa) {

        String prova;

        System.out.println("https://www.ilportaledellautomobilista.it/interrogazionistoricorevisioni/api/v1/storicorevisioni/A/"+targa);


        String requestBody = "{\n" +
                "  \"id\": \"48967587645265445130\",\n" +
                "  \"text\": \"LJW7lDlT\"\n" +
                "}";

        HttpClient httpClient = HttpClientFactory.createDefaultClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.ilportaledellautomobilista.it/interrogazionistoricorevisioni/noauth/captcha/verify"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            prova=responseBody;
            System.out.println(responseBody);
        } catch (IOException | InterruptedException e){
            return "errore";
        }
        System.out.println(prova);

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(prova, JsonObject.class);

        // Accedere al campo "guid"
        String guid = jsonObject.get("guid").getAsString();
        System.out.println("guid: "+guid);




        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://www.ilportaledellautomobilista.it/interrogazionistoricorevisioni/api/v1/storicorevisioni/A/"+targa))
                //.headers( "guid: " +guid)
                .header("Content-Type", "application/json")
                .header("guid", guid)
                .GET()
                .build();

        try {
            HttpResponse<String> response1 = httpClient.send(request1, HttpResponse.BodyHandlers.ofString());
            String responseBody1 = response1.body();
            return responseBody1;
        } catch (IOException | InterruptedException e){
            return "errore";
        }


    }

}
