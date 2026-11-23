package Principal;

import Modelo.RegistroPersonas;
import Vista.JFRegistroPersona;
import Controlador.ControlRegistro;

/**
 * Clase principal: crea el modelo, la vista y el controlador.
 */
public class Main {
    public static void main(String[] args) {
        RegistroPersonas modelo = new RegistroPersonas();
        JFRegistroPersona vista = new JFRegistroPersona();
        ControlRegistro control = new ControlRegistro(vista, modelo);
        vista.setVisible(true);
    }
}
