package vista;

import controlador.ControlCantantes;
import javax.swing.*;
import java.awt.*;

public class JFCantantes extends JFrame
{
    // Atributos
    private JLabel lblNombre, lblAlbum, lblCanciones;
    private JTextField txtNombre, txtAlbum, txtCanciones, txtBuscar;
    private JButton btnRegistrar, btnBuscar, btnEliminar, btnListar;
    private JTextArea txtArea;
    private JScrollPane scroll;
    private JPanel panelDatos, panelBotones;

    // Constructor
    public JFCantantes()
    {
        setTitle("Registro de Cantantes");
        setSize(480, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(4, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos"));

        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        lblAlbum = new JLabel("Ultimo album:");
        txtAlbum = new JTextField();
        lblCanciones = new JLabel("Numero de canciones:");
        txtCanciones = new JTextField();
        txtBuscar = new JTextField();

        panelDatos.add(lblNombre);
        panelDatos.add(txtNombre);
        panelDatos.add(lblAlbum);
        panelDatos.add(txtAlbum);
        panelDatos.add(lblCanciones);
        panelDatos.add(txtCanciones);
        panelDatos.add(new JLabel("Buscar / eliminar:"));
        panelDatos.add(txtBuscar);

        add(panelDatos, BorderLayout.NORTH);

        txtArea = new JTextArea();
        scroll = new JScrollPane(txtArea);
        add(scroll, BorderLayout.CENTER);

        btnRegistrar = new JButton("Registrar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");
        panelBotones = new JPanel();
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtAlbum() { return txtAlbum; }
    public JTextField getTxtCanciones() { return txtCanciones; }
    public JTextField getTxtBuscar() { return txtBuscar; }
    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnListar() { return btnListar; }
    public JTextArea getTxtArea() { return txtArea; }

    public void limpiar()
    {
        txtNombre.setText("");
        txtAlbum.setText("");
        txtCanciones.setText("");
    }

    public static void main(String[] args)
    {
        JFCantantes vista = new JFCantantes();
        new ControlCantantes(vista);
    }
}
