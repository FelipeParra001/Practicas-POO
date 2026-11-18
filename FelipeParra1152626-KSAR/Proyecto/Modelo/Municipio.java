package Proyecto.Modelo;
import java.util.ArrayList;


/**
 * Write a description of class Municipio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Municipio
{
    private String nombre;
    private Pais pais;
    private ArrayList <Lugar> lugares;
    
    public Municipio(){
        this.lugares=new ArrayList<>();
    }
    
    public Municipio(String nombre){
        this.nombre=nombre;
        this.lugares=new ArrayList<>();
    }
    
     public Municipio(String nombre, Pais pais){
        this.nombre=nombre;
        this.pais=pais;
        this.lugares=new ArrayList<>();
    }
    
    

//Start GetterSetterExtension Source Code

   /**GET Method Propertie nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**SET Method Propertie nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**GET Method Propertie pais*/
    public Pais getPais(){
        return this.pais;
    }//end method getPais

    /**SET Method Propertie pais*/
    public void setPais(Pais pais){
        this.pais = pais;
    }//end method setPais

    /**GET Method Propertie lugares*/
    public java.util.ArrayList<Proyecto.Modelo.Lugar> getLugares(){
        return this.lugares;
    }//end method getLugares

    /**SET Method Propertie lugares*/
    public void setLugares(java.util.ArrayList<Proyecto.Modelo.Lugar> lugares){
        this.lugares = lugares;
    }//end method setLugares
    
    
//End GetterSetterExtension Source Code


    // METODOS OPERACIONALES
    
    public Lugar buscarLugar(String nombreLugar){
        for(Lugar l : lugares){
            if(l.getNombre().equalsIgnoreCase(nombreLugar)){
                return l;
            }
        }
        return null;
    }
    
    public boolean agregarLugar(Lugar l){
        if(l == null || buscarLugar(l.getNombre()) != null){
            return false;
        }
        lugares.add(l);
        return true;
    }
    
     public String obtenerDescripcion(){
        return nombre + (pais != null ? " - " + pais.getNombre() : "");
    }
    
    
    
    @Override
    public String toString() {
    return "Municipio: " + nombre + "\n" +
           "País: " + (pais != null ? pais.getNombre() : "Ninguno") + "\n" +
           "Lugares: " + lugares.size();
   }
}//End class
