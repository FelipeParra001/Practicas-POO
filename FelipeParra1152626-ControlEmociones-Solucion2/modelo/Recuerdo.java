package modelo;


public class Recuerdo
{
    
   private Emocion emocion ;
   private String descripcion;
   private String fecha ;
   private Evento evento ;
   
   public Recuerdo(Emocion emocion ,String descripcion, String fecha,Evento evento){
       this.emocion = emocion;
       this.descripcion = descripcion ;
       this.fecha = fecha ;
       this.evento = evento;
   }
    
   public String enlistar(){
       String r = "Descripcion: " + descripcion + "\n" 
                + "Fecha: " + fecha + "\n"
                + "Evento: " + (evento == null ? "Ninguno" : evento.getNombre()) + "\n\n" ;
        return r ;
   }
//Start GetterSetterExtension Source Code

    /**GET Method Propertie emocion*/
    public Emocion getEmocion(){
        return this.emocion;
    }//end method getEmocion

    /**SET Method Propertie emocion*/
    public void setEmocion(Emocion emocion){
        this.emocion = emocion;
    }//end method setEmocion

    /**GET Method Propertie descripcion*/
    public String getDescripcion(){
        return this.descripcion;
    }//end method getDescripcion

    /**SET Method Propertie descripcion*/
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }//end method setDescripcion

    /**GET Method Propertie fecha*/
    public String getFecha(){
        return this.fecha;
    }//end method getFecha

    /**SET Method Propertie fecha*/
    public void setFecha(String fecha){
        this.fecha = fecha;
    }//end method setFecha


}//End class