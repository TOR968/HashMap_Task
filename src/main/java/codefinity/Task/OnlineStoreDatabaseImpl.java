package codefinity.Task;

import codefinity.model.Customer;
import codefinity.model.Product;

import java.util.HashMap;
import java.util.Map;

public class OnlineStoreDatabaseImpl implements OnlineStoreDatabase {

    private Map<Integer, Product> products;
    private Map<Integer, Customer> customers;

    public OnlineStoreDatabaseImpl() {
        this.products = new HashMap<>();
        this.customers = new HashMap<>();
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(int productId, double newPrice, int newQuantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
        }
    }

    @Override
    public void removeProduct(int productId) {
        products.remove(productId);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void updateCustomer(int customerId, String newAddress) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            customer.setAddress(newAddress);
        }
    }

    @Override
    public void removeCustomer(int customerId) {
        customers.remove(customerId);
    }

    @Override
    public void placeOrder(int customerId, int productId, int quantity) {
        Customer customer = customers.get(customerId);
        Product product = products.get(productId);

        if (customer != null && product != null && product.getQuantity() >= quantity) {
            // Place the order: reduce the quantity of the product and perform other operations
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Failed to place the order. Check the data.");
        }
    }

    @Override
    public void displayAllProducts() {
        System.out.println("List of products:");
        for (Product product : products.values()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
    }

    @Override
    public void displayAllCustomers() {
        System.out.println("List of customers:");
        for (Customer customer : customers.values()) {
            System.out.println(customer.getId() + ": " + customer.getName() + " - " + customer.getAddress());
        }
    }
}
