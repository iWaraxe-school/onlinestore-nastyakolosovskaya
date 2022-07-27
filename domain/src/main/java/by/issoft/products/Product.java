package by.issoft.products;

public class Product {

    private final String name;
    private final double rate;
    private final double price;

    public Product(String name, double price, Double rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product name: , Product price: , Product rate: ", name, rate, price);
    }

    public void getInfo() {
        System.out.println("Product name: " + this.getName() + ", " +
                "Product price: " + this.getPrice() + ", " +
                "Product rate: " + this.getRate());
    }
}
