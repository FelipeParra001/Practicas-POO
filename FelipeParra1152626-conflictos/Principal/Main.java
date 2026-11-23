package Principal;

import modelo.GestorConflictos;
import vista.JFConflictos;
import controlador.ControlConflictos;

public class Main
{
    public static void main(String[] args)
    {
        GestorConflictos modelo = new GestorConflictos();
        JFConflictos vista = new JFConflictos();
        ControlConflictos control = new ControlConflictos(vista, modelo);
        vista.setVisible(true);
    }
}
