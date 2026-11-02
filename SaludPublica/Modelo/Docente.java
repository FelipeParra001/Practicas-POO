package Modelo;

/**
 * Docente. Bono de $100.000.
 * Distribuye en Implementos Tecnológicos y/o Servicio (Internet/Energía).
 */
public class Docente extends Persona {
    // Atributos
    private String institucion;
    private String nivel;
    private ImplementoTecnologico implemento;
    private Servicio servicio;

    // Constructor
    public Docente(TipoDocumento tipoDocumento, String numDocumento, String nombre,
                   String apellido, String direccion, String telefono, int edad,
                   String estadoCivil, int estrato, boolean cabezaHogar,
                   String institucion, String nivel,
                   ImplementoTecnologico implemento, Servicio servicio) {
        super(tipoDocumento, numDocumento, nombre, apellido, direccion, telefono,
              edad, estadoCivil, estrato, cabezaHogar);
        this.institucion = institucion;
        this.nivel = nivel;
        this.implemento = implemento;
        this.servicio = servicio;
        this.bono = new Bono(100000);
    }

    // Métodos
    @Override
    public double getTotalGastado() {
        double total = 0;
        if (implemento != null) total += implemento.getMonto();
        if (servicio != null) total += servicio.getMonto();
        return total;
    }

    @Override
    public String getTipo() {
        return "Docente";
    }

    // Getters y Setters
    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public ImplementoTecnologico getImplemento() { return implemento; }
    public void setImplemento(ImplementoTecnologico implemento) { this.implemento = implemento; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }

    @Override
    public String toString() {
        return super.toString() +
               "\nInstitución: " + institucion +
               "\nNivel: " + nivel +
               "\nImplementos Tecnológicos: $" + (implemento != null ? implemento.getMonto() : 0) +
               "\nServicio Internet/Energía: $" + (servicio != null ? servicio.getMonto() : 0) +
               "\nTotal gastado: $" + getTotalGastado() +
               "\nBono asignado: $" + bono.getMonto();
    }
}
