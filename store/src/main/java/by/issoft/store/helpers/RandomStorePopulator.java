package by.issoft.store.helpers;

import by.issoft.products.Product;
import com.github.javafaker.Faker;

import java.util.Random;

public class RandomStorePopulator {


    private Faker faker = new Faker();

    public String getProductName(String categoryName){
        switch (categoryName) {
            case "BikeCategory":
                return faker.superhero().power();
            case "MilkCategory":
                return faker.food().ingredient();
            case "PhoneCategory":
                return faker.pokemon().name();
            default:
                return "Unknown category";
        }
    }

    public Double getProductPrice (){
        return faker.number().randomDouble(2,1,1000);

    }

    public Double getProductRate(){
        return Double.valueOf(faker.number().numberBetween(0,10));
    }
}
