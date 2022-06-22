package by.issoft.products;

public class Product {

    private final String name;
    private final double rate;
    private final double price;

    public Product(String name, Double rate, double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product name: , Product price: , Product rate: ", name, rate, price);
    }

    public void getInfo(Product product) {
        System.out.println("Product name: " + product.getName() + " " +
                "Product price: " + product.getPrice() + " " +
                "Product rate: " + product.getRate());
    }
}
