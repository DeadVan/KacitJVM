import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int Id;
    private String name;
    private double price;
    private String description;

    public Product(int id, String name, double price) {
        Id = id;
        this.name = name;
        this.price = price;
    }


}
