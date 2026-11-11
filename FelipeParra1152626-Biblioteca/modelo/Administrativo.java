package modelo;

public class Administrativo extends Usuario
{
    // Constructor
    public Administrativo(String codigo, String nombre)
    {
        super(codigo, nombre);
    }

    // Metodos
    public int plazoDias()
    {
        return 3;
    }

    public String getTipo()
    {
        return "Administrativo";
    }
}
