package vista;

import javax.swing.*;
import java.awt.*;

public class JFBiblioteca extends JFrame
{
    // Atributos
    private JButton btnLibro;
    private JButton btnUsuario;
    private JButton btnPrestar;
    private JButton btnDevolver;
    private JButton btnMultas;
    private JButton btnMostrar;
    private JTextArea area;

    // Constructor
    public JFBiblioteca()
    {
        setTitle("Biblioteca UFPS");
        setSize(520, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearInterfaz();
    }

    // Metodos
    private void crearInterfaz()
    {
        setLayout(new BorderLayout());
        JPanel botones = new JPanel(new GridLayout(3, 2, 6, 6));
        btnLibro = new JButton("Registrar libro");
        btnUsuario = new JButton("Registrar usuario");
        btnPrestar = new JButton("Prestar");
        btnDevolver = new JButton("Devolver");
        btnMultas = new JButton("Verificar multas");
        btnMostrar = new JButton("Mostrar datos");
        botones.add(btnLibro);
        botones.add(btnUsuario);
        botones.add(btnPrestar);
        botones.add(btnDevolver);
        botones.add(btnMultas);
        botones.add(btnMostrar);
        add(botones, BorderLayout.NORTH);
        area = new JTextArea(12, 30);
        area.setEditable(false);
        add(new JScrollPane(area), BorderLayout.CENTER);
    }

    // Getters
    public JButton getBtnLibro()
    {
        return btnLibro;
    }

    public JButton getBtnUsuario()
    {
        return btnUsuario;
    }

    public JButton getBtnPrestar()
    {
        return btnPrestar;
    }

    public JButton getBtnDevolver()
    {
        return btnDevolver;
    }

    public JButton getBtnMultas()
    {
        return btnMultas;
    }

    public JButton getBtnMostrar()
    {
        return btnMostrar;
    }

    public JTextArea getArea()
    {
        return area;
    }
}
