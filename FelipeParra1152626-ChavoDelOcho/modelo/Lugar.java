package modelo;
import java.util.ArrayList;

public class Lugar
{
    private String nombre;
    private String descripcion;
    private ArrayList<ObjetoInteractivo> objetos;

    public Lugar(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetos = new ArrayList<>();
    }

    public boolean agregarObjeto(ObjetoInteractivo objeto){
        if(objeto == null || buscarObjeto(objeto.getNombre()) != null){
            return false;
        }
        objetos.add(objeto);
        return true;
    }

    public ObjetoInteractivo buscarObjeto(String nombre){
        for(ObjetoInteractivo o : objetos){
            if(o.getNombre().equalsIgnoreCase(nombre)){
                return o;
            }
        }
        return null;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public ArrayList<ObjetoInteractivo> getObjetos(){
        return this.objetos;
    }
}//End class
