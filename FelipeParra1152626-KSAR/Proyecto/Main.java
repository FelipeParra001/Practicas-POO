package Proyecto;
import Proyecto.Modelo.*;
import Proyecto.Vista.*;
import Proyecto.Controlador.*;
import javax.swing.SwingUtilities;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    private static final boolean CARGAR_DATOS_PRUEBA = true;

    public static void main(String[] args) {
        SistemaKsar modeloSistema = new SistemaKsar();
        if (CARGAR_DATOS_PRUEBA) {
            DatosPrueba.cargar(modeloSistema);
        }
        JFKsar vistaKsar = new JFKsar();
        Control control = new Control(modeloSistema, vistaKsar);
        vistaKsar.setVisible(true);
    }
}