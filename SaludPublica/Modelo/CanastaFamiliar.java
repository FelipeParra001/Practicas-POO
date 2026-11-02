package Modelo;

/**
 * Representa un gasto en canasta familiar.
 */
public class CanastaFamiliar {
    // Atributos
    private double monto;

    // Constructor
    public CanastaFamiliar(double monto) {
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
