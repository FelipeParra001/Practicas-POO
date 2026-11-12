package modelo;

public class Emocion
{
    private String nombre;
    private int intesidad;
    private String tipo;
    private String accion;
    private String estadoActual;
    
    public Emocion(String nombre,int intesidad,String tipo,String accion,String estadoActual){
        this.nombre = nombre;
        this.intesidad = intesidad;
        this.tipo = tipo;
        this.accion = accion;
        this.estadoActual =estadoActual;
    }

    /**GET Method Propertie nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**SET Method Propertie nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**GET Method Propertie intesidad*/
    public int getIntesidad(){
        return this.intesidad;
    }//end method getIntesidad

    /**SET Method Propertie intesidad*/
    public void setIntesidad(int intesidad){
        this.intesidad = intesidad;
    }//end method setIntesidad

    /**GET Method Propertie tipo*/
    public String getTipo(){
        return this.tipo;
    }//end method getTipo

    /**SET Method Propertie tipo*/
    public void setTipo(String tipo){
        this.tipo = tipo;
    }//end method setTipo

    /**GET Method Propertie accion*/
    public String getAccion(){
        return this.accion;
    }//end method getAccion

    /**SET Method Propertie accion*/
    public void setAccion(String accion){
        this.accion = accion;
    }//end method setAccion

    /**GET Method Propertie estadoActual*/
    public String getEstadoActual(){
        return this.estadoActual;
    }//end method getEstadoActual

    /**SET Method Propertie estadoActual*/
    public void setEstadoActual(String estadoActual){
        this.estadoActual = estadoActual;
    }//end method setEstadoActual

}//End class