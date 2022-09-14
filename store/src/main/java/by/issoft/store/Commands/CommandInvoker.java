package by.issoft.store.Commands;

import javax.xml.parsers.ParserConfigurationException;

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
    public void fillStore () throws ParserConfigurationException {
        fillStore.execute();
    }
    public void SortStore () throws ParserConfigurationException {
        sortStore.execute();
    }
    public void TopFive() throws ParserConfigurationException {
        getTopFive.execute();
    }

    public void CreateOrder() throws ParserConfigurationException {
        orderProduct.execute();
    }
    public void PrintStore() throws ParserConfigurationException {
        printStore.execute();
    }

    public void ExitApp() throws ParserConfigurationException {
        exitApp.execute();
    }
}