package itacademy_delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorPedidos {
    private final List<Pedido> pedidos;
    private final List<Repartidor> repartidores;

    public GestorPedidos(List<Repartidor> repartidores) {
        this.pedidos = new ArrayList<>();
        this.repartidores = repartidores;
    }

    public void crearPedido(Cliente cliente, List<Producto> productos) {
        Repartidor repartidor = obtenerRepartidorDisponible();
        Pedido pedido = new Pedido(cliente, productos, repartidor);
        repartidor.setDisponible(false);
        pedidos.add(pedido);
        pedido.mostrarDetalles();
    }

    public void marcarPedidoComoEntregado(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id && !pedido.isEntregado()) {
                pedido.marcarComoEntregado();
                System.out.println("Pedido " + id + " marcado como entregado.");
                return;
            }
        }
        System.out.println("Pedido no encontrado o ya entregado.");
    }

    public void listarPedidosPendientes() {
        System.out.println("Pedidos pendientes:");
        pedidos.stream().filter(p -> !p.isEntregado()).forEach(Pedido::mostrarDetalles);
    }

    public void listarPedidosEntregados() {
        System.out.println("Pedidos entregados:");
        pedidos.stream().filter(Pedido::isEntregado).forEach(Pedido::mostrarDetalles);
    }

    private Repartidor obtenerRepartidorDisponible() {
        List<Repartidor> disponibles = new ArrayList<>();
        for (Repartidor repartidor : repartidores) {
            if (repartidor.isDisponible()) {
                disponibles.add(repartidor);
            }
        }
        if (disponibles.isEmpty()) {
            throw new RuntimeException("No hay repartidores disponibles.");
        }
        return disponibles.get(new Random().nextInt(disponibles.size()));
    }
}

