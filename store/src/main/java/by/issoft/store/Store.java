package by.issoft.store;


import by.issoft.domain.Category;
import by.issoft.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private final List<Category> categoryList = new ArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
    }

        private Store(){}

        private static class SingletonHelper{
            private static final Store STORE_INSTANCE = new Store();
        }

        public static Store getInstance(){
            return SingletonHelper.STORE_INSTANCE;
        }


    /*private static Store StoreObject;

    private Store() {
    }

    public static Store getInstance() {

        // create object if it's not already created
        if(StoreObject == null) {
            StoreObject = new Store();
        }

        // returns the singleton object
        return StoreObject;
    }*/

    public void addCategoryToList(Category category) {
        categoryList.add(category);
    }

    public List<Product> getAllProducts() {
        return categoryList.stream()
                .flatMap(category -> category.getProductList().stream())
                .collect(Collectors.toList());
    }

    public void printStore() {
        System.out.println("---Welcome to Online Store!---");
        for (Category category : categoryList) {
            category.printCategory();
        }
    }
}






