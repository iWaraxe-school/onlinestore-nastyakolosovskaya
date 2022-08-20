package by.issoft.consoleApp;

import by.issoft.store.Commands.*;
import by.issoft.store.Store;
import by.issoft.store.helpers.SortHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException {

        Store onlineStore = Store.getInstance();
        SortHelper sortHelper = new SortHelper(onlineStore);

        StoreCommand fillStore = new FillStore();
        StoreCommand sort = new SortStore(sortHelper);
        StoreCommand topFive = new TopFiveExpensiveProducts(sortHelper);
        StoreCommand printStore = new PrintStore(onlineStore);

        CommandInvoker invoker = new CommandInvoker(fillStore, sort, topFive, printStore );

        invoker.fillStore();
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
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("Command is not supported.");
                }
            }
        }
    }
