package Principal;

import modelo.Biblioteca;
import vista.JFBiblioteca;
import controlador.ControlBiblioteca;

public class Main
{
    public static void main(String[] args)
    {
        Biblioteca modelo = new Biblioteca();
        JFBiblioteca vista = new JFBiblioteca();
        ControlBiblioteca control = new ControlBiblioteca(vista, modelo);
        vista.setVisible(true);
    }
}
