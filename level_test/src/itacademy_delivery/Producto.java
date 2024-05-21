package itacademy_delivery;

public abstract class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract void mostrarRegalo();
}

class Burrito extends Producto {
    public Burrito() {
        super("Burrito", 6.5);
    }

    @Override
    public void mostrarRegalo() {
        System.out.println("Se le ha regalado un pin.");
    }
}

class Hamburguesa extends Producto {
    public Hamburguesa() {
        super("Hamburguesa", 8.9);
    }

    @Override
    public void mostrarRegalo() {
        System.out.println("Se le ha regalado una gorra.");
    }
}

class Kebab extends Producto {
    public Kebab() {
        super("Kebab", 4.5);
    }

    @Override
    public void mostrarRegalo() {

    }
}

class Pizza extends Producto {
    public Pizza() {
        super("Pizza", 7.9);
    }

    @Override
    public void mostrarRegalo() {

    }
}

