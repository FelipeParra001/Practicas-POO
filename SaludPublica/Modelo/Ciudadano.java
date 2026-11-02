package Modelo;

/**
 * Ciudadano (Persona Independiente). Bono de $160.000.
 * Distribuye en Medicina y/o Canasta Familiar.
 */
public class Ciudadano extends Persona {
    // Atributos
    private Medicina medicina;
    private CanastaFamiliar canasta;

    // Constructor
    public Ciudadano(TipoDocumento tipoDocumento, String numDocumento, String nombre,
                     String apellido, String direccion, String telefono, int edad,
                     String estadoCivil, int estrato, boolean cabezaHogar,
                     Medicina medicina, CanastaFamiliar canasta) {
        super(tipoDocumento, numDocumento, nombre, apellido, direccion, telefono,
              edad, estadoCivil, estrato, cabezaHogar);
        this.medicina = medicina;
        this.canasta = canasta;
        this.bono = new Bono(160000);
    }

    // Métodos
    @Override
    public double getTotalGastado() {
        double total = 0;
        if (medicina != null) total += medicina.getMonto();
        if (canasta != null) total += canasta.getMonto();
        return total;
    }

    @Override
    public String getTipo() {
        return "Ciudadano";
    }

    // Getters y Setters
    public Medicina getMedicina() { return medicina; }
    public void setMedicina(Medicina medicina) { this.medicina = medicina; }

    public CanastaFamiliar getCanasta() { return canasta; }
    public void setCanasta(CanastaFamiliar canasta) { this.canasta = canasta; }

    @Override
    public String toString() {
        return super.toString() +
               "\nMedicina: $" + (medicina != null ? medicina.getMonto() : 0) +
               "\nCanasta Familiar: $" + (canasta != null ? canasta.getMonto() : 0) +
               "\nTotal gastado: $" + getTotalGastado() +
               "\nBono asignado: $" + bono.getMonto();
    }
}
