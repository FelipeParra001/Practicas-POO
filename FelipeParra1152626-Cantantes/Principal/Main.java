package Principal;

import modelo.GestorCantantes;
import vista.JFCantantes;
import controlador.ControlCantantes;

public class Main
{
    public static void main(String[] args)
    {
        GestorCantantes modelo = new GestorCantantes();
        JFCantantes vista = new JFCantantes();
        ControlCantantes control = new ControlCantantes(vista, modelo);
        vista.setVisible(true);
    }
}
