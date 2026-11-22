package controlador;

import modelo.*;
import vista.JFBiblioteca;
import javax.swing.*;
import java.awt.event.*;

public class ControlBiblioteca implements ActionListener
{
    // Atributos
    private JFBiblioteca vista;
    private Biblioteca biblioteca;

    // Constructor
    public ControlBiblioteca(JFBiblioteca vista, Biblioteca biblioteca)
    {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.vista.getBtnLibro().addActionListener(this);
        this.vista.getBtnUsuario().addActionListener(this);
        this.vista.getBtnPrestar().addActionListener(this);
        this.vista.getBtnDevolver().addActionListener(this);
        this.vista.getBtnMultas().addActionListener(this);
        this.vista.getBtnMostrar().addActionListener(this);
    }

    // Metodos
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vista.getBtnLibro())
        {
            registrarLibro();
        }
        else if (e.getSource() == vista.getBtnUsuario())
        {
            registrarUsuario();
        }
        else if (e.getSource() == vista.getBtnPrestar())
        {
            prestar();
        }
        else if (e.getSource() == vista.getBtnDevolver())
        {
            devolver();
        }
        else if (e.getSource() == vista.getBtnMultas())
        {
            verificarMultas();
        }
        else if (e.getSource() == vista.getBtnMostrar())
        {
            mostrar();
        }
    }

    private void registrarLibro()
    {
        String tipo = pedir("Tipo:\n1. Referencia (2 copias)\n2. Coleccion general");
        if (tipo == null)
        {
            return;
        }
        String titulo = pedir("Titulo:");
        String autor = pedir("Autor:");
        String issn = pedir("ISSN:");
        String anioTxt = pedir("Anio:");
        String editorial = pedir("Editorial:");
        if (titulo == null || autor == null || issn == null || anioTxt == null || editorial == null)
        {
            return;
        }
        int anio = aEntero(anioTxt);
        if (tipo.equals("1"))
        {
            biblioteca.addLibro(new LibroReferencia(titulo, autor, issn, anio, editorial));
        }
        else if (tipo.equals("2"))
        {
            String copiasTxt = pedir("Cantidad de copias:");
            int copias = aEntero(copiasTxt);
            if (copias <= 0)
            {
                aviso("Copias no validas");
                return;
            }
            biblioteca.addLibro(new LibroColeccion(titulo, autor, issn, anio, editorial, copias));
        }
        else
        {
            aviso("Tipo no valido");
            return;
        }
        mostrar();
    }

    private void registrarUsuario()
    {
        String tipo = pedir("Tipo:\n1. Estudiante\n2. Profesor\n3. Administrativo");
        if (tipo == null)
        {
            return;
        }
        String codigo = pedir("Codigo:");
        String nombre = pedir("Nombre:");
        if (codigo == null || nombre == null)
        {
            return;
        }
        if (tipo.equals("1"))
        {
            biblioteca.addUsuario(new Estudiante(codigo, nombre));
        }
        else if (tipo.equals("2"))
        {
            biblioteca.addUsuario(new Profesor(codigo, nombre));
        }
        else if (tipo.equals("3"))
        {
            biblioteca.addUsuario(new Administrativo(codigo, nombre));
        }
        else
        {
            aviso("Tipo no valido");
            return;
        }
        mostrar();
    }

    private void prestar()
    {
        if (biblioteca.getUsuarios().size() == 0 || biblioteca.getLibros().size() == 0)
        {
            aviso("Registre usuario y libro");
            return;
        }
        int posU = elegir("Usuario:\n" + biblioteca.listarUsuarios(), biblioteca.getUsuarios().size());
        int posL = elegir("Libro:\n" + biblioteca.listarLibros(), biblioteca.getLibros().size());
        if (posU < 0 || posL < 0)
        {
            return;
        }
        Fecha fecha = pedirFecha("Fecha de prestamo");
        if (fecha == null)
        {
            return;
        }
        boolean ok = biblioteca.prestar(biblioteca.getUsuarios().get(posU), biblioteca.getLibros().get(posL), fecha);
        if (ok)
        {
            aviso("Prestamo realizado");
        }
        else
        {
            aviso("No hay copias");
        }
        mostrar();
    }

    private void devolver()
    {
        if (biblioteca.getPrestamos().size() == 0)
        {
            aviso("No hay prestamos");
            return;
        }
        int pos = elegir("Prestamo:\n" + biblioteca.listarPrestamos(), biblioteca.getPrestamos().size());
        if (pos < 0)
        {
            return;
        }
        Fecha fecha = pedirFecha("Fecha de devolucion");
        if (fecha == null)
        {
            return;
        }
        boolean ok = biblioteca.devolver(biblioteca.getPrestamos().get(pos), fecha);
        if (ok)
        {
            aviso("Devolucion registrada");
        }
        else
        {
            aviso("Ese prestamo ya fue devuelto o la fecha es anterior al prestamo");
        }
        mostrar();
    }

    private void verificarMultas()
    {
        Fecha hoy = pedirFecha("Fecha de hoy");
        if (hoy == null)
        {
            return;
        }
        biblioteca.verificarMultas(hoy);
        mostrar();
    }

    private void mostrar()
    {
        vista.getArea().setText("LIBROS\n" + biblioteca.listarLibros()
            + "\nUSUARIOS\n" + biblioteca.listarUsuarios()
            + "\nPRESTAMOS\n" + biblioteca.listarPrestamos());
    }

    private Fecha pedirFecha(String titulo)
    {
        String d = pedir(titulo + " - dia:");
        String m = pedir(titulo + " - mes:");
        String a = pedir(titulo + " - anio:");
        if (d == null || m == null || a == null)
        {
            return null;
        }
        Fecha fecha = new Fecha(aEntero(d), aEntero(m), aEntero(a));
        if (!fecha.esValida())
        {
            aviso("Fecha no valida");
            return null;
        }
        return fecha;
    }

    private int elegir(String mensaje, int cantidad)
    {
        String op = pedir(mensaje + "Numero:");
        int n = aEntero(op);
        if (n < 1 || n > cantidad)
        {
            return -1;
        }
        return n - 1;
    }

    private String pedir(String mensaje)
    {
        String valor = JOptionPane.showInputDialog(vista, mensaje);
        if (valor == null)
        {
            return null;
        }
        valor = valor.trim();
        if (valor.length() == 0)
        {
            return null;
        }
        return valor;
    }

    private int aEntero(String texto)
    {
        if (texto == null)
        {
            return -1;
        }
        try
        {
            return Integer.parseInt(texto.trim());
        }
        catch (NumberFormatException ex)
        {
            return -1;
        }
    }

    private void aviso(String texto)
    {
        JOptionPane.showMessageDialog(vista, texto);
    }
}
