package modelo;

public class Jugador
{
    private String nombre;
    private Lugar ubicacion;

    public Jugador(String nombre, Lugar ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public void moverA(Lugar lugar){
        this.ubicacion = lugar;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Lugar getUbicacion(){
        return this.ubicacion;
    }
}//End class
