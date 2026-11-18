package Proyecto.Modelo;
import java.util.ArrayList;


/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo
{
     
    private String nombre;
    private Fecha fechaCreacion;
    private ArrayList <Binomio> binomios;
    private ArrayList <Mision> misiones ;

   public Equipo(){
       
   }
   
   public Equipo(String nombre, Fecha fechaCreacion){
    this.nombre = nombre;
    this.fechaCreacion = fechaCreacion;
    this.binomios = new ArrayList<>();
    this.misiones = new ArrayList<>();

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

    /**GET Method Propertie fechaCreacion*/
    public Fecha getFechaCreacion(){
        return this.fechaCreacion;
    }//end method getFechaCreacion

    /**SET Method Propertie fechaCreacion*/
    public void setFechaCreacion(Fecha fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }//end method setFechaCreacion

    /**GET Method Propertie binomios*/
    public java.util.ArrayList<Proyecto.Modelo.Binomio> getBinomios(){
        return this.binomios;
    }//end method getBinomios

    /**SET Method Propertie binomios*/
    public void setBinomios(java.util.ArrayList<Proyecto.Modelo.Binomio> binomios){
        this.binomios = binomios;
    }//end method setBinomios

    /**GET Method Propertie misiones*/
    public java.util.ArrayList<Proyecto.Modelo.Mision> getMisiones(){
        return this.misiones;
    }//end method getMisiones

    /**SET Method Propertie misiones*/
    public void setMisiones(java.util.ArrayList<Proyecto.Modelo.Mision> misiones){
        this.misiones = misiones;
    }//end method setMisiones

//End GetterSetterExtension Source Code
   // METODOS OPERACIONALES 
   
     public boolean agregarBinomio(Binomio b){
        if(b == null || binomios.contains(b)){
            return false;
        }
        binomios.add(b);
        b.setEquipo(this);
        return true;
    }
    
    public boolean agregarMision(Mision m){
        if(m == null || misiones.contains(m)){
            return false;
        }
        misiones.add(m);
        return true;
    }
    
    public ArrayList<Binomio> listarBinomiosDisponibles(){
        ArrayList<Binomio> disponibles = new ArrayList<>();
        for(Binomio b : binomios){
            if(b.estaDisponible()){
                disponibles.add(b);
            }
        }
        return disponibles;
    }
    
    
   

     @Override
     public String toString() {
    return "Nombre: " + nombre + "\n" +
           "Fecha Creación: " + fechaCreacion + "\n" +
           "Binomios: " + binomios.size() + "\n" +
           "Misiones: " + misiones.size();
  }

}//End class
