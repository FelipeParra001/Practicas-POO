package modelo;

/**
 * Persona externa que ingresa al condominio a visitar una unidad.
 */
public class Visitante extends Persona
{
    private boolean dentro;
    private int numeroVisitas;

    public Visitante(String cedula, String nombre, String telefono){
        super(cedula, nombre, telefono);
        this.dentro = false;
        this.numeroVisitas = 0;
    }

    public void entrar(){
        dentro = true;
        numeroVisitas++;
    }

    public void salir(){
        dentro = false;
    }

    public String getRol(){
        return "Visitante";
    }

    public int getNivelAcceso(){
        return 0;
    }

    public String toString(){
        return super.toString() + " - Visitas: " + numeroVisitas + (dentro ? " (dentro)" : "");
    }

    // ==================== GET Y SET ====================

    public boolean isDentro(){
        return this.dentro;
    }

    public int getNumeroVisitas(){
        return this.numeroVisitas;
    }
}//End class
