package modelo;
import java.util.ArrayList;

public class Evento
{
    private String nombre;
    private String tipo ; // social, escolar,familiar
    private Emocion emocion ;
    private int nivelCambio ;
    private String tipoCambio;
    
    public Evento(String nombre,String tipo, Emocion emocion, int nivelCambio, String tipoCambio){
        this.nombre= nombre ;
        this.tipo = tipo;
        this.emocion = emocion ;
        this.nivelCambio = nivelCambio ;
        this.tipoCambio = tipoCambio ;
    }
    
    public String toString(){
        return nombre; 
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

    /**GET Method Propertie emocion*/
    public Emocion getEmocion(){
        return this.emocion;
    }//end method getEmocion

    /**SET Method Propertie emocion*/
    public void setEmocion(Emocion emocion){
        this.emocion = emocion;
    }//end method setEmocion

    /**GET Method Propertie nivelCambio*/
    public int getNivelCambio(){
        return this.nivelCambio;
    }//end method getNivelCambio

    /**SET Method Propertie nivelCambio*/
    public void setNivelCambio(int nivelCambio){
        this.nivelCambio = nivelCambio;
    }//end method setNivelCambio

    /**GET Method Propertie tipoCambio*/
    public String getTipoCambio(){
        return this.tipoCambio;
    }//end method getTipoCambio

    /**SET Method Propertie tipoCambio*/
    public void setTipoCambio(String tipoCambio){
        this.tipoCambio = tipoCambio;
    }//end method setTipoCambio

//End GetterSetterExtension Source Code


}//End class