package Proyecto.Modelo;
import java.util.ArrayList;


/**
 * Binomio. Andrés agregó el atributo equipo (bidireccional),
 * verificarCertificacion(), actualizarEstado() e incrementarMisiones().
 */
public class Binomio
{
   
    private boolean estado;
    private int cantidadMisiones;
    private Guia guia;
    private Perro perro;
    private Equipo equipo;
    private ArrayList <Mision> misiones;
    
    public Binomio(){
        
    
    }
    
    public Binomio(boolean estado , int cantidadMisiones, Guia guia , Perro perro ){
        this.estado=estado;
        this.cantidadMisiones=cantidadMisiones;
        this.guia=guia;
        this.perro=perro;
        this.misiones=new ArrayList<>();
    }


//Start GetterSetterExtension Source Code

    /**GET Method Propertie estado*/
    public boolean getEstado(){
        return this.estado;
    }//end method getEstado

    /**SET Method Propertie estado*/
    public void setEstado(boolean estado){
        this.estado = estado;
    }//end method setEstado

    /**GET Method Propertie cantidadMisiones*/
    public int getCantidadMisiones(){
        return this.cantidadMisiones;
    }//end method getCantidadMisiones

    /**SET Method Propertie cantidadMisiones*/
    public void setCantidadMisiones(int cantidadMisiones){
        this.cantidadMisiones = cantidadMisiones;
    }//end method setCantidadMisiones

    /**GET Method Propertie guia*/
    public Guia getGuia(){
        return this.guia;
    }//end method getGuia

    /**SET Method Propertie guia*/
    public void setGuia(Guia guia){
        this.guia = guia;
    }//end method setGuia

    /**GET Method Propertie perro*/
    public Perro getPerro(){
        return this.perro;
    }//end method getPerro

    /**SET Method Propertie perro*/
    public void setPerro(Perro perro){
        this.perro = perro;
    }//end method setPerro

    /**GET Method Propertie equipo*/
    public Equipo getEquipo(){
        return this.equipo;
    }//end method getEquipo

    /**SET Method Propertie equipo*/
    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }//end method setEquipo

    /**GET Method Propertie misiones*/
    public java.util.ArrayList<Proyecto.Modelo.Mision> getMisiones(){
        return this.misiones;
    }//end method getMisiones

    /**SET Method Propertie misiones*/
    public void setMisiones(java.util.ArrayList<Proyecto.Modelo.Mision> misiones){
        this.misiones = misiones;
    }//end method setMisiones

//End GetterSetterExtension Source Code

     
    // METODOS OPERACIONALES (Andrés)

   
    public boolean verificarCertificacion() {
        return guia != null && perro != null && guia.estaVigente() && perro.estaVigente();
    }

 
    public void actualizarEstado() {
        this.estado = verificarCertificacion();
    }

  
    public void incrementarMisiones() {
        this.cantidadMisiones++;
    }
    
    public void agregarMision(Mision m){
        if(m != null){
            misiones.add(m);
            incrementarMisiones();
        }
    }
    
    public boolean estaDisponible(){
        return verificarCertificacion();
    }
    
    public String resumen(){
        String g = (guia != null) ? guia.getNombreCompleto() : "Sin guía";
        String p = (perro != null) ? perro.getNombre() : "Sin perro";
        return g + " + " + p;
    }
    

    public String enlistar() {
    String r = "Guía: " + guia.getNombreCompleto() + " (C.I. " + guia.getCedula() + ")\n"
             + "Perro: " + perro.getNombre() + " (" + perro.getCodigo() + ") - " + perro.getRaza() + "\n"
             + "Equipo: " + (equipo != null ? equipo.getNombre() : "Sin equipo") + "\n"
             + "Misiones realizadas: " + cantidadMisiones + "\n\n";
    return r;
   }
   
     @Override
     public String toString() {
    return "Estado: " + (estado ? "Disponible" : "No disponible") + "\n" +
           "Cantidad Misiones: " + cantidadMisiones + "\n" +
           "Guia: " + (guia != null ? guia.getNombreCompleto() : "Ninguno") + "\n" +
           "Perro: " + (perro != null ? perro.getNombre() : "Ninguno") + "\n" +
           "Equipo: " + (equipo != null ? equipo.getNombre() : "Ninguno");
   }
    
    
    


}//End class
