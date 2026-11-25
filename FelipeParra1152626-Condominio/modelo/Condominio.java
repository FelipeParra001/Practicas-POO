package modelo;
import java.util.ArrayList;

/**
 * Condominio o conjunto residencial administrado por Condominius.
 */
public class Condominio
{
    private String codigo;
    private String nombre;
    private String direccion;
    private ArrayList<Unidad> unidades;
    private ArrayList<ZonaComun> zonas;
    private ArrayList<Vigilante> vigilantes;
    private Administrador administrador;

    public Condominio(String codigo, String nombre, String direccion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        unidades = new ArrayList<>();
        vigilantes = new ArrayList<>();
        administrador = null;

        // Todo condominio tiene las tres zonas comunes
        zonas = new ArrayList<>();
        zonas.add(new SalonSocial());
        zonas.add(new Piscina());
        zonas.add(new ZonaDeportiva());
    }

    // ==================== METODOS ====================

    public void agregarUnidad(Unidad unidad){
        unidades.add(unidad);
    }

    public void agregarVigilante(Vigilante vigilante){
        vigilantes.add(vigilante);
    }

    public ZonaComun buscarZona(String nombreZona){
        for(ZonaComun z : zonas){
            if(z.getNombre().equalsIgnoreCase(nombreZona)){
                return z;
            }
        }
        return null;
    }

    public boolean tieneVigilante(Vigilante vigilante){
        return vigilantes.contains(vigilante);
    }

    public String toString(){
        String texto = "Condominio " + codigo + " - " + nombre + " (" + direccion + ")\n";
        texto += "   Administrador: " + (administrador == null ? "sin asignar" : administrador.getNombre());
        texto += " - Vigilantes: " + vigilantes.size() + " - Unidades: " + unidades.size() + "\n";
        for(Unidad u : unidades){
            texto += "   * " + u.toString() + "\n";
        }
        return texto;
    }

    // ==================== GET Y SET ====================

    public String getCodigo(){
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public ArrayList<Unidad> getUnidades(){
        return this.unidades;
    }

    public ArrayList<ZonaComun> getZonas(){
        return this.zonas;
    }

    public ArrayList<Vigilante> getVigilantes(){
        return this.vigilantes;
    }

    public Administrador getAdministrador(){
        return this.administrador;
    }

    public void setAdministrador(Administrador administrador){
        this.administrador = administrador;
    }
}//End class
