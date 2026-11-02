package Modelo;

/**
 * Representa un gasto en elemento de bioseguridad.
 */
public class ElementoBioseguridad {
    // Atributos
    private double monto;

    // Constructor
    public ElementoBioseguridad(double monto) {
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
