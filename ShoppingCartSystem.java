/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoppingcartsystem;

import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return id + " - " + name + " - Rs." + price;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        List<Product> cart = new ArrayList<>();
        Set<Integer> productIds = new HashSet<>();
        Map<Integer, Product> products = new HashMap<>();
        products.put(101, new Product(101, "Laptop", 45000));
        products.put(102, new Product(102, "Mouse", 500));
        products.put(103, new Product(103, "Keyboard", 1000));

        int choice;

        do {
            System.out.println("\n--- ONLINE SHOPPING CART ---");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : products.values()) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    if (products.containsKey(id)) {
                        if (productIds.add(id)) {
                            cart.add(products.get(id));
                            System.out.println(
                                "Product added successfully!"
                            );
                        } 
                        else {
                            System.out.println("Product is already in the cart.");
                        }
                    } 
                    else {System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    double total = 0;
                    System.out.println("\nYour Shopping Cart:");

                    for (Product p : cart) {
                        System.out.println(p);
                        total += p.price;
                    }

                    System.out.println("Total Amount: Rs." + total);
                    break;

                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();

                    if (productIds.remove(removeId)) {
                        cart.removeIf(p -> p.id == removeId);
                        System.out.println(
                            "Product removed successfully!"
                        );
                    } 
                    else {
                        System.out.println(
                            "Product is not in the cart."
                        );
                    }
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } 
        while (choice != 5);
        sc.close();
    }
}
