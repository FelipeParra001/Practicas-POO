package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Registrar perro (Andrés).
 * Acciones en la vista. Mensaje en TextArea al registrar.
 */
public class JFRegistrarPerro extends JFrame
{
 
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtRaza;
    private JTextField txtEdad;
    private JComboBox<String> cmbCertificacion;
    private JTextField txtCodigoAct;
    private JComboBox<String> cmbCertAct;
    private JTextArea txtMensaje;
 
     // Botones 
    private JButton btnActualizar;
    private JButton btnGuardar;
    private JButton btnCancelar;
    public JFRegistrarPerro( ) {
      
        setTitle("Registrar perro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 560);
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
        JLabel subtitulo = new JLabel("Registro de perro");
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

        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(Color.WHITE);
        datos.setBorder(BorderFactory.createTitledBorder("Datos del perro"));
        txtNombre = new JTextField(15);
        txtDescripcion = new JTextArea(2, 15);
        txtDescripcion.setLineWrap(true);
        txtRaza = new JTextField(15);
        txtEdad = new JTextField(15);
        cmbCertificacion = new JComboBox<>(new String[]{"VIGENTE", "VENCIDA", "EN_TRAMITE"});
        agregarFila(datos, 0, "Nombre:", txtNombre);
        agregarFila(datos, 1, "Descripción:", new JScrollPane(txtDescripcion));
        agregarFila(datos, 2, "Raza:", txtRaza);
        agregarFila(datos, 3, "Edad:", txtEdad);
        agregarFila(datos, 4, "Certificación:", cmbCertificacion);

        // RF4 (Andrés)
          JPanel act = new JPanel(new GridBagLayout());
        act.setBackground(Color.WHITE);
        act.setBorder(BorderFactory.createTitledBorder("Actualizar certificación"));
        txtCodigoAct = new JTextField(15);
        cmbCertAct = new JComboBox<>(new String[]{"VIGENTE", "VENCIDA", "EN_TRAMITE"});
        agregarFila(act, 0, "Código:", txtCodigoAct);
        agregarFila(act, 1, "Nueva certificación:", cmbCertAct);
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(15, 32, 68));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        
        agregarFila(act, 2, "", btnActualizar);

        txtMensaje = new JTextArea(3, 20);
        txtMensaje.setEditable(false);
        txtMensaje.setLineWrap(true);

        centro.add(datos);
        centro.add(act);
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
        btnGuardar = new JButton("Guardar perro");
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

    /**GET Method Propertie txtDescripcion*/
    public JTextArea getTxtDescripcion(){
        return this.txtDescripcion;
    }//end method getTxtDescripcion

    /**GET Method Propertie txtRaza*/
    public JTextField getTxtRaza(){
        return this.txtRaza;
    }//end method getTxtRaza

    /**GET Method Propertie txtEdad*/
    public JTextField getTxtEdad(){
        return this.txtEdad;
    }//end method getTxtEdad

    /**GET Method Propertie cmbCertificacion*/
    public JComboBox<String> getCmbCertificacion(){
        return this.cmbCertificacion;
    }//end method getCmbCertificacion

    /**GET Method Propertie txtCodigoAct*/
    public JTextField getTxtCodigoAct(){
        return this.txtCodigoAct;
    }//end method getTxtCodigoAct

    /**GET Method Propertie cmbCertAct*/
    public JComboBox<String> getCmbCertAct(){
        return this.cmbCertAct;
    }//end method getCmbCertAct

    /**GET Method Propertie txtMensaje*/
    public JTextArea getTxtMensaje(){
        return this.txtMensaje;
    }//end method getTxtMensaje

    /**GET Method Propertie btnActualizar*/
    public JButton getBtnActualizar(){
        return this.btnActualizar;
    }//end method getBtnActualizar

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
