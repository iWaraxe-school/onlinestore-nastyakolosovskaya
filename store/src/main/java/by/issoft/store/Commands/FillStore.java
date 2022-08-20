package by.issoft.store.Commands;

import by.issoft.store.Store;
import by.issoft.store.helpers.StoreHelper;

public class FillStore implements StoreCommand{

    private final Store store = Store.getInstance();
    private final StoreHelper fillStore = new StoreHelper(store);
    @Override
    public void execute() {
        fillStore.fillStore();
    }
}