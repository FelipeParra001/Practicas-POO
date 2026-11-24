package Vista;

import javax.swing.*;
import java.awt.*;

public class JFGestorCardenales extends JFrame
{
    // Atributos
    private JButton btnVotar;
    private JButton btnMostrarResultados;
    private JButton btnSiguienteRonda;
    private JComboBox<String> cmbCardenales;
    private JTextField txtNumRonda;
    private JTextArea areaResultado;

    // Constructor
    public JFGestorCardenales()
    {
        setTitle("Votaciones Conclave");
        setSize(600, 520);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearInterfaz();
    }

    // Metodos
    private void crearInterfaz()
    {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.add(crearNorte(), BorderLayout.NORTH);
        panelPrincipal.add(crearCentro(), BorderLayout.CENTER);
        panelPrincipal.add(crearSur(), BorderLayout.SOUTH);
        add(panelPrincipal);
    }

    private JPanel crearNorte()
    {
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTitulo = new JLabel("Votaciones Conclave");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelNorte.add(lblTitulo);
        return panelNorte;
    }

    private JPanel crearCentro()
    {
        JPanel panelCentro = new JPanel(null);

        JLabel lblLista = new JLabel("Lista de cardenales");
        lblLista.setFont(new Font("Arial", Font.BOLD, 14));
        lblLista.setBounds(40, 20, 160, 25);
        panelCentro.add(lblLista);

        cmbCardenales = new JComboBox<String>();
        cmbCardenales.setBounds(210, 20, 260, 25);
        panelCentro.add(cmbCardenales);

        btnVotar = new JButton("Votar");
        btnVotar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVotar.setBounds(210, 70, 90, 30);
        panelCentro.add(btnVotar);

        JLabel lblRonda = new JLabel("Ronda No");
        lblRonda.setFont(new Font("Arial", Font.BOLD, 14));
        lblRonda.setBounds(340, 72, 80, 25);
        panelCentro.add(lblRonda);

        txtNumRonda = new JTextField("1");
        txtNumRonda.setHorizontalAlignment(JTextField.CENTER);
        txtNumRonda.setEditable(false);
        txtNumRonda.setBounds(430, 72, 40, 25);
        panelCentro.add(txtNumRonda);

        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        panelResultados.setBounds(30, 120, 490, 200);
        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaResultado.setEditable(false);
        areaResultado.setLineWrap(true);
        panelResultados.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        panelCentro.add(panelResultados);
        return panelCentro;
    }

    private JPanel crearSur()
    {
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        btnMostrarResultados = new JButton("Mostrar Resultados");
        btnSiguienteRonda = new JButton("Siguiente Ronda");
        panelSur.add(btnMostrarResultados);
        panelSur.add(btnSiguienteRonda);
        return panelSur;
    }

    // Getters
    public JButton getBtnVotar()
    {
        return btnVotar;
    }

    public JButton getBtnMostrarResultados()
    {
        return btnMostrarResultados;
    }

    public JButton getBtnSiguienteRonda()
    {
        return btnSiguienteRonda;
    }

    public JComboBox<String> getCmbCardenales()
    {
        return cmbCardenales;
    }

    public JTextField getTxtNumRonda()
    {
        return txtNumRonda;
    }

    public JTextArea getAreaResultado()
    {
        return areaResultado;
    }
}
