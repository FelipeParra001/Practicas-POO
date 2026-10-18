package modelo;

public class Vehiculo
{
    // Atributos
    private String marca;
    private String linea;
    private int modelo;
    private long precio;
    private String imagen;

    // Constructor
    public Vehiculo(String marca, String linea, int modelo, long precio, String imagen)
    {
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getMarca()
    {
        return marca;
    }

    public String getLinea()
    {
        return linea;
    }

    public int getModelo()
    {
        return modelo;
    }

    public long getPrecio()
    {
        return precio;
    }

    public String getImagen()
    {
        return imagen;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public void setLinea(String linea)
    {
        this.linea = linea;
    }

    public void setModelo(int modelo)
    {
        this.modelo = modelo;
    }

    public void setPrecio(long precio)
    {
        this.precio = precio;
    }

    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }
}
