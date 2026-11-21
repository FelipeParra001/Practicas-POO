package controlador;

import modelo.Alcancia;
import vista.JFAlcancia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlAlcancia implements ActionListener
{
    // Atributos
    private JFAlcancia vista;
    private Alcancia modelo;

    // Constructor
    public ControlAlcancia(JFAlcancia vista, Alcancia modelo)
    {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtn50().addActionListener(this);
        this.vista.getBtn100().addActionListener(this);
        this.vista.getBtn200().addActionListener(this);
        this.vista.getBtn500().addActionListener(this);
        this.vista.getBtn1000().addActionListener(this);
        this.vista.getBtnVaciar().addActionListener(this);
        mostrar();
    }

    public void actionPerformed(ActionEvent e)
    {
        Object boton = e.getSource();
        if (boton == vista.getBtn50())
        {
            modelo.agregarMonedas(50);
            vista.mostrarLlena();
        }
        else if (boton == vista.getBtn100())
        {
            modelo.agregarMonedas(100);
            vista.mostrarLlena();
        }
        else if (boton == vista.getBtn200())
        {
            modelo.agregarMonedas(200);
            vista.mostrarLlena();
        }
        else if (boton == vista.getBtn500())
        {
            modelo.agregarMonedas(500);
            vista.mostrarLlena();
        }
        else if (boton == vista.getBtn1000())
        {
            modelo.agregarMonedas(1000);
            vista.mostrarLlena();
        }
        else if (boton == vista.getBtnVaciar())
        {
            modelo.vaciar();
            vista.mostrarRota();
        }
        mostrar();
    }

    // Muestra en la ventana los datos de la alcancia
    public void mostrar()
    {
        vista.getLblSaldo().setText("$ " + modelo.getSaldo());
        vista.getLbl50().setText(String.valueOf(modelo.getMonedas50()));
        vista.getLbl100().setText(String.valueOf(modelo.getMonedas100()));
        vista.getLbl200().setText(String.valueOf(modelo.getMonedas200()));
        vista.getLbl500().setText(String.valueOf(modelo.getMonedas500()));
        vista.getLbl1000().setText(String.valueOf(modelo.getMonedas1000()));
        vista.getLblTotal().setText("Total monedas: " + modelo.getTotalMonedas());
    }
}
