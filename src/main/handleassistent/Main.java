/*
import Brukerprofiler.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileToProduct ftp = new FileToProduct();
        try {
            ftp.loadFromCsv("data/products.csv");

            // Create search engine with loaded products
            ProductSearch searchEngine = new ProductSearch(ftp.getProducts());
            String userInput = "brød";
            List<String> filters = Arrays.asList("organic");
            ArrayList<Product> productMatches = searchEngine.searchByKeyword(userInput, filters);

            for (Product p : productMatches) {
                System.out.println(p.getName());
            }

        }
        catch (IOException  e) {
            System.err.println("Kunne ikke lese filen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
*/
import Brukerprofiler.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileToProduct ftp = new FileToProduct();
            ftp.loadFromCsv("data/products.csv");
            ProductSearch searchEngine = new ProductSearch(ftp.getProducts());

            // Start a tiny HTTP server on localhost:8080
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/search", (HttpExchange exchange) -> {
                String query = exchange.getRequestURI().getQuery(); // e.g. keyword=brød&filters=gluten,laktose
                Map<String, String> params = parseQuery(query);

                String keyword = params.getOrDefault("keyword", "");
                List<String> filters = params.containsKey("filters")
                        ? Arrays.asList(params.get("filters").split(","))
                        : Collections.emptyList();

                ArrayList<Product> results = searchEngine.searchByKeyword(keyword, filters);

                // Convert results to JSON (simple manual version)
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < results.size(); i++) {
                    Product p = results.get(i);
                    json.append("{\"name\":\"").append(p.getName()).append("\"}");
                    if (i < results.size() - 1) json.append(",");
                }
                json.append("]");

                exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, json.toString().getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(json.toString().getBytes());
                }
            });

            server.start();
            System.out.println("Server running at http://localhost:8080/search?keyword=brød&filters=gluten,laktose");

        } catch (IOException e) {
            System.err.println("Kunne ikke lese filen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Map<String, String> parseQuery(String query) {
        Map<String, String> map = new HashMap<>();
        if (query != null) {
            for (String pair : query.split("&")) {
                String[] kv = pair.split("=");
                if (kv.length == 2) map.put(kv[0], kv[1]);
            }
        }
        return map;
    }
}
