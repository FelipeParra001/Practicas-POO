package Proyecto.Modelo;
import java.util.ArrayList;


/**
 * Write a description of class Pais here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pais
{
    
    private String nombre;
    private String codigo;
    private ArrayList <Municipio> municipios;
    
    
    
    public Pais(){
        
    }
    
    public Pais(String nombre, String codigo){
        this.nombre=nombre;
        this.codigo=codigo;
        this.municipios=new ArrayList<>();
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

    /**GET Method Propertie codigo*/
    public String getCodigo(){
        return this.codigo;
    }//end method getCodigo

    /**SET Method Propertie codigo*/
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }//end method setCodigo

    /**GET Method Propertie municipios*/
    public java.util.ArrayList<Proyecto.Modelo.Municipio> getMunicipios(){
        return this.municipios;
    }//end method getMunicipios

    /**SET Method Propertie municipios*/
    public void setMunicipios(java.util.ArrayList<Proyecto.Modelo.Municipio> municipios){
        this.municipios = municipios;
    }//end method setMunicipios

//End GetterSetterExtension Source Code

     
    // METODOS OPERACIONALES 
    
    public Municipio buscarMunicipio(String nombreMunicipio){
        for(Municipio m : municipios){
            if(m.getNombre().equalsIgnoreCase(nombreMunicipio)){
                return m;
            }
        }
        return null;
    }
    
    
     public boolean agregarMunicipio(Municipio m){
        if(m == null || buscarMunicipio(m.getNombre()) != null){
            return false;
        }
        municipios.add(m);
        return true;
    }
    
    public String mostrarInformacion(){
        return nombre + " (" + codigo + ") - " + municipios.size() + " municipio(s)";
    }
    
    @Override
    public String toString() {
    return "Nombre: " + nombre + "\n" +
           "Código: " + codigo + "\n" +
            "Municipios: " + municipios.size();
   }

}//End class
