package n1exercise1;

public class Main {
    public static void main(String[] args) {

        Sale sale = new Sale();
        try {
            sale.calculateTotal();
        } catch (SaleEmptyException e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] myArray = {1, 2, 3, 4, 5, 6};
            System.out.println(myArray[8]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e.getMessage());
        }
    }
}
