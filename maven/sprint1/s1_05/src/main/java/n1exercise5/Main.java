package n1exercise5;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("Smartphone", 499.99);
        SerializationHandler.serializeObject(product, "product.ser");

        Product deserializedProduct = (Product) SerializationHandler.deserializeObject("product.ser");

        if (deserializedProduct != null) {
            System.out.println("Deserialized Product:");
            System.out.println("Name: " + deserializedProduct.getName());
            System.out.println("Price: $" + deserializedProduct.getPrice());
        }
    }
}

