package Modelo;

/**
 * Representa un gasto en servicio (internet o energía).
 */
public class Servicio {
    // Atributos
    private double monto;

    // Constructor
    public Servicio(double monto) {
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
