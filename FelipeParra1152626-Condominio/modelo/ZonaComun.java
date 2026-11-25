package modelo;

/**
 * Zona comun de un condominio que se puede reservar.
 * Cada tipo de zona tiene su capacidad y su horario.
 */
public abstract class ZonaComun
{
    private int capacidad;
    private int horaApertura;
    private int horaCierre;

    public ZonaComun(int capacidad, int horaApertura, int horaCierre){
        this.capacidad = capacidad;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public abstract String getNombre();

    // Indica si el rango de horas esta dentro del horario de la zona
    public boolean estaEnHorario(int horaInicio, int horaFin){
        return horaInicio >= horaApertura && horaFin <= horaCierre && horaInicio < horaFin;
    }

    public String toString(){
        return getNombre() + " (capacidad " + capacidad + ", de " + horaApertura + ":00 a " + horaCierre + ":00)";
    }

    // ==================== GET Y SET ====================

    public int getCapacidad(){
        return this.capacidad;
    }

    public int getHoraApertura(){
        return this.horaApertura;
    }

    public int getHoraCierre(){
        return this.horaCierre;
    }
}//End class
