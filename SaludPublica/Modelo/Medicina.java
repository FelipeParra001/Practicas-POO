package Modelo;

/**
 * Representa un gasto en medicina.
 */
public class Medicina {
    // Atributos
    private double monto;

    // Constructor
    public Medicina(double monto) {
        this.monto = monto;
    }

    // Getters y Setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
