package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class JFRegistrarEvento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFRegistrarEvento  extends JFrame
{
      // Datos del evento
    private JComboBox<String> cmbTipo;
    private JPanelFecha pnlFecha;
    private JTextField txtMagnitud;
    private JTextField txtEpicentro;
    private JTextField txtVolumen;
    private JTextField txtZona;

    // Ubicacion del evento
    private JTextField txtPais;
    private JTextField txtCodigo;
    private JTextField txtMunicipio;
    private JTextField txtLugar;
    private JTextField txtCalle;
    private JTextField txtNumero;
    private JTextField txtBarrio;

    private JTextArea txtMensaje;
    
    // Botones
    
    private JButton btnUbicacion;
    private JButton btnGuardar;
    private JButton btnCancelar;
    
     public JFRegistrarEvento( ) {
        
         
        setTitle("Registrar evento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(crearNorte(), BorderLayout.NORTH);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearSur(), BorderLayout.SOUTH);
        cambiarTipo();
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
        JLabel subtitulo = new JLabel("Registro de evento");
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

     
        JPanel general = new JPanel(new GridBagLayout());
        general.setBackground(Color.WHITE);
        general.setBorder(BorderFactory.createTitledBorder("Datos del evento"));
        cmbTipo = new JComboBox<>(new String[]{"Terremoto", "Deslave"});
        
        pnlFecha = new JPanelFecha();
        agregarFila(general, 0, "Tipo de evento:", cmbTipo);
        agregarFila(general, 1, "Fecha del evento:", pnlFecha);

        
        JPanel medio = new JPanel(new GridLayout(1, 2));
        medio.setBackground(Color.WHITE);

        JPanel tipos = new JPanel(new GridLayout(2, 1));
        tipos.setBackground(Color.WHITE);

        JPanel terremoto = new JPanel(new GridBagLayout());
        terremoto.setBackground(Color.WHITE);
        terremoto.setBorder(BorderFactory.createTitledBorder("Datos del terremoto"));
        txtMagnitud = new JTextField(15);
        txtEpicentro = new JTextField(15);
        agregarFila(terremoto, 0, "Magnitud (Richter, 1 decimal):", txtMagnitud);
        agregarFila(terremoto, 1, "Epicentro:", txtEpicentro);

        JPanel deslave = new JPanel(new GridBagLayout());
        deslave.setBackground(Color.WHITE);
        deslave.setBorder(BorderFactory.createTitledBorder("Datos del deslave"));
        txtVolumen = new JTextField(15);
        txtZona = new JTextField(15);
        agregarFila(deslave, 0, "Volumen (m³, entero):", txtVolumen);
        agregarFila(deslave, 1, "Zona afectada:", txtZona);

        tipos.add(terremoto);
        tipos.add(deslave);

        JPanel ubicacion = new JPanel(new GridBagLayout());
        ubicacion.setBackground(Color.WHITE);
        ubicacion.setBorder(BorderFactory.createTitledBorder("Ubicación del evento"));
        txtPais = new JTextField(15);
        txtCodigo = new JTextField(15);
        txtMunicipio = new JTextField(15);
        txtLugar = new JTextField(15);
        txtCalle = new JTextField(15);
        txtNumero = new JTextField(15);
        txtBarrio = new JTextField(15);
        agregarFila(ubicacion, 0, "País:", txtPais);
        agregarFila(ubicacion, 1, "Código del país:", txtCodigo);
        agregarFila(ubicacion, 2, "Municipio:", txtMunicipio);
        agregarFila(ubicacion, 3, "Lugar:", txtLugar);
        agregarFila(ubicacion, 4, "Calle / avenida:", txtCalle);
        agregarFila(ubicacion, 5, "Número:", txtNumero);
        agregarFila(ubicacion, 6, "Barrio:", txtBarrio);
        btnUbicacion = new JButton("Registrar ubicación");
        btnUbicacion.setFocusPainted(false);
     
        agregarFila(ubicacion, 7, "", btnUbicacion);
        
      
        medio.add(tipos);
        medio.add(ubicacion);

        txtMensaje = new JTextArea(4, 20);
        txtMensaje.setEditable(false);
        txtMensaje.setLineWrap(true);
        txtMensaje.setWrapStyleWord(true);
        txtMensaje.setBackground(new Color(245, 245, 245));

        centro.add(general, BorderLayout.NORTH);
        centro.add(medio, BorderLayout.CENTER);
        centro.add(new JScrollPane(txtMensaje), BorderLayout.SOUTH);
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
        btnGuardar = new JButton("Guardar evento");
        btnGuardar.setBackground(new Color(15, 32, 68));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFocusPainted(false);
       
        sur.add(btnGuardar);
        sur.add(btnCancelar);
        return sur;
    }

    
    public void cambiarTipo() {
        boolean esTerremoto = cmbTipo.getSelectedItem().equals("Terremoto");
        txtMagnitud.setEnabled(esTerremoto);
        txtEpicentro.setEnabled(esTerremoto);
        txtVolumen.setEnabled(!esTerremoto);
        txtZona.setEnabled(!esTerremoto);
        if (esTerremoto) {
            txtVolumen.setText("");
            txtZona.setText("");
        } else {
            txtMagnitud.setText("");
            txtEpicentro.setText("");
        }
    }

     //Start GetterSetterExtension Source Code

    /**GET Method Propertie cmbTipo*/
    public JComboBox<String> getCmbTipo(){
        return this.cmbTipo;
    }//end method getCmbTipo

    /**GET Method Propertie pnlFecha*/
    public JPanelFecha getPnlFecha(){
        return this.pnlFecha;
    }//end method getPnlFecha

    /**GET Method Propertie txtMagnitud*/
    public JTextField getTxtMagnitud(){
        return this.txtMagnitud;
    }//end method getTxtMagnitud

    /**GET Method Propertie txtEpicentro*/
    public JTextField getTxtEpicentro(){
        return this.txtEpicentro;
    }//end method getTxtEpicentro

    /**GET Method Propertie txtVolumen*/
    public JTextField getTxtVolumen(){
        return this.txtVolumen;
    }//end method getTxtVolumen

    /**GET Method Propertie txtZona*/
    public JTextField getTxtZona(){
        return this.txtZona;
    }//end method getTxtZona

    /**GET Method Propertie txtPais*/
    public JTextField getTxtPais(){
        return this.txtPais;
    }//end method getTxtPais

    /**GET Method Propertie txtCodigo*/
    public JTextField getTxtCodigo(){
        return this.txtCodigo;
    }//end method getTxtCodigo

    /**GET Method Propertie txtMunicipio*/
    public JTextField getTxtMunicipio(){
        return this.txtMunicipio;
    }//end method getTxtMunicipio

    /**GET Method Propertie txtLugar*/
    public JTextField getTxtLugar(){
        return this.txtLugar;
    }//end method getTxtLugar

    /**GET Method Propertie txtCalle*/
    public JTextField getTxtCalle(){
        return this.txtCalle;
    }//end method getTxtCalle

    /**GET Method Propertie txtNumero*/
    public JTextField getTxtNumero(){
        return this.txtNumero;
    }//end method getTxtNumero

    /**GET Method Propertie txtBarrio*/
    public JTextField getTxtBarrio(){
        return this.txtBarrio;
    }//end method getTxtBarrio

    /**GET Method Propertie txtMensaje*/
    public JTextArea getTxtMensaje(){
        return this.txtMensaje;
    }//end method getTxtMensaje

    /**GET Method Propertie btnUbicacion*/
    public JButton getBtnUbicacion(){
        return this.btnUbicacion;
    }//end method getBtnUbicacion

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