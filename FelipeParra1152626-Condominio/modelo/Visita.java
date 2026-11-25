package modelo;

/**
 * Registro de una visita: quien entro, a que unidad, que vigilante la registro y a que hora.
 */
public class Visita
{
    private Visitante visitante;
    private Unidad unidad;
    private Vigilante vigilante;
    private int horaIngreso;
    private int horaSalida;

    public Visita(Visitante visitante, Unidad unidad, Vigilante vigilante, int horaIngreso){
        this.visitante = visitante;
        this.unidad = unidad;
        this.vigilante = vigilante;
        this.horaIngreso = horaIngreso;
        this.horaSalida = -1;
    }

    public boolean estaActiva(){
        return horaSalida == -1;
    }

    public String toString(){
        String texto = visitante.getNombre() + " (C.C. " + visitante.getCedula() + ") visita la unidad " + unidad.getCodigo()
            + " [" + unidad.getCondominio().getNombre() + "] - Ingreso " + horaIngreso + ":00";
        if(estaActiva()){
            texto += " - Aun dentro";
        }else{
            texto += " - Salida " + horaSalida + ":00";
        }
        return texto + " - Registro: " + vigilante.getNombre();
    }

    // ==================== GET Y SET ====================

    public Visitante getVisitante(){
        return this.visitante;
    }

    public Unidad getUnidad(){
        return this.unidad;
    }

    public Vigilante getVigilante(){
        return this.vigilante;
    }

    public int getHoraIngreso(){
        return this.horaIngreso;
    }

    public int getHoraSalida(){
        return this.horaSalida;
    }

    public void setHoraSalida(int horaSalida){
        this.horaSalida = horaSalida;
    }
}//End class
