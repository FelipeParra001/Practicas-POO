import modelo.*;
import vista.*;
import controlador.*;

public class Main
{
    public static void main(String[] args){
        JFElecciones vista = new JFElecciones();
        Eleccion modelo = new Eleccion();

        ControlElecciones control = new ControlElecciones(vista, modelo);

        vista.setVisible(true);
    }
}
