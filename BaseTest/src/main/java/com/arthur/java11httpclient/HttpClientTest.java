package com.arthur.java11httpclient;


/*
public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://javastack.cn"))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

// 同步

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

// 异步

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())

                .thenApply(HttpResponse::body)

                .thenAccept(System.out::println);


    }
}*/
