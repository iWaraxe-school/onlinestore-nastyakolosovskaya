package by.issoft.store.helpers.HTTPHelpers;

import by.issoft.domain.Category;
import by.issoft.store.Store;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class HttpCategoryHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
        Store store = Store.getInstance();
        List<Category> categories = store.getCategoryList();
            Gson gson = new Gson();
            gson.toJson(categories);
        httpExchange.sendResponseHeaders(200,gson.toJson(categories).length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(gson.toJson(categories).getBytes());
        os.close();
    }
}
