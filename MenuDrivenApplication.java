import java.text.SimpleDateFormat;
import java.util.*;

class Customer {
    private String id;
    private String name;
    private int loyaltyPoints;

    public Customer(String id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer [ID=" + id + ", Name=" + name + ", Loyalty Points=" + loyaltyPoints + "]";
    }
}

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Price=" + price + "]";
    }
}

class Order {
    private String id;
    private String customerId;
    private String productId;
    private Date deliveryDate;

    public Order(String id, String customerId, String productId, Date deliveryDate) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.deliveryDate = deliveryDate;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Order [ID=" + id + ", CustomerID=" + customerId + ", ProductID=" + productId + ", DeliveryDate=" + deliveryDate + "]";
    }
}


class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

class CustomerLoyaltyComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints()); // Descending order
    }
}

public class MenuDrivenApplication {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static HashMap<String, Customer> customerMap = new HashMap<>();
    private static HashMap<String, Product> productMap = new HashMap<>();
    private static HashSet<String> uniqueProducts = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Place Order");
            System.out.println("4. Display Customers");
            System.out.println("5. Display Products (Sorted by Price)");
            System.out.println("6. Display Orders");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    placeOrder(scanner);
                    break;
                case 4:
                    displayCustomers();
                    break;
                case 5:
                    displayProductsSortedByPrice();
                    break;
                case 6:
                    displayOrders();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.next();
        System.out.print("Enter Customer Name: ");
        String name = scanner.next();
        System.out.print("Enter Loyalty Points: ");
        int points = scanner.nextInt();

        Customer customer = new Customer(id, name, points);
        customers.add(customer);
        customerMap.put(id, customer);
        System.out.println("Customer added successfully.");
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        String id = scanner.next();
        System.out.print("Enter Product Name: ");
        String name = scanner.next();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, price);
        products.add(product);
        productMap.put(id, product);
        System.out.println("Product added successfully.");
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        String orderId = scanner.next();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.next();
        System.out.print("Enter Product ID: ");
        String productId = scanner.next();
        System.out.print("Enter Delivery Date (yyyy-mm-dd): ");
        String dateStr = scanner.next();

        try {
            Date deliveryDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            Order order = new Order(orderId, customerId, productId, deliveryDate);
            orders.add(order);
            uniqueProducts.add(productId);
            System.out.println("Order placed successfully.");
        } catch (Exception e) {
            System.out.println("Invalid date format. Order not placed.");
        }
    }

    private static void displayCustomers() {
        TreeSet<Customer> sortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());
        sortedCustomers.addAll(customers);
        sortedCustomers.forEach(System.out::println);
    }

    private static void displayProductsSortedByPrice() {
        TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());
        sortedProducts.addAll(products);
        sortedProducts.forEach(System.out::println);
    }

    private static void displayOrders() {
        orders.forEach(System.out::println);
    }
}
