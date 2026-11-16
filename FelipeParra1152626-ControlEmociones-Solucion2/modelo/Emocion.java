package modelo;
import java.util.ArrayList;


public class Emocion
{
    private String nombre; 
    private int intensidad ;// 1 a 10;
    private String tipo ; // positivo o negativo
    private String accion ;
    private String estado ;
    
    public Emocion(String nombre,int intensidad, String tipo,String accion, String estado){
        this.nombre = nombre ;
        this.intensidad = intensidad;
        this.tipo = tipo ;
        this.accion = accion;
        this.estado = estado;
           
    }
       public String toString(){
           return nombre; 
       }
         
       public void sumarIntensidad(int i){
           intensidad += i; 
           if(intensidad > 10){
               intensidad = 10;
           }
       }
       public void restarIntensidad(int i){
           intensidad -= i; 
           if(intensidad < 1){
               intensidad = 1;
           }
       }
    /*public String enlistar(){
        String nombre = "Nombre: " + nombre + "\n" ; 
        return nombre;
     }*/
    /**GET Method Propertie accion*/
    public String getAccion(){
        return this.accion;
    }

    /**SET Method Propertie accion*/
    public void setAccion(String accion){
        this.accion = accion;
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

    /**GET Method Propertie intensidad*/
    public int getIntensidad(){
        return this.intensidad;
    }//end method getIntensidad

    /**SET Method Propertie intensidad*/
    public void setIntensidad(int intensidad){
        this.intensidad = intensidad;
    }//end method setIntensidad

    /**GET Method Propertie tipo*/
    public String getTipo(){
        return this.tipo;
    }//end method getTipo

    /**SET Method Propertie tipo*/
    public void setTipo(String tipo){
        this.tipo = tipo;
    }//end method setTipo


    /**GET Method Propertie estado*/
    public String getEstado(){
        return this.estado;
    }//end method getEstado

    /**SET Method Propertie estado*/
    public void setEstado(String estado){
        this.estado = estado;
    }//end method setEstado

//End GetterSetterExtension Source Code


}//End class