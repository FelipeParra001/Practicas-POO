package modelo;

public class Profesor extends Usuario
{
    // Constructor
    public Profesor(String codigo, String nombre)
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
        return "Profesor";
    }
}
