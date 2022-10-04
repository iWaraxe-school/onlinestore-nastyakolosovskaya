package by.issoft.consoleApp;

import by.issoft.store.Commands.*;
import by.issoft.store.Store;
import by.issoft.store.helpers.ClearOrder;
import by.issoft.store.helpers.DBHelper;
import by.issoft.store.helpers.SortHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException, SQLException {

        Store onlineStore = Store.getInstance();
        SortHelper sortHelper = new SortHelper(onlineStore);
        DBHelper dbHelper = new DBHelper(onlineStore);

        StoreCommand fillStore = new FillStore();
        StoreCommand sort = new SortStore(sortHelper);
        StoreCommand topFive = new TopFiveExpensiveProducts(sortHelper);
        StoreCommand orderProduct = new OrderProduct();
        StoreCommand printStore = new PrintStore(dbHelper);
        StoreCommand exitApp = new ExitApp();

        CommandInvoker invoker = new CommandInvoker(fillStore, sort, topFive, orderProduct, printStore, exitApp);

        invoker.fillStore();

        dbHelper.connectDB();
        dbHelper.clearDB();
        dbHelper.createCategoryTable();
        dbHelper.createProductTable();
        dbHelper.putDataToDB();

        Timer timer = new Timer();
        timer.schedule(new ClearOrder(),0,120_000);

        invoker.PrintStore();

        Scanner sc = new Scanner(System.in);
        String command;
        while(sc.hasNext() ){
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
                    break;
                case "quit":
                    invoker.ExitApp();
                    break;
                default:
                    System.out.println("Command is not supported.");
                }
            }
        }
    }
