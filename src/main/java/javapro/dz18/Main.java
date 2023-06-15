import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Book extends Product {
    public Book(String type, double price) {
        super(type, price);
    }
}

class Product {
    private String type;
    private double price;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class ProductDiscount extends Product {
    private double discount;

    public ProductDiscount(String type, double price, double discount) {
        super(type, price);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountedPrice() {
        return getPrice() * (1 - discount);
    }
}

class ProductDiscountDate extends ProductDiscount {
    private LocalDate date;

    public ProductDiscountDate(String type, double price, double discount, LocalDate date) {
        super(type, price, discount);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}

class ProductID extends ProductDiscountDate {
    private String ID;

    public ProductID(String ID, String type, double price, double discount, LocalDate date) {
        super(type, price, discount, date);
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Book("Book 1", 100));
        products.add(new Book("Book 2", 200));
        products.add(new Book("Book 3", 300));
        products.add(new Product("Non-book Product", 400));

        // Завдання 1: Книжка коштує > 250
        List<Product> expensiveBooks = products.stream()
                .filter(p -> p instanceof Book)
                .filter(p -> p.getPrice() > 250)
                .collect(Collectors.toList());
        System.out.println("Завдання 1. Книги які коштують за 250:");
        expensiveBooks.forEach(p -> System.out.println(p.getType() + ", Price: " + p.getPrice()));

        // Завдання 2: Застосувати 10% знижки на книги
        List<Product> discountedBooks = products.stream()
                .filter(p -> p instanceof Book)
                .map(p -> {
                    Book book = (Book) p;
                    return new ProductDiscount(book.getType(), book.getPrice(), 0.1);
                })
                .collect(Collectors.toList());
        System.out.println("Завдання 2. Книги зі знижкою:");
        discountedBooks.forEach(p -> System.out.println(p.getType() + ", Price: " + p.getPrice()));

        // Завдання 3: Знайти найдешевшу книгу
        Product cheapestBook = products.stream()
                .filter(p -> p instanceof Book)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Product [Category: Book] not found"));
        System.out.println("Завдання 3. Найдешевша книга: " + cheapestBook.getType() + ", Price: " + cheapestBook.getPrice());

        // Завдання 4: Отримати три останні додані продукти
        List<Product> latestProducts = products.stream()
                .filter(p -> p instanceof ProductDiscountDate)
                .map(p -> (ProductDiscountDate) p)
                .sorted(Comparator.comparing(ProductDiscountDate::getDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Завдання 4: Три останні додані продукти:");
        latestProducts.forEach(p -> System.out.println(p.getType() + ", Date: " + ((ProductDiscountDate) p).getDate()));

        // Завдання 5: Обчисліть загальну вартість книг, доданих цього року з ціною <= 75
        double totalCost = products.stream()
                .filter(p -> p instanceof Book)
                .filter(p -> p.getPrice() <= 75)
                .filter(p -> p instanceof ProductDiscountDate)
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Завдання 5. Загальна вартість доступних книг цього року: " + totalCost);

        // Завдання 6: Згрупуйте товари за видами
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getType));

        System.out.println("Завдання 6. Згруповані товари за видами:");
        for (String type : groupedProducts.keySet()) {
            List<Product> productList = groupedProducts.get(type);
            System.out.println(type + ":");
            productList.forEach(p -> System.out.println(p.getType() + ", Price: " + p.getPrice()));
        }
    }
}
