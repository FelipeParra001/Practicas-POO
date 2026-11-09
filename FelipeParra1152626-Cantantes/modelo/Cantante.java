package modelo;

public class Cantante
{
    // Atributos
    private String nombre;
    private String album;
    private int nCanciones;

    // Constructor
    public Cantante()
    {
    }

    public Cantante(String nombre, String album, int nCanciones)
    {
        this.nombre = nombre;
        this.album = album;
        this.nCanciones = nCanciones;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getAlbum() { return album; }
    public int getNCanciones() { return nCanciones; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAlbum(String album) { this.album = album; }
    public void setNCanciones(int nCanciones) { this.nCanciones = nCanciones; }

    // Metodos
    public String toString()
    {
        return nombre + " - " + album + " - " + nCanciones + " canciones";
    }
}
