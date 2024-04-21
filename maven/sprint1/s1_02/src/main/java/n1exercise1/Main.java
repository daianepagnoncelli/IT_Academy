package n1exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sale sale = new Sale();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add products to your shopping basket");
            System.out.println("2. Calculate the total of added products");
            System.out.println("3. Test ArrayIndexOutOfBoundsException");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product price: ");
                    double productPrice = readDouble(scanner); // Read the double with custom method
                    sale.addProduct(new Product(productName, productPrice));
                    System.out.println("Product added successfully.");
                    break;
                case 2:
                    try {
                        sale.calculateTotal();
                        System.out.println("Total sale price: $" + sale.totalSalePrice);
                    } catch (SaleEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Product product = sale.products.get(sale.products.size());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Array index is out of bounds: " + e.getMessage());
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    // Custom method to read double input allowing both '.' and ',' as decimal separators
    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}





