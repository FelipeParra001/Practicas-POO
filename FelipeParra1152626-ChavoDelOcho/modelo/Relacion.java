package modelo;

public class Relacion
{
    private Personaje personaje;
    private String tipo;

    public Relacion(Personaje personaje, String tipo){
        this.personaje = personaje;
        this.tipo = tipo;
    }

    public Personaje getPersonaje(){
        return this.personaje;
    }

    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}//End class
