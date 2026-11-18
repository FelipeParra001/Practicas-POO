package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JFArmarBinomio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFArmarBinomio extends JFrame
{
    private JComboBox<String> cmbGuia;
    private JComboBox<String> cmbPerro;
    private JComboBox<String> cmbEquipo;
    private JTextArea txtMensaje;
    
    //Botones
    
    private JButton btnArmar;
    private JButton btnCancelar;


    public JFArmarBinomio(  ) {
      
        setTitle("Armar binomio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(480, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(crearNorte(), BorderLayout.NORTH);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearSur(), BorderLayout.SOUTH);
    }

    private JPanel crearNorte() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(15, 32, 68));
        barra.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        JLabel titulo = new JLabel("K-SAR ECID");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        JLabel sub = new JLabel("Armar binomio");
        sub.setForeground(new Color(200, 210, 230));
        JPanel t = new JPanel();
        t.setLayout(new BoxLayout(t, BoxLayout.Y_AXIS));
        t.setOpaque(false);
        t.add(titulo);
        t.add(sub);
        ImageIcon icono = new ImageIcon("imagen/logo.png");
        Image img = icono.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        JPanel izq = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        izq.setOpaque(false);
        izq.add(new JLabel(new ImageIcon(img)));
        izq.add(t);
        barra.add(izq, BorderLayout.WEST);
        return barra;
    }

    private JPanel crearCentro() {
        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBackground(Color.WHITE);
        centro.setBorder(BorderFactory.createTitledBorder("Seleccionar"));

        cmbGuia = new JComboBox<>();
        cmbPerro = new JComboBox<>();
        cmbEquipo = new JComboBox<>();
        

        agregar(centro, 0, "Guía disponible:", cmbGuia);
        agregar(centro, 1, "Perro disponible:", cmbPerro);
        agregar(centro, 2, "Equipo:", cmbEquipo);

        txtMensaje = new JTextArea(3, 18);
        txtMensaje.setEditable(false);
        txtMensaje.setLineWrap(true);
        agregar(centro, 3, "", new JScrollPane(txtMensaje));
        return centro;
    }

    private void agregar(JPanel p, int fila, String et, JComponent c) {
        GridBagConstraints g = new GridBagConstraints();
        g.gridy = fila; g.insets = new Insets(5, 6, 5, 6); g.anchor = GridBagConstraints.WEST;
        g.gridx = 0; p.add(new JLabel(et), g);
        g.gridx = 1; g.weightx = 1; g.fill = GridBagConstraints.HORIZONTAL; p.add(c, g);
    }

     private JPanel crearSur() {
        JPanel sur = new JPanel(new FlowLayout());
        sur.setBackground(Color.WHITE);
        btnArmar = new JButton("Armar binomio");
        btnArmar.setBackground(new Color(15, 32, 68));
        btnArmar.setForeground(Color.WHITE);
        btnArmar.setFocusPainted(false);
      
        btnCancelar = new JButton("Cancelar");
     
        sur.add(btnArmar);
        sur.add(btnCancelar);
        return sur;
    }

    //Start GetterSetterExtension Source Code

    /**GET Method Propertie cmbGuia*/
    public JComboBox<String> getCmbGuia(){
        return this.cmbGuia;
    }//end method getCmbGuia

    /**GET Method Propertie cmbPerro*/
    public JComboBox<String> getCmbPerro(){
        return this.cmbPerro;
    }//end method getCmbPerro

    /**GET Method Propertie cmbEquipo*/
    public JComboBox<String> getCmbEquipo(){
        return this.cmbEquipo;
    }//end method getCmbEquipo

    /**GET Method Propertie txtMensaje*/
    public JTextArea getTxtMensaje(){
        return this.txtMensaje;
    }//end method getTxtMensaje

    /**GET Method Propertie btnArmar*/
    public JButton getBtnArmar(){
        return this.btnArmar;
    }//end method getBtnArmar

    /**GET Method Propertie btnCancelar*/
    public JButton getBtnCancelar(){
        return this.btnCancelar;
    }//end method getBtnCancelar

   //End GetterSetterExtension Source Code
}
