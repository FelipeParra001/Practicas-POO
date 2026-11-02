package Modelo;

/**
 * Profesional de la Salud. Bono de $350.000.
 * Distribuye en Elementos de Bioseguridad y/o Medicina.
 */
public class ProfesionalSalud extends Persona {
    // Atributos
    private String institucion;
    private String especialidad;
    private ElementoBioseguridad elemento;
    private Medicina medicina;

    // Constructor
    public ProfesionalSalud(TipoDocumento tipoDocumento, String numDocumento, String nombre,
                            String apellido, String direccion, String telefono, int edad,
                            String estadoCivil, int estrato, boolean cabezaHogar,
                            String institucion, String especialidad,
                            ElementoBioseguridad elemento, Medicina medicina) {
        super(tipoDocumento, numDocumento, nombre, apellido, direccion, telefono,
              edad, estadoCivil, estrato, cabezaHogar);
        this.institucion = institucion;
        this.especialidad = especialidad;
        this.elemento = elemento;
        this.medicina = medicina;
        this.bono = new Bono(350000);
    }

    // Métodos
    @Override
    public double getTotalGastado() {
        double total = 0;
        if (elemento != null) total += elemento.getMonto();
        if (medicina != null) total += medicina.getMonto();
        return total;
    }

    @Override
    public String getTipo() {
        return "Profesional de Salud";
    }

    // Getters y Setters
    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public ElementoBioseguridad getElemento() { return elemento; }
    public void setElemento(ElementoBioseguridad elemento) { this.elemento = elemento; }

    public Medicina getMedicina() { return medicina; }
    public void setMedicina(Medicina medicina) { this.medicina = medicina; }

    @Override
    public String toString() {
        return super.toString() +
               "\nInstitución: " + institucion +
               "\nEspecialidad: " + especialidad +
               "\nElemento Bioseguridad: $" + (elemento != null ? elemento.getMonto() : 0) +
               "\nMedicina: $" + (medicina != null ? medicina.getMonto() : 0) +
               "\nTotal gastado: $" + getTotalGastado() +
               "\nBono asignado: $" + bono.getMonto();
    }
}
