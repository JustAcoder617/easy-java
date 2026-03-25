package br.com.justacoder.easyjava;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Easyweb {

    // Método para descriptografar (XOR)
    public static String uncriptographyXOR(String urlCifrada, int chave) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < urlCifrada.length(); i++) {
            char c = urlCifrada.charAt(i);
            resultado.append((char) (c ^ chave));
        }
        return resultado.toString();
    }

    // Método POST (Enviar dados)
    public static void sendAPImessage(String url, String jsonDados) {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonDados))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Webhook enviado! Status: " + response.statusCode());
                })
                .exceptionally(ex -> {
                    System.err.println("Erro ao disparar: " + ex.getMessage());
                    return null;
                });
    }

    public static String pickData(String url) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) 
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join(); 
    }
}