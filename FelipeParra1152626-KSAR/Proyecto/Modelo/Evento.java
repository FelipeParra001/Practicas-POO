package Proyecto.Modelo;


/**
 * Write a description of class Evento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Evento
{
    protected String descripcion ;
    protected Fecha fecha;
    protected Lugar lugar;
    protected Mision mision;
    
    
      public Evento(){
        
    }
    
    
    public Evento(String descripcion , Fecha fecha , Lugar lugar){
       this.descripcion=descripcion;
       this.fecha=fecha;
       this.lugar=lugar;
    }
//Start GetterSetterExtension Source Code

   /**GET Method Propertie descripcion*/
    public String getDescripcion(){
        return this.descripcion;
    }//end method getDescripcion

    /**SET Method Propertie descripcion*/
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }//end method setDescripcion

    /**GET Method Propertie fecha*/
    public Fecha getFecha(){
        return this.fecha;
    }//end method getFecha

    /**SET Method Propertie fecha*/
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }//end method setFecha

    /**GET Method Propertie lugar*/
    public Lugar getLugar(){
        return this.lugar;
    }//end method getLugar

    /**SET Method Propertie lugar*/
    public void setLugar(Lugar lugar){
        this.lugar = lugar;
    }//end method setLugar

    /**GET Method Propertie mision*/
    public Mision getMision(){
        return this.mision;
    }//end method getMision

    /**SET Method Propertie mision*/
    public void setMision(Mision mision){
        this.mision = mision;
    }//end method setMision


//End GetterSetterExtension Source Code
    
    //METODOS OPERACIONALES
    
    public boolean tieneMision(){
        return mision != null;
    }
    
    public boolean validarFecha(){
        return fecha != null && fecha.esValida() && !fecha.esPosteriorAHoy();
    }
    
    public double calcularAporte() {
        return 0.0;
    }
    
     public String getTipo() {
        return "Evento";
    }
    
    public String getNombreDato() {
        return "";
    }    
     
    public String getValorDato() {
        return "";
    }
    
    public String resumen() {
        return getTipo() + " " + getValorDato() + " - " + fecha;
    }
    
    public String mostrarInformacion() {
        return toString();
    }
    
    
    @Override
    public String toString() {
        return "Descripción: " + descripcion + "\n" +
               "Fecha: " + fecha + "\n" +
               "Lugar: " + (lugar != null ? lugar.getNombre() : "Ninguno") + "\n" +
               "Misión: " + (mision != null ? mision.getCodigo() : "Ninguna") + "\n";
    }


}//End class
