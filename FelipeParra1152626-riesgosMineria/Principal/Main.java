package Principal;

import modelo.GestorRiesgos;
import vista.JFGestion;
import controlador.Control;

public class Main {
    public static void main(String[] args) {
        GestorRiesgos modelo = new GestorRiesgos();
        JFGestion vista = new JFGestion();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
