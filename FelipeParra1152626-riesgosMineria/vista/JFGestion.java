package vista;


import javax.swing.*;
import java.awt.*;

public class JFGestion extends JFrame {
    public JLabel lblCodigo, lblDescripcion,lblTipo, lblNivel;
    public JTextField txtCodigo, txtDescripcion, txtTipo, txtNivel;
    public JButton btnAgregar, btnBuscar, btnEliminar;
    public JTextArea areaSalida;

    public JFGestion() {
        setTitle("Gestor de Riesgos - Mina");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        JPanel panelEntrada = new JPanel(new GridLayout(5, 2));
        
        lblCodigo = new JLabel("Código: ");
        lblDescripcion = new JLabel("Descripción: ");
        lblTipo = new JLabel("Tipo: ");
        lblNivel = new JLabel("Nivel de Peligro (1-5):");
        
        txtCodigo = new JTextField();
        txtDescripcion = new JTextField();
        txtTipo = new JTextField();
        txtNivel = new JTextField();

        panelEntrada.add(lblCodigo);
        panelEntrada.add(txtCodigo);
        panelEntrada.add(lblDescripcion);
        panelEntrada.add(txtDescripcion);
        panelEntrada.add(lblTipo);
        panelEntrada.add(txtTipo);
        panelEntrada.add(lblNivel);
        panelEntrada.add(txtNivel);

        btnAgregar = new JButton("Agregar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");

        panelEntrada.add(btnAgregar);
        panelEntrada.add(btnBuscar);

        add(panelEntrada, BorderLayout.NORTH);
        add(btnEliminar, BorderLayout.SOUTH);

        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        add(new JScrollPane(areaSalida), BorderLayout.CENTER);
    }
}

