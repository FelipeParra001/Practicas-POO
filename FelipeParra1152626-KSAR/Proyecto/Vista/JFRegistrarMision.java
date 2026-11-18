package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.lang.*;
/**
 * Write a description of class JFRegistrarMision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFRegistrarMision extends JFrame
{
 
    private JTextField txtCodigo;
    private JComboBox<String> cmbEvento;
    private JPanelFecha pnlFecha;
    private JComboBox<String> cmbEquipo;
    private JComboBox<String> cmbBinomio;
    private JTextField txtLugar;
    private JTextField txtMunicipio;
    private JTextField txtHoras;
    private JTextField txtSobrevivientes;
    private JTextField txtFallecidos;
    private JTextArea txtMensaje;
   
 
    
    //Botones
    private JButton btnGuardar;
    private JButton btnCancelar;

    public JFRegistrarMision( ) {
       
      
        setTitle("Registrar misión");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(crearNorte(), BorderLayout.NORTH);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearSur(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
    
    private JPanel crearNorte() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(15, 32, 68));
        barra.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        JLabel titulo = new JLabel("K-SAR ECID");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        JLabel subtitulo = new JLabel("Registro de misión");
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
         JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(Color.WHITE);

        // RF1 - datos de la misión
        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(Color.WHITE);
        datos.setBorder(BorderFactory.createTitledBorder("Datos de la misión"));

        txtCodigo = new JTextField(15);
        txtCodigo.setEditable(false);
      
        cmbEvento = new JComboBox<>();
        pnlFecha = new JPanelFecha();
        cmbEquipo = new JComboBox<>();
        cmbBinomio = new JComboBox<>();
        txtLugar = new JTextField(15);
        txtLugar.setEditable(false);
        txtMunicipio = new JTextField(15);
        txtMunicipio.setEditable(false);
        txtHoras = new JTextField(15);
        txtSobrevivientes = new JTextField(15);
        txtFallecidos = new JTextField(15);

       
        agregarFila(datos, 0, "Código:", txtCodigo);
        agregarFila(datos, 1, "Evento atendido:", cmbEvento);
        agregarFila(datos, 2, "Fecha de la misión:", pnlFecha);
        agregarFila(datos, 3, "Equipo:", cmbEquipo);
        agregarFila(datos, 4, "Binomio:", cmbBinomio);
        agregarFila(datos, 5, "Lugar:", txtLugar);
        agregarFila(datos, 6, "Municipio:", txtMunicipio);
        agregarFila(datos, 7, "Horas de labor:", txtHoras);
        agregarFila(datos, 8, "Sobrevivientes:", txtSobrevivientes);
        agregarFila(datos, 9, "Fallecidos:", txtFallecidos);

        txtMensaje = new JTextArea(4, 20);
        txtMensaje.setEditable(false);
        txtMensaje.setLineWrap(true);
        txtMensaje.setWrapStyleWord(true);
        txtMensaje.setBackground(new Color(245, 245, 245));

        centro.add(datos, BorderLayout.NORTH);
        centro.add(new JScrollPane(txtMensaje), BorderLayout.CENTER);
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
        btnGuardar = new JButton("Guardar misión");
        btnGuardar.setBackground(new Color(15, 32, 68));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFocusPainted(false);
       
        sur.add(btnGuardar);
        sur.add(btnCancelar);
        return sur;
    }
    
   
     /**GET Method Propertie txtCodigo*/
    public JTextField getTxtCodigo(){
        return this.txtCodigo;
    }//end method getTxtCodigo

    /**GET Method Propertie cmbEvento*/
    public JComboBox<String> getCmbEvento(){
        return this.cmbEvento;
    }//end method getCmbEvento

    /**GET Method Propertie pnlFecha*/
    public JPanelFecha getPnlFecha(){
        return this.pnlFecha;
    }//end method getPnlFecha

    /**GET Method Propertie cmbEquipo*/
    public JComboBox<String> getCmbEquipo(){
        return this.cmbEquipo;
    }//end method getCmbEquipo

    /**GET Method Propertie cmbBinomio*/
    public JComboBox<String> getCmbBinomio(){
        return this.cmbBinomio;
    }//end method getCmbBinomio

    /**GET Method Propertie txtLugar*/
    public JTextField getTxtLugar(){
        return this.txtLugar;
    }//end method getTxtLugar

    /**GET Method Propertie txtMunicipio*/
    public JTextField getTxtMunicipio(){
        return this.txtMunicipio;
    }//end method getTxtMunicipio

    /**GET Method Propertie txtHoras*/
    public JTextField getTxtHoras(){
        return this.txtHoras;
    }//end method getTxtHoras

    /**GET Method Propertie txtSobrevivientes*/
    public JTextField getTxtSobrevivientes(){
        return this.txtSobrevivientes;
    }//end method getTxtSobrevivientes

    /**GET Method Propertie txtFallecidos*/
    public JTextField getTxtFallecidos(){
        return this.txtFallecidos;
    }//end method getTxtFallecidos

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