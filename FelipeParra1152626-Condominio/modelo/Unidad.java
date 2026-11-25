package modelo;
import java.util.ArrayList;

/**
 * Unidad residencial de un condominio (apartamento o casa).
 */
public abstract class Unidad
{
    public static final int MAX_RESIDENTES = 8;
    public static final int MAX_VEHICULOS = 2;

    private String codigo;
    private double area;
    private Condominio condominio;
    private Propietario propietario;
    private ArrayList<Residente> residentes;
    private ArrayList<Vehiculo> vehiculos;

    public Unidad(String codigo, double area, Condominio condominio){
        this.codigo = codigo;
        this.area = area;
        this.condominio = condominio;
        this.propietario = null;
        residentes = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    // ==================== METODOS ABSTRACTOS ====================

    // Valor mensual de la cuota de administracion
    public abstract double calcularCuota();

    public abstract String getTipo();

    // ==================== METODOS ====================

    public void agregarResidente(Residente residente){
        residentes.add(residente);
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    // Indica si la unidad tiene a alguien (propietario o residentes) a quien visitar
    public boolean estaHabitada(){
        return propietario != null || !residentes.isEmpty();
    }

    public String toString(){
        String texto = getTipo() + " " + codigo + " - " + area + " m2 - Cuota $" + (long) calcularCuota();
        texto += " - Propietario: " + (propietario == null ? "sin asignar" : propietario.getNombre());
        texto += " - Residentes: " + residentes.size() + " - Vehiculos: " + vehiculos.size();
        return texto;
    }

    // ==================== GET Y SET ====================

    public String getCodigo(){
        return this.codigo;
    }

    public double getArea(){
        return this.area;
    }

    public Condominio getCondominio(){
        return this.condominio;
    }

    public Propietario getPropietario(){
        return this.propietario;
    }

    public void setPropietario(Propietario propietario){
        this.propietario = propietario;
    }

    public ArrayList<Residente> getResidentes(){
        return this.residentes;
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return this.vehiculos;
    }
}//End class
