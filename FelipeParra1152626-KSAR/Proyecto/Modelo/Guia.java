package Proyecto.Modelo;


/**
 * Guía. Andrés agregó el atributo binomio (bidireccional) y estaVigente().
 */
public class Guia
{
    private String cedula ;
    private String nombreCompleto;
    private Certificacion certificacion;
    private Binomio binomio;
    
    public Guia(){
        
    }
    
    public Guia(String cedula , String nombreCompleto , Certificacion certificacion){
        this.cedula=cedula;
        this.nombreCompleto=nombreCompleto;
        this.certificacion=certificacion;
    }
    
    

//Start GetterSetterExtension Source Code

    /**GET Method Propertie cedula*/
    public String getCedula(){
        return this.cedula;
    }//end method getCedula

    /**SET Method Propertie cedula*/
    public void setCedula(String cedula){
        this.cedula = cedula;
    }//end method setCedula

    /**GET Method Propertie nombreCompleto*/
    public String getNombreCompleto(){
        return this.nombreCompleto;
    }//end method getNombreCompleto

    /**SET Method Propertie nombreCompleto*/
    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }//end method setNombreCompleto

    /**GET Method Propertie certificacion*/
    public Certificacion getCertificacion(){
        return this.certificacion;
    }//end method getCertificacion

    /**SET Method Propertie certificacion*/
    public void setCertificacion(Certificacion certificacion){
        this.certificacion = certificacion;
    }//end method setCertificacion

    /**GET Method Propertie binomio*/
    public Binomio getBinomio(){
        return this.binomio;
    }//end method getBinomio

    /**SET Method Propertie binomio*/
    public void setBinomio(Binomio binomio){
        this.binomio = binomio;
    }//end method setBinomio

//End GetterSetterExtension Source Code
    // METODOS OPERACIONALES  (Andrés)

   
    public boolean estaVigente() {
        return certificacion == Certificacion.VIGENTE;
    }
    
    public boolean tienePerro(){
        return binomio != null;
    }
    
    public static boolean esCedulaValida(String cedula){
        if(cedula == null || cedula.isEmpty()){
            return false;
        }
        for(int i = 0; i < cedula.length(); i++){
            if(!Character.isDigit(cedula.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
     public void cambiarCertificacion(Certificacion nueva){
        this.certificacion = nueva;
        if(binomio != null){
            binomio.actualizarEstado();
        }
    }
    
    
     
   @Override
    public String toString() {
    return "Cédula: " + cedula + "\n" +
           "Nombre Completo: " + nombreCompleto + "\n" +
           "Certificación: " + certificacion + "\n" +
           "Binomio: " + (binomio != null ? "Asignado" : "Ninguno");
   }

}//End class
