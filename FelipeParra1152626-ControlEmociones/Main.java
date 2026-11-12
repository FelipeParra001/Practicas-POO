import modelo.*;
import controlador.*;
import vista.*;


public class Main
{
   public static void main(String []args ){
      JFPrincipal vista = new JFPrincipal();
      Gestor modelo = new Gestor();
      
      Controlador controlador = new Controlador(vista, modelo);
      
      vista.setVisible(true);
   } 
}