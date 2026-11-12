package modelo;

public class Evento
{
    private String nombre;
    private String tipo;
    private String impacto;
    
    public Evento(String nombre,String tipo,String impacto){
        this.nombre = nombre;
        this.tipo = tipo;
        this.impacto = impacto;
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

    /**GET Method Propertie tipo*/
    public String getTipo(){
        return this.tipo;
    }//end method getTipo

    /**SET Method Propertie tipo*/
    public void setTipo(String tipo){
        this.tipo = tipo;
    }//end method setTipo

    /**GET Method Propertie impacto*/
    public String getImpacto(){
        return this.impacto;
    }//end method getImpacto

    /**SET Method Propertie impacto*/
    public void setImpacto(String impacto){
        this.impacto = impacto;
    }//end method setImpacto

//End GetterSetterExtension Source Code


}//End class