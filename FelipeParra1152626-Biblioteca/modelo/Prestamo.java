package modelo;

public class Prestamo
{
    // Atributos
    private Usuario usuario;
    private Libro libro;
    private Fecha fechaPrestamo;
    private Fecha fechaLimite;
    private Fecha fechaDevolucion;
    private EstadoPrestamo estado;

    // Constructor
    public Prestamo(Usuario usuario, Libro libro, Fecha fechaPrestamo)
    {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaPrestamo.sumarDias(usuario.plazoDias());
        this.estado = EstadoPrestamo.PRESTADO;
    }

    // Getters
    public Usuario getUsuario()
    {
        return usuario;
    }

    public Libro getLibro()
    {
        return libro;
    }

    public Fecha getFechaPrestamo()
    {
        return fechaPrestamo;
    }

    public Fecha getFechaLimite()
    {
        return fechaLimite;
    }

    public Fecha getFechaDevolucion()
    {
        return fechaDevolucion;
    }

    public EstadoPrestamo getEstado()
    {
        return estado;
    }

    // Setters
    public void setEstado(EstadoPrestamo estado)
    {
        this.estado = estado;
    }

    // Metodos
    public void devolver(Fecha fecha)
    {
        fechaDevolucion = fecha;
        if (fecha.esPosterior(fechaLimite))
        {
            estado = EstadoPrestamo.MULTADO;
        }
        else
        {
            estado = EstadoPrestamo.DEVUELTO;
        }
        libro.devolverCopia();
    }

    public void verificarMulta(Fecha hoy)
    {
        if (fechaDevolucion == null && estado == EstadoPrestamo.PRESTADO && hoy.esPosterior(fechaLimite))
        {
            estado = EstadoPrestamo.MULTADO;
        }
    }

    public String toString()
    {
        return usuario.getNombre() + " | " + libro.getTitulo() + " | " + estado + " | limite " + fechaLimite;
    }
}
