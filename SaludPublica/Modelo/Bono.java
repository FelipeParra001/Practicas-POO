package Modelo;

/**
 * Clase que representa el bono asignado a una persona.
 */
public class Bono {
    // Atributos
    private double monto;

    // Constructor
    public Bono(double monto) {
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
