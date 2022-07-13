package by.issoft.store.helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class XmlParser {

         public Map<String, String> xmlParser() {
        XmlParser xmlParser = new XmlParser();
        try {
            FileInputStream file = new FileInputStream("store/src/main/resources/config.xml");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            Node rootElement = doc.getDocumentElement();

            Map<String, String> configMap = new HashMap<>();
            NodeList nodeList = doc.getElementsByTagName("sort");

            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Sort name by: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Sort price by: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Sort rate by: " + eElement.getElementsByTagName("rate").item(0).getTextContent());

                    String sortField = eElement.getTagName();
                    String sortBy = eElement.getTextContent();
                    configMap.put(sortField, sortBy);
                }
                return configMap;
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
             return null;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue( Map<K, V> map )
    {
        Map<K,V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K,V>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e ->result.put(e.getKey(),e.getValue()));

        return result;
    }
}






