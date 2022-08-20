package by.issoft.store.Commands;

import by.issoft.store.Store;

public class PrintStore implements StoreCommand {
    private final Store store;

    public PrintStore(Store store) {
        this.store = store;
    }
    @Override
    public void execute() {
        store.printStore();
    }
}