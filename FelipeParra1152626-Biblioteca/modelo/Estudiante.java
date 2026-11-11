package modelo;

public class Estudiante extends Usuario
{
    // Constructor
    public Estudiante(String codigo, String nombre)
    {
        super(codigo, nombre);
    }

    // Metodos
    public int plazoDias()
    {
        return 15;
    }

    public String getTipo()
    {
        return "Estudiante";
    }
}
