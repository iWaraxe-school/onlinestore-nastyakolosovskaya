package by.issoft.store.helpers;

import by.issoft.products.Product;
import com.github.javafaker.Faker;

import java.util.Random;

public class RandomStorePopulator {


    private Faker faker = new Faker();

    public String getProductName(String categoryName){
        switch (categoryName) {
            case "Bike category":
                return faker.superhero().power();
            case "Milk category":
                return faker.programmingLanguage().name();
            case "Phone category":
                return faker.pokemon().name();
            default:
                return "Other categories";
        }
    }

    public Double getProductPrice (){
        return faker.number().randomDouble(2,1,1000);
    }

    public Double getProductRate(){
        return Double.valueOf(faker.number().numberBetween(0,10));
    }
}
