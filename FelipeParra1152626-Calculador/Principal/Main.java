package Principal;

import modelo.CalculadorImpuestos;
import vista.JFImpuestos;
import controlador.ControlCalculador;

public class Main
{
    public static void main(String[] args)
    {
        CalculadorImpuestos modelo = new CalculadorImpuestos();
        JFImpuestos vista = new JFImpuestos();
        ControlCalculador control = new ControlCalculador(vista, modelo);
        vista.setVisible(true);
    }
}
