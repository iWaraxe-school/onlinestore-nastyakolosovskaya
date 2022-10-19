package by.issoft.store.helpers.HTTPHelpers;

import com.sun.net.httpserver.HttpContext;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServer {

    private com.sun.net.httpserver.HttpServer httpServer;
    public static final String REALM = "store_realm";

    public void createHttpServer() {
        try {
            //Create HttpServer which is listening on the given port
            httpServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8082), 0);
            //Create a new context for the given context and handler
            HttpContext categoryHandler = httpServer.createContext("/categories", new HttpCategoryHandler());
            HttpContext cartHandler = httpServer.createContext("/cart", new HttpCartHandler());
            categoryHandler.setAuthenticator(new HttpAuthenticator(REALM));
            cartHandler.setAuthenticator(new HttpAuthenticator(REALM));
            //Create a default executor
            httpServer.setExecutor(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        this.httpServer.start();
    }
}
