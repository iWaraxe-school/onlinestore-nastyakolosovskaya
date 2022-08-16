package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.helpers.SortHelper;
import by.issoft.store.helpers.StoreHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException {

        Store onlineStore = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(onlineStore);
        SortHelper sortHelper = new SortHelper(onlineStore);
        storeHelper.fillStore();
        //onlineStore.printStore();

        Scanner sc = new Scanner(System.in);
        String command;
        while(sc.hasNext()){
            command = sc.nextLine();
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
    }
