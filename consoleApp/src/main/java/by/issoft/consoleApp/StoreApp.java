package by.issoft.consoleApp;

import by.issoft.store.Commands.*;
import by.issoft.store.Store;
import by.issoft.store.helpers.ClearOrder;
import by.issoft.store.helpers.SortHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException {

        Store onlineStore = new Store();
        Store.SingletonEnum singleton = Store.SingletonEnum.INSTANCE;
        singleton.setValue(onlineStore);
        SortHelper sortHelper = new SortHelper(onlineStore);

        StoreCommand fillStore = new FillStore();
        StoreCommand sort = new SortStore(sortHelper);
        StoreCommand topFive = new TopFiveExpensiveProducts(sortHelper);
        StoreCommand orderProduct = new OrderProduct();
        StoreCommand printStore = new PrintStore(onlineStore);
        StoreCommand exitApp = new ExitApp();

        CommandInvoker invoker = new CommandInvoker(fillStore, sort, topFive, orderProduct, printStore, exitApp);

        invoker.fillStore();

        Thread clearOrder = (new Thread(new ClearOrder(), "clearThread"));
        clearOrder.start();

        invoker.PrintStore();

        Scanner sc = new Scanner(System.in);
        String command;
        while(sc.hasNext()){
            command = sc.nextLine();
            switch (command) {
                case "sort":
                    invoker.SortStore();
                    break;
                case "top":
                    invoker.TopFive();
                    break;
                case  "order":
                    invoker.CreateOrder();
                case "quit":
                    invoker.ExitApp();
                default:
                    System.out.println("Command is not supported.");
                }
            }
        }
    }
