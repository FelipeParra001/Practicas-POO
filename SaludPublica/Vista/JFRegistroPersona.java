package Vista;

import java.awt.*;
import javax.swing.*;

/**
 * Formulario de registro de personas y distribución del bono.
 * Solo contiene los componentes gráficos (la lógica está en el controlador).
 */
public class JFRegistroPersona extends JFrame {

    // Componentes del panel de datos básicos
    private JComboBox<String> cbTipoDocumento;
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEdad;
    private JTextField txtEstrato;
    private JComboBox<String> cbEstadoCivil;
    private JComboBox<String> cbTipoPersona;
    private JTextField txtInstitucion;
    private JTextField txtEspecialidad;
    private JComboBox<String> cbNivel;
    private JCheckBox chkCabezaHogar;

    // Botones
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnBuscar;

    // Paneles de distribución
    private JPanel panelSalud;
    private JTextField txtElementoBioseguridad;
    private JTextField txtMedicinaSalud;

    private JPanel panelDocente;
    private JTextField txtImplementosTecnologicos;
    private JTextField txtInternetEnergia;

    private JPanel panelIndependiente;
    private JTextField txtMedicinaIndependiente;
    private JTextField txtCanastaFamiliar;

    // Constructor
    public JFRegistroPersona() {
        setTitle("Registro datos básicos");
        setSize(900, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        crearPanelIzquierdo();
        crearPanelDerecho();
    }

    // Panel izquierdo: datos básicos
    private void crearPanelIzquierdo() {
        JPanel panel = new JPanel(new GridLayout(14, 2, 8, 6));
        panel.setBorder(BorderFactory.createTitledBorder("Registro datos básicos"));

        panel.add(new JLabel("Tipo Documento"));
        cbTipoDocumento = new JComboBox<String>(new String[]{"CEDULA_CIUDADANIA", "TARJETA_DE_IDENTIDAD", "CEDULA_EXTRANJERIA"});
        panel.add(cbTipoDocumento);

        panel.add(new JLabel("Documento"));
        txtDocumento = new JTextField();
        panel.add(txtDocumento);

        panel.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellido"));
        txtApellido = new JTextField();
        panel.add(txtApellido);

        panel.add(new JLabel("Direccion"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);

        panel.add(new JLabel("Telefono"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("Edad"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        panel.add(new JLabel("Estrate"));
        txtEstrato = new JTextField();
        panel.add(txtEstrato);

        panel.add(new JLabel("Estado Civil"));
        cbEstadoCivil = new JComboBox<String>(new String[]{"Soltero", "Casado", "Unión Libre", "Viudo", "Divorciado"});
        panel.add(cbEstadoCivil);

        panel.add(new JLabel("Tipo"));
        cbTipoPersona = new JComboBox<String>(new String[]{"Ciudadano", "Profesional de Salud", "Docente"});
        panel.add(cbTipoPersona);

        panel.add(new JLabel("Institucion"));
        txtInstitucion = new JTextField();
        panel.add(txtInstitucion);

        panel.add(new JLabel("Especialidad"));
        txtEspecialidad = new JTextField();
        panel.add(txtEspecialidad);

        panel.add(new JLabel("Nivel"));
        cbNivel = new JComboBox<String>(new String[]{"Preescolar", "Primaria", "Secundaria", "Media", "Superior"});
        panel.add(cbNivel);

        panel.add(new JLabel(""));
        chkCabezaHogar = new JCheckBox("Cabeza de hogar");
        panel.add(chkCabezaHogar);

        add(panel, BorderLayout.WEST);
    }

    // Panel derecho: botones + paneles de distribución
    private void crearPanelDerecho() {
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));

        // Panel botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 0));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Panel botones"));
        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");
        btnBuscar = new JButton("Buscar");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnBuscar);
        panelDerecho.add(panelBotones);
        panelDerecho.add(Box.createVerticalStrut(10));

        // Panel 3 - Prof Salud
        panelSalud = new JPanel(new GridLayout(2, 2, 8, 8));
        panelSalud.setBorder(BorderFactory.createTitledBorder("Distribución Bono Prof Salud"));
        panelSalud.add(new JLabel("Elemento Bioseguridad"));
        txtElementoBioseguridad = new JTextField();
        panelSalud.add(txtElementoBioseguridad);
        panelSalud.add(new JLabel("Medicina"));
        txtMedicinaSalud = new JTextField();
        panelSalud.add(txtMedicinaSalud);
        panelDerecho.add(panelSalud);
        panelDerecho.add(Box.createVerticalStrut(8));

        // Panel 4 - Docente
        panelDocente = new JPanel(new GridLayout(2, 2, 8, 8));
        panelDocente.setBorder(BorderFactory.createTitledBorder("Distribución Bono Docente"));
        panelDocente.add(new JLabel("Implementos Tecnológicos"));
        txtImplementosTecnologicos = new JTextField();
        panelDocente.add(txtImplementosTecnologicos);
        panelDocente.add(new JLabel("Servicio Internet / Energía"));
        txtInternetEnergia = new JTextField();
        panelDocente.add(txtInternetEnergia);
        panelDerecho.add(panelDocente);
        panelDerecho.add(Box.createVerticalStrut(8));

        // Panel 5 - Independiente / Ciudadano
        panelIndependiente = new JPanel(new GridLayout(2, 2, 8, 8));
        panelIndependiente.setBorder(BorderFactory.createTitledBorder("Distribución Bono Persona Independiente"));
        panelIndependiente.add(new JLabel("Medicina"));
        txtMedicinaIndependiente = new JTextField();
        panelIndependiente.add(txtMedicinaIndependiente);
        panelIndependiente.add(new JLabel("Canasta Familiar"));
        txtCanastaFamiliar = new JTextField();
        panelIndependiente.add(txtCanastaFamiliar);
        panelDerecho.add(panelIndependiente);

        add(panelDerecho, BorderLayout.CENTER);
    }

    // Habilita o deshabilita todos los componentes de un panel
    public void setPanelHabilitado(JPanel panel, boolean habilitado) {
        panel.setEnabled(habilitado);
        for (Component c : panel.getComponents()) {
            c.setEnabled(habilitado);
        }
    }

    // Limpia todos los campos
    public void limpiar() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEdad.setText("");
        txtEstrato.setText("");
        txtInstitucion.setText("");
        txtEspecialidad.setText("");
        chkCabezaHogar.setSelected(false);
        cbTipoDocumento.setSelectedIndex(0);
        cbEstadoCivil.setSelectedIndex(0);
        cbTipoPersona.setSelectedIndex(0);
        cbNivel.setSelectedIndex(0);

        txtElementoBioseguridad.setText("");
        txtMedicinaSalud.setText("");
        txtImplementosTecnologicos.setText("");
        txtInternetEnergia.setText("");
        txtMedicinaIndependiente.setText("");
        txtCanastaFamiliar.setText("");
    }

    // Getters de los componentes
    public JComboBox<String> getCbTipoDocumento() { return cbTipoDocumento; }
    public JTextField getTxtDocumento() { return txtDocumento; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JTextField getTxtDireccion() { return txtDireccion; }
    public JTextField getTxtTelefono() { return txtTelefono; }
    public JTextField getTxtEdad() { return txtEdad; }
    public JTextField getTxtEstrato() { return txtEstrato; }
    public JComboBox<String> getCbEstadoCivil() { return cbEstadoCivil; }
    public JComboBox<String> getCbTipoPersona() { return cbTipoPersona; }
    public JTextField getTxtInstitucion() { return txtInstitucion; }
    public JTextField getTxtEspecialidad() { return txtEspecialidad; }
    public JComboBox<String> getCbNivel() { return cbNivel; }
    public JCheckBox getChkCabezaHogar() { return chkCabezaHogar; }

    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
    public JButton getBtnBuscar() { return btnBuscar; }

    public JPanel getPanelSalud() { return panelSalud; }
    public JTextField getTxtElementoBioseguridad() { return txtElementoBioseguridad; }
    public JTextField getTxtMedicinaSalud() { return txtMedicinaSalud; }

    public JPanel getPanelDocente() { return panelDocente; }
    public JTextField getTxtImplementosTecnologicos() { return txtImplementosTecnologicos; }
    public JTextField getTxtInternetEnergia() { return txtInternetEnergia; }

    public JPanel getPanelIndependiente() { return panelIndependiente; }
    public JTextField getTxtMedicinaIndependiente() { return txtMedicinaIndependiente; }
    public JTextField getTxtCanastaFamiliar() { return txtCanastaFamiliar; }
}
