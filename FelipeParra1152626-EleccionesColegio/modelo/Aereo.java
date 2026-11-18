package modelo;

public class Aereo extends Mascota
{
    public Aereo(String identificacion, String nombre, String genero, int edad, String cualidades){
        super(identificacion, nombre, genero, edad, cualidades);
    }

    public String getTipo(){
        return "Aéreo";
    }
}//End class
