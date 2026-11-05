package Vista;
import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class JFGestorCardenales here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFGestorCardenales  extends JFrame
{
    private JButton btnVotar;
    private JButton btnMostrarResultados;
    private JButton btnSiguienteRonda;
    private JComboBox<String> cmbCardenales;
    private JTextField txtNumRonda;
    private JTextArea areaResultado;
    
     public JFGestorCardenales(){
        
        setTitle("Votaciones Conclave");
        setSize(600, 520);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panelPrincipal.add(crearNorte(), BorderLayout.NORTH);
        panelPrincipal.add(crearCentro(), BorderLayout.CENTER);
        panelPrincipal.add(crearSur(), BorderLayout.SOUTH);
        
        add(panelPrincipal, BorderLayout.CENTER);
        
       
        setVisible(true); 
      
    }
    
      private JPanel crearNorte() {
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.setOpaque(false);
        
        JLabel lblTitulo = new JLabel("Votaciones Conclave");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelNorte.add(lblTitulo);
        
        return panelNorte;
     }
     
     private JPanel crearCentro (){
         JPanel panelCentro = new JPanel(null); 
         panelCentro.setOpaque(false);
        
      
        JLabel lblListaCardenales = new JLabel("Lista de cardenales");
        lblListaCardenales.setFont(new Font("Arial", Font.BOLD, 14));
        lblListaCardenales.setBounds(40, 20, 150, 25);
        panelCentro.add(lblListaCardenales);
        
        cmbCardenales = new JComboBox<>();
        cmbCardenales.setBounds(210, 20, 260, 25);
        panelCentro.add(cmbCardenales);
        
        
        btnVotar = new JButton("Votar");
        btnVotar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVotar.setBounds(210, 70, 90, 30);
        panelCentro.add(btnVotar);
        
        JLabel lblRonda = new JLabel("Ronda No");
        lblRonda.setFont(new Font("Arial", Font.BOLD, 14));
        lblRonda.setBounds(370, 72, 80, 25);
        panelCentro.add(lblRonda);
        
        txtNumRonda = new JTextField("1");
        txtNumRonda.setHorizontalAlignment(JTextField.CENTER);
        txtNumRonda.setEditable(false);
        txtNumRonda.setBounds(450, 72, 20, 25);
        panelCentro.add(txtNumRonda);
      
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), "Resultados", 
                javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, 
                new Font("Arial", Font.PLAIN, 14)));
        panelResultados.setOpaque(false);
        panelResultados.setBounds(30, 120, 490, 200);
        
        areaResultado = new JTextArea("Aquí se deben mostrar los resultados por ronda de votación");
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaResultado.setEditable(false);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        
        JScrollPane scroll = new JScrollPane(areaResultado);
        panelResultados.add(scroll, BorderLayout.CENTER);
        
        panelCentro.add(panelResultados);
        return panelCentro;
     }
     
      private JPanel crearSur() {
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        panelSur.setOpaque(false);
        
        btnMostrarResultados = new JButton("Mostrar Resultados");
        btnMostrarResultados.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSur.add(btnMostrarResultados);
        
        btnSiguienteRonda = new JButton("Siguiente Ronda");
        btnSiguienteRonda.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSur.add(btnSiguienteRonda);
        
        return panelSur;
    }
    
   
    }
     
     
     
