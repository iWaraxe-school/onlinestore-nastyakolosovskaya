package by.issoft.store.Commands;

import by.issoft.store.Store;
import by.issoft.store.helpers.StoreHelper;

public class FillStore implements StoreCommand{
    private final Store store = Store.SingletonEnum.INSTANCE.getValue();
    private final StoreHelper fillStore = new StoreHelper(store);
    @Override
    public void execute() {
        fillStore.fillStore();
    }
}