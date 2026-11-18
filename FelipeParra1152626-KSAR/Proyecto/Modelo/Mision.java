package Proyecto.Modelo;


/**
 * Misión. Andrés agregó el atributo evento (bidireccional) y calcularDesempeno().
 */
public class Mision
{
    private String codigo;
    private double horasLabor;
    private int sobrevivientes;
    private int fallecidos;
    private Fecha fecha;
    private Equipo equipo;
    private Binomio binomio;
    private Evento evento;
    
    public Mision(){
        
    }
    
    public Mision(String codigo, Fecha fecha, Equipo equipo, Binomio binomio, Evento evento, double horasLabor, int sobrevivientes, int fallecidos){
     this.codigo=codigo;
     this.fecha=fecha;
     this.equipo=equipo;
     this.binomio=binomio;
     this.evento=evento;
     this.horasLabor=horasLabor;
     this.sobrevivientes=sobrevivientes;
     this.fallecidos=fallecidos;
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

    /**GET Method Propertie horasLabor*/
    public double getHorasLabor(){
        return this.horasLabor;
    }//end method getHorasLabor

    /**SET Method Propertie horasLabor*/
    public void setHorasLabor(double horasLabor){
        this.horasLabor = horasLabor;
    }//end method setHorasLabor

    /**GET Method Propertie sobrevivientes*/
    public int getSobrevivientes(){
        return this.sobrevivientes;
    }//end method getSobrevivientes

    /**SET Method Propertie sobrevivientes*/
    public void setSobrevivientes(int sobrevivientes){
        this.sobrevivientes = sobrevivientes;
    }//end method setSobrevivientes

    /**GET Method Propertie fallecidos*/
    public int getFallecidos(){
        return this.fallecidos;
    }//end method getFallecidos

    /**SET Method Propertie fallecidos*/
    public void setFallecidos(int fallecidos){
        this.fallecidos = fallecidos;
    }//end method setFallecidos

    /**GET Method Propertie fecha*/
    public Fecha getFecha(){
        return this.fecha;
    }//end method getFecha

    /**SET Method Propertie fecha*/
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }//end method setFecha

    /**GET Method Propertie equipo*/
    public Equipo getEquipo(){
        return this.equipo;
    }//end method getEquipo

    /**SET Method Propertie equipo*/
    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }//end method setEquipo

    /**GET Method Propertie binomio*/
    public Binomio getBinomio(){
        return this.binomio;
    }//end method getBinomio

    /**SET Method Propertie binomio*/
    public void setBinomio(Binomio binomio){
        this.binomio = binomio;
    }//end method setBinomio

    /**GET Method Propertie evento*/
    public Evento getEvento(){
        return this.evento;
    }//end method getEvento

    /**SET Method Propertie evento*/
    public void setEvento(Evento evento){
        this.evento = evento;
    }//end method setEvento


    
//End GetterSetterExtension Source Code
    // METODOS OPERACIONALES (Andrés)

    
    public int calcularDesempeno(){
        double total = 10.0 * sobrevivientes + horasLabor;
        if(evento != null){
            total += evento.calcularAporte();
        }
        return (int) Math.floor(total + 0.000001);
    }
    
    public boolean esDeMunicipio(String nombreMunicipio){
        Municipio m = obtenerMunicipio();
        return m != null && m.getNombre().equalsIgnoreCase(nombreMunicipio);
    }
    
    public boolean esDeEquipo(String nombreEquipo){
        return equipo != null && equipo.getNombre().equalsIgnoreCase(nombreEquipo);
    }
    
    public Municipio obtenerMunicipio(){
        if(evento == null || evento.getLugar() == null){
            return null;
        }
        return evento.getLugar().getMunicipio();
    }

    public boolean validarFecha(){
    return fecha != null && fecha.esValida() && !fecha.esPosteriorAHoy();
    }
    
    public boolean validarDatos(){
    return horasLabor >= 0 && sobrevivientes >= 0 && fallecidos >= 0;
   }
    
    @Override
    public String toString() {
        return "Código: " + codigo+ "\n" +
               "Equipo: " + (equipo != null ? equipo.getNombre() : "ninguno") + "\n" +
               "Binomio: " + (binomio != null ? binomio.resumen() : "ninguno") + "\n" +
               "Horas de Labor: " + horasLabor + "\n" +
               "Sobrevivientes: "+ sobrevivientes+ "\n" +
               "Fallecidos: " + fallecidos+ "\n" +
               "Fecha: "+ fecha+ "\n" +
               "Evento: "+ (evento != null ? evento.getDescripcion() : "ninguno");
    }


}//End class
