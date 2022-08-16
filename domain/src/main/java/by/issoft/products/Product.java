package by.issoft.products;

public class Product {

    private String name;
    private double rate;
    private double price;

    public static ProductBuilder newProductBuilder() {
        return new Product().new ProductBuilder();
    }

    public class ProductBuilder {
        private String name;
        private double rate;
        private double price;

        private ProductBuilder() {
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }
        public ProductBuilder setRate(double rate) {
            this.rate = rate;
            return this;
        }
        public Product build() {
            Product.this.name = this.name;
            Product.this.price = this.price;
            Product.this.rate = this.rate;
            return Product.this;
        }
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
        return String.format("Product name: '%s', Product price: '%s', Product rate: '%s'", name, price, rate);
    }

    public void getInfo() {
        System.out.println("Product name: " + this.getName() + ", " +
                "Product price: " + this.getPrice() + ", " +
                "Product rate: " + this.getRate());
    }
}
