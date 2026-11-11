package modelo;

public class LibroColeccion extends Libro
{
    // Constructor
    public LibroColeccion(String titulo, String autor, String issn, int anio, String editorial, int copias)
    {
        super(titulo, autor, issn, anio, editorial, copias);
    }

    // Metodos
    public String getTipo()
    {
        return "Coleccion general";
    }
}
