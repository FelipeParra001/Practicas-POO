package Vista;

import Controlador.ControlConclave;
import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JFGestorCardenales extends JFrame implements ActionListener
{
    // Atributos
    private ControlConclave control;
    private JButton btnVotar;
    private JButton btnMostrarResultados;
    private JButton btnSiguienteRonda;
    private JComboBox cmbCardenales;
    private JTextField txtNumRonda;
    private JTextArea areaResultado;

    // Constructor
    public JFGestorCardenales()
    {
        control = new ControlConclave();
        setTitle("Votaciones Conclave");
        setSize(600, 520);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearInterfaz();
        cargarCombo();
        mostrar();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new JFGestorCardenales();
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

        cmbCardenales = new JComboBox();
        cmbCardenales.setBounds(210, 20, 260, 25);
        panelCentro.add(cmbCardenales);

        btnVotar = new JButton("Votar");
        btnVotar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVotar.setBounds(210, 70, 90, 30);
        btnVotar.addActionListener(this);
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
        btnMostrarResultados.addActionListener(this);
        btnSiguienteRonda.addActionListener(this);
        panelSur.add(btnMostrarResultados);
        panelSur.add(btnSiguienteRonda);
        return panelSur;
    }

    private void cargarCombo()
    {
        ArrayList<Cardenal> lista = control.getGestor().getCardenales();
        for (int i = 0; i < lista.size(); i++)
        {
            cmbCardenales.addItem(lista.get(i));
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnVotar)
        {
            votar();
        }
        else if (e.getSource() == btnMostrarResultados)
        {
            mostrar();
        }
        else if (e.getSource() == btnSiguienteRonda)
        {
            siguiente();
        }
    }

    private void votar()
    {
        Cardenal elegido = (Cardenal) cmbCardenales.getSelectedItem();
        if (elegido == null)
        {
            return;
        }
        boolean ok = control.votar(elegido);
        if (!ok)
        {
            JOptionPane.showMessageDialog(this, "No se puede votar");
        }
        mostrar();
        if (control.rondaCerrada())
        {
            btnVotar.setEnabled(false);
        }
        if (control.getGestor().getPapa() != null)
        {
            btnSiguienteRonda.setEnabled(false);
            btnVotar.setEnabled(false);
        }
    }

    private void siguiente()
    {
        if (control.getGestor().getPapa() != null)
        {
            btnSiguienteRonda.setEnabled(false);
            return;
        }
        boolean ok = control.siguienteRonda();
        if (!ok)
        {
            JOptionPane.showMessageDialog(this, "Cierre la ronda antes de continuar");
            return;
        }
        btnVotar.setEnabled(true);
        txtNumRonda.setText("" + control.getGestor().getRondaActual().getNumero());
        mostrar();
    }

    private void mostrar()
    {
        String texto = "ELECTORES\n" + control.electores() + "\n" + control.resultados();
        areaResultado.setText(texto);
        txtNumRonda.setText("" + control.getGestor().getRondaActual().getNumero());
    }
}
