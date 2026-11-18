package Proyecto.Modelo;


/**
 * Perro. Andrés agregó el atributo binomio (bidireccional),
 * estaVigente() y validarAptitudFisica().
 */
public class Perro
{
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private String raza;
    private int edad;
    private Certificacion  certificacion;
    private Binomio binomio;
    
    
    public Perro(){
        
    }
    
    public Perro(String codigo, String nombre , String descripcion , String raza, int edad , Certificacion certificacion){
     this.codigo=codigo;
     this.nombre=nombre;
     this.descripcion=descripcion;
     this.raza=raza;
     this.edad=edad;
     this.certificacion=certificacion;
     
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie codigo*/
    public String getCodigo(){
        return this.codigo;
    }//end method getCodigo

    /**SET Method Propertie codigo*/
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }//end method setCodigo

    /**GET Method Propertie nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**SET Method Propertie nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**GET Method Propertie descripcion*/
    public String getDescripcion(){
        return this.descripcion;
    }//end method getDescripcion

    /**SET Method Propertie descripcion*/
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }//end method setDescripcion

    /**GET Method Propertie raza*/
    public String getRaza(){
        return this.raza;
    }//end method getRaza

    /**SET Method Propertie raza*/
    public void setRaza(String raza){
        this.raza = raza;
    }//end method setRaza

    /**GET Method Propertie edad*/
    public int getEdad(){
        return this.edad;
    }//end method getEdad

    /**SET Method Propertie edad*/
    public void setEdad(int edad){
        this.edad = edad;
    }//end method setEdad

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

  
    public boolean validarAptitudFisica() {
        return estaVigente() && edad > 0;
    }

    public void cambiarCertificacion(Certificacion nueva){
        this.certificacion = nueva;
        if(binomio != null){
            binomio.actualizarEstado();
        }
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
               "Nombre: " + nombre + "\n" +
               "Descripción : "+ descripcion+ "\n" +
               "Raza : " + raza+ "\n" +
               "Edad: "+ edad+ "\n" +
               "Certificación :"+ certificacion+ "\n" +
               "Binomio: "+ (binomio != null ? "asignado" : "ninguno");
               
    }
}//End class
