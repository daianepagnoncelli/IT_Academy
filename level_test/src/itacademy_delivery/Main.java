package itacademy_delivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Repartidor repartidor1 = new Repartidor("Juan Pedro", Repartidor.Metodo.BICICLETA);
        Repartidor repartidor2 = new Repartidor("Ana Sanchez", Repartidor.Metodo.MOTO);
        Repartidor repartidor3 = new Repartidor("Pedro Paulo", Repartidor.Metodo.A_PIE);

        List<Repartidor> repartidores = Arrays.asList(repartidor1, repartidor2, repartidor3);
        GestorPedidos gestor = new GestorPedidos(repartidores);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Crear un nuevo pedido");
            System.out.println("2. Marcar un pedido como entregado");
            System.out.println("3. Listar pedidos pendientes");
            System.out.println("4. Listar pedidos entregados");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion = -1;
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearNuevoPedido(gestor, scanner);
                    break;
                case 2:
                    marcarPedidoComoEntregado(gestor, scanner);
                    break;
                case 3:
                    gestor.listarPedidosPendientes();
                    break;
                case 4:
                    gestor.listarPedidosEntregados();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearNuevoPedido(GestorPedidos gestor, Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine().trim();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccionCliente = scanner.nextLine().trim();

        if (nombreCliente.isEmpty() || direccionCliente.isEmpty()) {
            System.out.println("El nombre y la dirección del cliente no pueden estar vacíos.");
            return;
        }

        Cliente cliente = new Cliente(nombreCliente, direccionCliente);

        List<Producto> productos = new ArrayList<>();
        boolean agregarMasProductos = true;

        while (agregarMasProductos) {
            System.out.println("\nSeleccione un producto para agregar al pedido:");
            System.out.println("1. Burrito - 6.5€");
            System.out.println("2. Hamburguesa - 8.9€");
            System.out.println("3. Kebab - 4.5€");
            System.out.println("4. Pizza - 7.9€");
            System.out.print("Ingrese el número del producto: ");

            int productoOpcion = -1;
            try {
                productoOpcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                continue;
            }

            Producto producto = null;
            switch (productoOpcion) {
                case 1:
                    producto = new Burrito();
                    break;
                case 2:
                    producto = new Hamburguesa();
                    break;
                case 3:
                    producto = new Kebab();
                    break;
                case 4:
                    producto = new Pizza();
                    break;
                default:
                    System.out.println("Opción de producto no válida.");
                    continue;
            }

            productos.add(producto);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine();
            agregarMasProductos = respuesta.equalsIgnoreCase("s");
        }

        try {
            gestor.crearPedido(cliente, productos);
        } catch (Exception e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    private static void marcarPedidoComoEntregado(GestorPedidos gestor, Scanner scanner) {
        System.out.print("Ingrese el ID del pedido a marcar como entregado: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        try {
            gestor.marcarPedidoComoEntregado(idPedido);
        } catch (Exception e) {
            System.out.println("Error al marcar el pedido como entregado: " + e.getMessage());
        }
    }
}

