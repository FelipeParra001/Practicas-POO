package Proyecto.Vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * Write a description of class JFRegistrarEquipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFRegistrarEquipo extends JFrame
{

    private JTextField txtNombre;
    private JPanelFecha pnlFecha;
    private DefaultTableModel modeloTabla;
    private JTextArea txtMensaje;
    
    //Botones 
    private JButton btnGuardar;
    private JButton btnCancelar;

    public JFRegistrarEquipo( ) {
     
        setTitle("Registrar equipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(520, 560);
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
        JLabel subtitulo = new JLabel("Registro de equipo");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 11));
        subtitulo.setForeground(new Color(200, 210, 230));
        JPanel textos = new JPanel();
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.setOpaque(false);
        textos.add(titulo);
        textos.add(subtitulo);
        ImageIcon icono = new ImageIcon("imagen/logo.png");
        Image img = icono.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(img));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        izquierda.setOpaque(false);
        izquierda.add(logo);
        izquierda.add(textos);
        barra.add(izquierda, BorderLayout.WEST);
        return barra;
    }

    private JPanel crearCentro() {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(Color.WHITE);

        // RF1 - datos del equipo
        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(Color.WHITE);
        datos.setBorder(BorderFactory.createTitledBorder("Datos del equipo"));
        txtNombre = new JTextField(15);
        pnlFecha = new JPanelFecha();
        agregarFila(datos, 0, "Nombre del equipo:", txtNombre);
        agregarFila(datos, 1, "Fecha de creación:", pnlFecha);

        // Equipos registrados
        JPanel lista = new JPanel(new BorderLayout());
        lista.setBackground(Color.WHITE);
        lista.setBorder(BorderFactory.createTitledBorder("Equipos registrados"));
        String[] cols = {"Nombre", "Fecha de creación", "Binomios"};
        modeloTabla = new DefaultTableModel(cols, 0);
        lista.add(new JScrollPane(new JTable(modeloTabla)), BorderLayout.CENTER);

        txtMensaje = new JTextArea(3, 20);
        txtMensaje.setEditable(false);
        txtMensaje.setLineWrap(true);
        txtMensaje.setWrapStyleWord(true);
        txtMensaje.setBackground(new Color(245, 245, 245));

        centro.add(datos);
        centro.add(lista);
        centro.add(new JScrollPane(txtMensaje));
        return centro;
    }

  
    private void agregarFila(JPanel panel, int fila, String etiqueta, JComponent campo) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = fila;
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        panel.add(new JLabel(etiqueta), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campo, gbc);
    }

     private JPanel crearSur() {
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        sur.setBackground(Color.WHITE);
        btnGuardar = new JButton("Guardar equipo");
        btnGuardar.setBackground(new Color(15, 32, 68));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFocusPainted(false);
     
        sur.add(btnGuardar);
        sur.add(btnCancelar);
        return sur;
    }

    //Start GetterSetterExtension Source Code

    /**GET Method Propertie txtNombre*/
    public JTextField getTxtNombre(){
        return this.txtNombre;
    }//end method getTxtNombre

    /**GET Method Propertie pnlFecha*/
    public JPanelFecha getPnlFecha(){
        return this.pnlFecha;
    }//end method getPnlFecha

    /**GET Method Propertie modeloTabla*/
    public DefaultTableModel getModeloTabla(){
        return this.modeloTabla;
    }//end method getModeloTabla

    /**GET Method Propertie txtMensaje*/
    public JTextArea getTxtMensaje(){
        return this.txtMensaje;
    }//end method getTxtMensaje

    /**GET Method Propertie btnGuardar*/
    public JButton getBtnGuardar(){
        return this.btnGuardar;
    }//end method getBtnGuardar

    /**GET Method Propertie btnCancelar*/
    public JButton getBtnCancelar(){
        return this.btnCancelar;
    }//end method getBtnCancelar

    //End GetterSetterExtension Source Code 

}