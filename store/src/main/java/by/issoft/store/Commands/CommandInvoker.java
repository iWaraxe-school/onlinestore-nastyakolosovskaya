package by.issoft.store.Commands;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;

public class CommandInvoker {

    private final StoreCommand sortStore;
    private final StoreCommand getTopFive;
    private final StoreCommand fillStore;
    private final StoreCommand printStore;
    private final StoreCommand orderProduct;

    private final StoreCommand exitApp;

    public CommandInvoker(StoreCommand fillStore, StoreCommand sortStore, StoreCommand getTopFive, StoreCommand orderProduct, StoreCommand printStore, StoreCommand exitApp) {
        this.fillStore = fillStore;
        this.sortStore = sortStore;
        this.getTopFive = getTopFive;
        this.orderProduct = orderProduct;
        this.printStore = printStore;
        this.exitApp = exitApp;
    }

    public void fillStore() throws ParserConfigurationException, SQLException {
        fillStore.execute();
    }

    public void SortStore() throws ParserConfigurationException, SQLException {
        sortStore.execute();
    }

    public void TopFive() throws ParserConfigurationException, SQLException {
        getTopFive.execute();
    }

    public void CreateOrder() throws ParserConfigurationException, SQLException {
        orderProduct.execute();
    }

    public void PrintStore() throws ParserConfigurationException, SQLException {
        printStore.execute();
    }

    public void ExitApp() throws ParserConfigurationException, SQLException {
        exitApp.execute();
    }
}