import modelo.*;
import vista.*;
import controlador.*;

/**
 * Clase principal: crea el modelo, la vista y el controlador.
 */
public class Main
{
    public static void main(String[] args){
        JFCondominio vista = new JFCondominio();
        Condominius modelo = new Condominius();

        ControlCondominio control = new ControlCondominio(vista, modelo);

        vista.setVisible(true);
    }
}
