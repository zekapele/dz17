import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("TV", "Electronics", 900.0),
                new Product("Toaster", "Appliances", 40.0)
        );


        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("продукти за категоріями:");
        groupedByCategory.forEach((k, v) -> System.out.println(k + ": " + v));


        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));
        System.out.println("\nсередня ціна по категоріях:");
        averagePriceByCategory.forEach((k, v) -> System.out.println(k + ": " + v));


        Optional<Map.Entry<String, Double>> maxAvgPriceCategory = averagePriceByCategory.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        System.out.println("\nкатегорія з найвищою середньою ціною:");
        maxAvgPriceCategory.ifPresent(entry ->
                System.out.println(entry.getKey() + " (середня ціна: " + entry.getValue() + ")"));
    }
}
