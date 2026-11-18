import modelo.*;
import vista.*;
import controlador.*;

public class Main
{
    public static void main(String[] args){
        JFVecindad vista = new JFVecindad();
        Vecindad modelo = new Vecindad();

        ControlVecindad control = new ControlVecindad(vista, modelo);

        vista.setVisible(true);
    }
}
