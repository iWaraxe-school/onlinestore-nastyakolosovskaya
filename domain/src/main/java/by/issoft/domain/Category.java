package by.issoft.domain;

import by.issoft.products.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Category {

    private final String categoryName;
    private final List<Product> productList = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    private List<Category> categoryList = new ArrayList<>();

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductToCategory(Product product){
        productList.add(product);
    }
    public void printCategory(){
        System.out.println();
        System.out.println(categoryName + ":");
        for (Product product: productList) {
            product.getInfo();
        }
            productList.sort(Comparator.comparing(Product::getRate));

    }
}
