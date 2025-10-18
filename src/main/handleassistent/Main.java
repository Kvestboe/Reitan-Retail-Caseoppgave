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

            // Create a context for /search requests
            server.createContext("/search", (HttpExchange exchange) -> {
                // --- NEW: Handle CORS preflight requests (OPTIONS method) ---
                if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                    // Add CORS headers so the browser knows it’s allowed
                    exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
                    exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                    exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
                    exchange.sendResponseHeaders(204, -1); // No content for OPTIONS
                    exchange.close();
                    return; // Stop here, don’t process further
                }

                // Extract query string from request URL
                String query = exchange.getRequestURI().getQuery(); 
                Map<String, String> params = parseQuery(query);

                // Extract keyword and filters from query parameters
                String keyword = params.getOrDefault("keyword", "");
                List<String> filters = params.containsKey("filters")
                        ? Arrays.asList(params.get("filters").split(","))
                        : Collections.emptyList();

                // Perform search
                ArrayList<Product> results = searchEngine.searchByKeyword(keyword, filters);

                // Convert results to JSON manually
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < results.size(); i++) {
                    Product p = results.get(i);
                    json.append("{\"name\":\"").append(p.getName()).append("\"}");
                    if (i < results.size() - 1) json.append(",");
                }
                json.append("]");

                // --- IMPORTANT: Add CORS headers to every response ---
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
                exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

                // Send JSON response
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

    // Helper method to parse query string into key-value pairs
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
