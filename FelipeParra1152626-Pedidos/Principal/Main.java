package Principal;

import modelo.GestorPedidos;
import vista.FrmPedido;
import controlador.ControlPedido;

public class Main
{
    public static void main(String[] args)
    {
        GestorPedidos modelo = new GestorPedidos();
        FrmPedido vista = new FrmPedido();
        ControlPedido control = new ControlPedido(vista, modelo);
        vista.setVisible(true);
    }
}
