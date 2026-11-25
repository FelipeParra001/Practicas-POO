package modelo;

/**
 * Vehiculo autorizado para ingresar al condominio, asociado a una unidad.
 */
public class Vehiculo
{
    private String placa;
    private String tipo;
    private String marca;
    private String color;
    private Unidad unidad;

    public Vehiculo(String placa, String tipo, String marca, String color, Unidad unidad){
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
        this.unidad = unidad;
    }

    public String toString(){
        return tipo + " " + placa + " - " + marca + " " + color + " - Unidad " + unidad.getCodigo() + " [" + unidad.getCondominio().getNombre() + "]";
    }

    // ==================== GET Y SET ====================

    public String getPlaca(){
        return this.placa;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getColor(){
        return this.color;
    }

    public Unidad getUnidad(){
        return this.unidad;
    }
}//End class
