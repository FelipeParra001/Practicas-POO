package modelo;

/**
 * Reserva de una zona comun hecha por una unidad para una fecha y un rango de horas.
 */
public class Reserva
{
    private int numero;
    private ZonaComun zona;
    private Unidad unidad;
    private String fecha;
    private int horaInicio;
    private int horaFin;
    private int personas;

    public Reserva(int numero, ZonaComun zona, Unidad unidad, String fecha, int horaInicio, int horaFin, int personas){
        this.numero = numero;
        this.zona = zona;
        this.unidad = unidad;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.personas = personas;
    }

    // Dos reservas se cruzan si son de la misma zona, el mismo dia y los horarios se traslapan
    public boolean seCruzaCon(ZonaComun otraZona, String otraFecha, int otraInicio, int otraFin){
        if(zona != otraZona || !fecha.equals(otraFecha)){
            return false;
        }
        return otraInicio < horaFin && horaInicio < otraFin;
    }

    public String toString(){
        return "Reserva #" + numero + " - " + zona.getNombre() + " de " + unidad.getCondominio().getNombre()
            + " - " + fecha + " de " + horaInicio + ":00 a " + horaFin + ":00 - Unidad " + unidad.getCodigo()
            + " - " + personas + " persona(s)";
    }

    // ==================== GET Y SET ====================

    public int getNumero(){
        return this.numero;
    }

    public ZonaComun getZona(){
        return this.zona;
    }

    public Unidad getUnidad(){
        return this.unidad;
    }

    public String getFecha(){
        return this.fecha;
    }

    public int getHoraInicio(){
        return this.horaInicio;
    }

    public int getHoraFin(){
        return this.horaFin;
    }

    public int getPersonas(){
        return this.personas;
    }
}//End class
