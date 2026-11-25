package modelo;
import java.util.ArrayList;

/**
 * Propietario de una o varias unidades, incluso en condominios diferentes.
 */
public class Propietario extends Persona
{
    private ArrayList<Unidad> unidades;

    public Propietario(String cedula, String nombre, String telefono){
        super(cedula, nombre, telefono);
        unidades = new ArrayList<>();
    }

    public void agregarUnidad(Unidad unidad){
        unidades.add(unidad);
    }

    public String getRol(){
        return "Propietario";
    }

    public int getNivelAcceso(){
        return 1;
    }

    public String toString(){
        String texto = super.toString() + " - Unidades: ";
        if(unidades.isEmpty()){
            return texto + "ninguna";
        }
        for(int i = 0; i < unidades.size(); i++){
            Unidad u = unidades.get(i);
            texto += u.getCodigo() + " [" + u.getCondominio().getNombre() + "]";
            if(i < unidades.size() - 1){
                texto += ", ";
            }
        }
        return texto;
    }

    // ==================== GET Y SET ====================

    public ArrayList<Unidad> getUnidades(){
        return this.unidades;
    }
}//End class
