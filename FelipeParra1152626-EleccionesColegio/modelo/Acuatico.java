package modelo;

public class Acuatico extends Mascota
{
    public Acuatico(String identificacion, String nombre, String genero, int edad, String cualidades){
        super(identificacion, nombre, genero, edad, cualidades);
    }

    public String getTipo(){
        return "Acuático";
    }
}//End class
