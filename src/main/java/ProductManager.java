import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductManager {

    public static List<Product> getProducts(){
        Product product1 = new Product(1,"vashli",123.3,"food");
        Product product2 = new Product(2,"atami",43.1,"food");
        Product product3 = new Product(3,"marwyvi",7.1,"food");
        Product product4 = new Product(4,"banani",3.4);
        Product product5 = new Product(5,"teleponi",58.1,"technic");
        List<Product> products = Arrays.asList(product1,product2,product3,product4,product5);
        return products;
    }

    public static void main(String[] args) {
        List<Product> filteredProducts = getProducts().stream()
                .map(product -> new Product(product.getId(), product.getName(), product.getPrice() * 2, product.getDescription()))
                .filter(product -> product.getPrice() > 10 && product.getDescription() != null)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());


        Map<String, List<Product>> productsByName = getProducts().stream()
                .collect(Collectors.groupingBy(Product::getName));

        Map<Integer, Double> idToPriceMap = getProducts().stream()
                .collect(Collectors.toMap(Product::getId, Product::getPrice));

        System.out.println(filteredProducts);

        System.out.println(productsByName);

        idToPriceMap.forEach((id, price) -> System.out.println("ID: " + id + ", Price: " + price));

    }
}
