package by.issoft.store.Commands;

import by.issoft.store.Store;
import by.issoft.store.helpers.SortHelper;

import javax.xml.parsers.ParserConfigurationException;

public class SortStore implements StoreCommand{

    private final SortHelper sortHelper;
     private Store store;

    public SortStore (SortHelper sortHelper )  {
        this.sortHelper = sortHelper;
    }

    @Override
    public void execute() throws ParserConfigurationException {
        sortHelper.sortByXML(store);
    }
}