package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Registrar guía (Andrés).
 * Acciones en la vista. Mensaje en TextArea al registrar.
 */
public class JFRegistrarGuia extends JFrame
{
    
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JComboBox<String> cmbCert;
    private JTextField txtCedulaAct;
    private JComboBox<String> cmbCertAct;
    private JTextArea txtMensaje;

    //Botones 
    private JButton btnActualizar;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public JFRegistrarGuia( ) {
       
        setTitle("Registrar guía");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 560);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(crearNorte("Registro de guía"), BorderLayout.NORTH);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearSur(), BorderLayout.SOUTH);
    }

    private JPanel crearNorte(String sub) {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(15, 32, 68));
        barra.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        JLabel titulo = new JLabel("K-SAR ECID");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        JLabel subtitulo = new JLabel(sub);
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
        JPanel izq = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        izq.setOpaque(false);
        izq.add(logo);
        izq.add(textos);
        barra.add(izq, BorderLayout.WEST);
        return barra;
    }

    private JPanel crearCentro() {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(Color.WHITE);

        // RF1 - datos del guía (Andrés)
        JPanel datos = new JPanel(new GridBagLayout());
        datos.setBackground(Color.WHITE);
        datos.setBorder(BorderFactory.createTitledBorder("Datos del guía"));
        txtCedula = new JTextField(15);
        txtNombre = new JTextField(15);
        cmbCert = new JComboBox<>(new String[]{"VIGENTE", "VENCIDA", "EN_TRAMITE"});
        agregarFila(datos, 0, "Cédula:", txtCedula);
        agregarFila(datos, 1, "Nombre completo:", txtNombre);
        agregarFila(datos, 2, "Certificación:", cmbCert);

        // RF4 - actualizar certificación (Andrés)
         JPanel act = new JPanel(new GridBagLayout());
        act.setBackground(Color.WHITE);
        act.setBorder(BorderFactory.createTitledBorder("Actualizar certificación"));
        txtCedulaAct = new JTextField(15);
        cmbCertAct = new JComboBox<>(new String[]{"VIGENTE", "VENCIDA", "EN_TRAMITE"});
        agregarFila(act, 0, "Cédula:", txtCedulaAct);
        agregarFila(act, 1, "Nueva certificación:", cmbCertAct);
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(15, 32, 68));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        agregarFila(act, 2, "", btnActualizar);

        txtMensaje = new JTextArea(3, 20);
        txtMensaje.setEditable(false);
        txtMensaje.setLineWrap(true);
        txtMensaje.setBackground(new Color(245, 245, 245));

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
        btnGuardar = new JButton("Guardar guía");
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

    /**GET Method Propertie txtCedula*/
    public JTextField getTxtCedula(){
        return this.txtCedula;
    }//end method getTxtCedula

    /**GET Method Propertie txtNombre*/
    public JTextField getTxtNombre(){
        return this.txtNombre;
    }//end method getTxtNombre

    /**GET Method Propertie cmbCert*/
    public JComboBox<String> getCmbCert(){
        return this.cmbCert;
    }//end method getCmbCert

    /**GET Method Propertie txtCedulaAct*/
    public JTextField getTxtCedulaAct(){
        return this.txtCedulaAct;
    }//end method getTxtCedulaAct

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
