package by.issoft.store.Commands;

import javax.xml.parsers.ParserConfigurationException;

public class CommandInvoker {

    private final StoreCommand sortStore;
    private final StoreCommand getTopFive;
    private final StoreCommand fillStore;
    private final StoreCommand printStore;

    public CommandInvoker(StoreCommand fillStore, StoreCommand sortStore, StoreCommand getTopFive, StoreCommand printStore) {
        this.fillStore = fillStore;
        this.sortStore = sortStore;
        this.getTopFive = getTopFive;
        this.printStore = printStore;
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
    public void PrintStore() throws ParserConfigurationException {
        printStore.execute();
    }
}