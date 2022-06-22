package by.issoft.domain;

import by.issoft.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {

    final String categoryName;
    private List<Product> productList = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    private List<Category> categoryList = new ArrayList<Category>();

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;

    }

    public void addProductToCategory(Product product){
        productList.add(product);
    }
    public void printCategory(Category categoryName){
        System.out.println(categoryName);
    }
}
