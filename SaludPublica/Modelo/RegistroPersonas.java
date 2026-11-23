package Modelo;

import java.util.ArrayList;

/**
 * Guarda las personas registradas (polimorfismo) y permite buscarlas.
 */
public class RegistroPersonas {
    // Atributos
    private ArrayList<Persona> personas;

    // Constructor
    public RegistroPersonas() {
        personas = new ArrayList<Persona>();
    }

    // Métodos

    // Guarda la persona si la distribución no supera el bono
    public boolean guardar(Persona persona) {
        if (persona == null || !persona.distribucionValida()) {
            return false;
        }
        personas.add(persona);
        return true;
    }

    // Busca una persona por número de documento
    public Persona buscar(String numDocumento) {
        for (Persona p : personas) {
            if (p.getNumDocumento().equals(numDocumento)) {
                return p;
            }
        }
        return null;
    }

    // Indica si ya existe una persona con ese documento
    public boolean existe(String numDocumento) {
        return buscar(numDocumento) != null;
    }

    public int getCantidad() {
        return personas.size();
    }

    // Getters
    public ArrayList<Persona> getPersonas() {
        return personas;
    }
}
