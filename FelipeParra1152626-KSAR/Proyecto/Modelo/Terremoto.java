package Proyecto.Modelo;


/**
 * Write a description of class Terremoto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terremoto extends Evento
{
     private double magnitud;
    private String epicentro;
    
    public Terremoto (){
        super();
    }
    
    public Terremoto (String descripcion , Fecha fecha , Lugar lugar ,double magnitud , String epicentro){
        super(descripcion,fecha,lugar);
        this.magnitud=magnitud;
        this.epicentro=epicentro;
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie magnitud*/
    public double getMagnitud(){
        return this.magnitud;
    }//end method getMagnitud

    /**SET Method Propertie magnitud*/
    public void setMagnitud(double magnitud){
        this.magnitud = magnitud;
    }//end method setMagnitud

    /**GET Method Propertie epicentro*/
    public String getEpicentro(){
        return this.epicentro;
    }//end method getEpicentro

    /**SET Method Propertie epicentro*/
    public void setEpicentro(String epicentro){
        this.epicentro = epicentro;
    }//end method setEpicentro

//End GetterSetterExtension Source Code
 
     // METODOS OPERACIONALES 
     
    public double calcularAporte(){
        long decimas = Math.round(this.magnitud * 10);
        return decimas * 5 / 10.0;
    }
    
     public String getTipo(){
        return "Terremoto";
    }
    
     public String getNombreDato(){
        return "Magnitud";
    }
    
    public String getValorDato(){
        return String.format(java.util.Locale.US, "%.1f", this.magnitud);
    }
    
    
      @Override
     public String toString() {
    
    return super.toString() + 
           "Magnitud: " + this.magnitud + "\n" +
           "Epicentro: " + this.epicentro;
   }
    
    
    
     

    
}//End class
