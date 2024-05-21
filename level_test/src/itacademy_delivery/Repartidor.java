package itacademy_delivery;

public class Repartidor {
    public enum Metodo {
            BICICLETA,
            MOTO,
            A_PIE
    }

    private final String nombre;
    private boolean disponible;
    private final Metodo metodo;

    public Repartidor(String nombre, Metodo metodo) {
        this.nombre = nombre;
        this.metodo = metodo;
        this.disponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public double calcularCostoAdicional() {
        switch (metodo) {
            case BICICLETA:
                return 0.01;
            case MOTO:
                return 0.02;
            default:
                return 0.0;
        }
    }
}
