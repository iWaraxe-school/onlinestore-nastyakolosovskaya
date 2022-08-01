package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.helpers.SortHelper;
import by.issoft.store.helpers.StoreHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException, IOException {

        Store onlineStore = new Store();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        SortHelper sortHelper = new SortHelper(onlineStore);
        storeHelper.fillStore();
        //onlineStore.printStore();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String command = bufferedReader.readLine();

        switch (command) {
            case "sort":
                sortHelper.sortByXML(onlineStore);
                break;
            case "top":
                sortHelper.topFiveExpensiveProducts(onlineStore);
                break;
            case "quit":
                System.exit(0);
            default:
                System.out.println("Command is not supported.");
        }
    }
}