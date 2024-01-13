package com.example.demo1;
import java.net.http.HttpClient;


public class HttpClientFactory {
    public static HttpClient createDefaultClient() {
        return HttpClient.newHttpClient();
    }
}
