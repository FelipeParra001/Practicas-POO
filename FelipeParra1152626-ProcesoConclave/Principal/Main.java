package Principal;

import Modelo.GestorCardenales;
import Vista.JFGestorCardenales;
import Controlador.ControlConclave;

public class Main
{
    public static void main(String[] args)
    {
        GestorCardenales modelo = new GestorCardenales();
        JFGestorCardenales vista = new JFGestorCardenales();
        ControlConclave control = new ControlConclave(vista, modelo);
        vista.setVisible(true);
    }
}
