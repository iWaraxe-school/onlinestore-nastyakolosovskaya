package by.issoft.store.helpers;

import by.issoft.products.Product;
import by.issoft.store.Store;
import by.issoft.store.helpers.comparators.ProductNameComparator;
import by.issoft.store.helpers.comparators.ProductPriceComparator;
import by.issoft.store.helpers.comparators.ProductRateCompatator;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.util.Map;

public class SortHelper {

    Store store;


    public SortHelper(Store store) {
        this.store = store;
    }

    public List<Product> sortedProductList (Map<String, String> configMap ){
        List <Product> allProductList = store.getAllProducts();
        int i = 1;
        for (Map.Entry<String, String> entry : configMap.entrySet()){
            switch (entry.getKey()){
                case "name":
                    if (entry.getValue().equals("ASC")){
                        allProductList.sort(new ProductNameComparator());
                        System.out.println(i + "name:" + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }else{
                        allProductList.sort(new ProductNameComparator().reversed());
                        System.out.println(i + "name:" + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }
                i++;
                break;

                case "price":
                    if (entry.getValue().equals("ASC")){
                        allProductList.sort(new ProductPriceComparator());
                        System.out.println(i + "price:" + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }else{
                        allProductList.sort(new ProductPriceComparator().reversed());
                        System.out.println(i + "price:" + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }
                    i++;
                    break;

                case "rate":
                    if (entry.getValue().equals("ASC")){
                        allProductList.sort(new ProductRateCompatator());
                        System.out.println(i + "rate:" + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }else{
                        allProductList.sort(new ProductRateCompatator().reversed());
                        System.out.println(i + "rate:" + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }
                    i++;
                    break;
                }
            }
        return  allProductList;
        }

        public void sortXML (Store store) throws ParserConfigurationException {
        XmlParser parser = new XmlParser();
        Map <String, String > configMap = parser.xmlParser();
            System.out.println(configMap);
            List<Product> productsSortedByXML = sortedProductList(configMap);
            System.out.println("Sorted Products: ");
            for (Product product: productsSortedByXML){
                System.out.println(product);
            }
        }
    }
