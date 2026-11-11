package modelo;

public abstract class Libro
{
    // Atributos
    private String titulo;
    private String autor;
    private String issn;
    private int anio;
    private String editorial;
    private int copiasDisponibles;

    // Constructor
    public Libro(String titulo, String autor, String issn, int anio, String editorial, int copias)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.issn = issn;
        this.anio = anio;
        this.editorial = editorial;
        this.copiasDisponibles = copias;
    }

    // Getters
    public String getTitulo()
    {
        return titulo;
    }

    public String getAutor()
    {
        return autor;
    }

    public String getIssn()
    {
        return issn;
    }

    public int getAnio()
    {
        return anio;
    }

    public String getEditorial()
    {
        return editorial;
    }

    public int getCopiasDisponibles()
    {
        return copiasDisponibles;
    }

    // Setters
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public void setIssn(String issn)
    {
        this.issn = issn;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    public void setEditorial(String editorial)
    {
        this.editorial = editorial;
    }

    public void setCopiasDisponibles(int copiasDisponibles)
    {
        this.copiasDisponibles = copiasDisponibles;
    }

    // Metodos
    public boolean hayCopia()
    {
        return copiasDisponibles > 0;
    }

    public void prestarCopia()
    {
        if (copiasDisponibles > 0)
        {
            copiasDisponibles = copiasDisponibles - 1;
        }
    }

    public void devolverCopia()
    {
        copiasDisponibles = copiasDisponibles + 1;
    }

    public abstract String getTipo();

    public String toString()
    {
        return titulo + " [" + getTipo() + "] copias: " + copiasDisponibles;
    }
}
