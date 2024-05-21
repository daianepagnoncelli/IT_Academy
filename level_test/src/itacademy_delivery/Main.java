package itacademy_delivery;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repartidor repartidor1 = new Repartidor("Juan Sanchez", Repartidor.Metodo.BICICLETA);
        Repartidor repartidor2 = new Repartidor("Ana Gomez", Repartidor.Metodo.MOTO);
        Repartidor repartidor3 = new Repartidor("Pedro Olivera", Repartidor.Metodo.A_PIE);

        List<Repartidor> repartidores = Arrays.asList(repartidor1, repartidor2, repartidor3);
        GestorPedidos gestor = new GestorPedidos(repartidores);

        Cliente cliente1 = new Cliente("Carlos Hernandez ", "Calle dos Naranjos, 123");
        Cliente cliente2 = new Cliente("María Julia Muñoz", "Avenida Independencia, 456");

        Producto burrito = new Burrito();
        Producto hamburguesa = new Hamburguesa();
        Producto kebab = new Kebab();
        Producto pizza = new Pizza();

        try {
            gestor.crearPedido(cliente1, Arrays.asList(burrito, hamburguesa));
            gestor.crearPedido(cliente2, Arrays.asList(kebab, pizza));
            gestor.listarPedidosPendientes();
            gestor.marcarPedidoComoEntregado(1);
            gestor.listarPedidosEntregados();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
