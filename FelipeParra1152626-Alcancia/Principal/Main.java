package Principal;

import modelo.Alcancia;
import vista.JFAlcancia;
import controlador.ControlAlcancia;

public class Main
{
    public static void main(String[] args)
    {
        Alcancia modelo = new Alcancia();
        JFAlcancia vista = new JFAlcancia();
        ControlAlcancia control = new ControlAlcancia(vista, modelo);
        vista.setVisible(true);
    }
}
