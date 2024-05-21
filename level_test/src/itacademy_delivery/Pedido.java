package itacademy_delivery;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger; //ID autoincremental

public class Pedido {
    private static final AtomicInteger contador = new AtomicInteger(0);

    private final int id;
    private final Cliente cliente;
    private final List<Producto> productos;
    private final Repartidor repartidor;
    private boolean entregado;

    public Pedido(Cliente cliente, List<Producto> productos, Repartidor repartidor) {
        if (cliente == null || productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener un cliente y al menos un producto.");
        }
        this.id = contador.incrementAndGet();
        this.cliente = cliente;
        this.productos = productos;
        this.repartidor = repartidor;
        this.entregado = false;
    }

    public int getId() {
        return id;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void marcarComoEntregado() {
        this.entregado = true;
        this.repartidor.setDisponible(true);
    }

    public double calcularTotal() {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        double costoAdicional = total * repartidor.calcularCostoAdicional();
        return total + costoAdicional;
    }

    public void mostrarDetalles() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Cliente: " + cliente.getNombre() );
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Repartidor: " + repartidor.getNombre() + " (" + repartidor.getMetodo() + ")");
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + ": " + producto.getPrecio() + "€");
            producto.mostrarRegalo();
        }
        System.out.println("Total: " + calcularTotal() + "€");
        System.out.println("*******************************");
    }
}

