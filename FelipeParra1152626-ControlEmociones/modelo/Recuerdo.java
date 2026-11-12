package modelo;


public class Recuerdo
{
    private String codigo;
    private String descripcion;
    private String fecha;
    private Emocion emocion;
    private Evento evento;
    
    public Recuerdo(String codigo, String descripcion,String fecha,Emocion emocion,Evento evento){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.emocion = emocion;
        this.evento = evento;
    }

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

    /**GET Method Propertie emocion*/
    public Emocion getEmocion(){
        return this.emocion;
    }//end method getEmocion

    /**SET Method Propertie emocion*/
    public void setEmocion(Emocion emocion){
        this.emocion = emocion;
    }//end method setEmocion

    /**GET Method Propertie evento*/
    public Evento getEvento(){
        return this.evento;
    }//end method getEvento

    /**SET Method Propertie evento*/
    public void setEvento(Evento evento){
        this.evento = evento;
    }//end method setEvento



//Start GetterSetterExtension Source Code

    /**GET Method Propertie codigo*/
    public String getCodigo(){
        return this.codigo;
    }//end method getCodigo

    /**SET Method Propertie codigo*/
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }//end method setCodigo

//End GetterSetterExtension Source Code


}//End class