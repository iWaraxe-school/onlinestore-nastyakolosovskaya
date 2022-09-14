package by.issoft.store.Commands;

import by.issoft.store.Store;
import by.issoft.store.helpers.SortHelper;

public class TopFiveExpensiveProducts implements StoreCommand {

    private final SortHelper topFive;
    private final Store store = Store.SingletonEnum.INSTANCE.getValue();

    public TopFiveExpensiveProducts(SortHelper sortHelper )  {
        this.topFive = sortHelper;
    }

    @Override
    public void execute() {
        topFive.topFiveExpensiveProducts(store);
    }
}