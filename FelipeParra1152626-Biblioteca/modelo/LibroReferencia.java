package modelo;

public class LibroReferencia extends Libro
{
    // Constructor
    public LibroReferencia(String titulo, String autor, String issn, int anio, String editorial)
    {
        super(titulo, autor, issn, anio, editorial, 2);
    }

    // Metodos
    public String getTipo()
    {
        return "Referencia";
    }
}
