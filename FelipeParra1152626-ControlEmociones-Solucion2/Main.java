import modelo.*;
import vista.*;
import controlador.*;
public class Main
{
    public static void main(String[] args){
        GestorEmocion modelo = new GestorEmocion();
        JFGestion vista = new JFGestion(); 
        Control control = new Control(modelo,vista);
        vista.setVisible(true);
    }
}
