package modelo;

import java.util.*;

public class Biblioteca
{
    // Atributos
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    // Constructor
    public Biblioteca()
    {
        libros = new ArrayList<Libro>();
        usuarios = new ArrayList<Usuario>();
        prestamos = new ArrayList<Prestamo>();
    }

    // Metodos
    public void addLibro(Libro libro)
    {
        libros.add(libro);
    }

    public void addUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }

    public boolean prestar(Usuario usuario, Libro libro, Fecha fecha)
    {
        if (!libro.hayCopia())
        {
            return false;
        }
        libro.prestarCopia();
        prestamos.add(new Prestamo(usuario, libro, fecha));
        return true;
    }

    public boolean devolver(Prestamo prestamo, Fecha fecha)
    {
        if (prestamo.getFechaDevolucion() != null)
        {
            return false;
        }
        if (fecha.esAnterior(prestamo.getFechaPrestamo()))
        {
            return false;
        }
        prestamo.devolver(fecha);
        return true;
    }

    public void verificarMultas(Fecha hoy)
    {
        for (int i = 0; i < prestamos.size(); i++)
        {
            prestamos.get(i).verificarMulta(hoy);
        }
    }

    public ArrayList<Libro> getLibros()
    {
        return libros;
    }

    public ArrayList<Usuario> getUsuarios()
    {
        return usuarios;
    }

    public ArrayList<Prestamo> getPrestamos()
    {
        return prestamos;
    }

    public String listarLibros()
    {
        return numerar(libros);
    }

    public String listarUsuarios()
    {
        return numerar(usuarios);
    }

    public String listarPrestamos()
    {
        return numerar(prestamos);
    }

    private String numerar(ArrayList<?> lista)
    {
        if (lista.size() == 0)
        {
            return "(no hay registros)\n";
        }
        String texto = "";
        for (int i = 0; i < lista.size(); i++)
        {
            texto = texto + (i + 1) + ". " + lista.get(i).toString() + "\n";
        }
        return texto;
    }
}
