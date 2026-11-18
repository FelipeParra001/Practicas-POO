package modelo;

public class Terrestre extends Mascota
{
    public Terrestre(String identificacion, String nombre, String genero, int edad, String cualidades){
        super(identificacion, nombre, genero, edad, cualidades);
    }

    public String getTipo(){
        return "Terrestre";
    }
}//End class
