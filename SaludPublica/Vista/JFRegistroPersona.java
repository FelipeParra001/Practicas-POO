package Vista;

import Modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Formulario de registro de personas y distribución del bono.
 * Se abre solo al crear el objeto (sin clase Main).
 */
public class JFRegistroPersona extends JFrame implements ActionListener {

    // Componentes del panel de datos básicos
    private JComboBox<TipoDocumento> cbTipoDocumento;
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

    // Lista de personas (polimorfismo)
    private ArrayList<Persona> personas;

    // Constructor
    public JFRegistroPersona() {
        personas = new ArrayList<Persona>();

        setTitle("Registro datos básicos");
        setSize(900, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        crearPanelIzquierdo();
        crearPanelDerecho();

        // Estado inicial
        habilitarSegunTipo();

        setVisible(true);
    }

    // Panel izquierdo: datos básicos
    private void crearPanelIzquierdo() {
        JPanel panel = new JPanel(new GridLayout(14, 2, 8, 6));
        panel.setBorder(BorderFactory.createTitledBorder("Registro datos básicos"));

        panel.add(new JLabel("Tipo Documento"));
        cbTipoDocumento = new JComboBox<TipoDocumento>(TipoDocumento.values());
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
        cbTipoPersona.addActionListener(this);
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
        btnGuardar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnBuscar.addActionListener(this);
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

    // Habilita / deshabilita campos y paneles según el tipo seleccionado
    private void habilitarSegunTipo() {
        String tipo = (String) cbTipoPersona.getSelectedItem();

        // Campos específicos
        boolean esCiudadano = "Ciudadano".equals(tipo);
        boolean esProf = "Profesional de Salud".equals(tipo);
        boolean esDocente = "Docente".equals(tipo);

        txtInstitucion.setEnabled(esProf || esDocente);
        txtEspecialidad.setEnabled(esProf);
        cbNivel.setEnabled(esDocente);
        chkCabezaHogar.setEnabled(esCiudadano);
        txtEstrato.setEnabled(esCiudadano);

        // Paneles de distribución
        panelSalud.setEnabled(esProf);
        setPanelEnabled(panelSalud, esProf);
        panelDocente.setEnabled(esDocente);
        setPanelEnabled(panelDocente, esDocente);
        panelIndependiente.setEnabled(esCiudadano);
        setPanelEnabled(panelIndependiente, esCiudadano);
    }

    private void setPanelEnabled(JPanel panel, boolean enabled) {
        for (Component c : panel.getComponents()) {
            c.setEnabled(enabled);
        }
    }

    // Limpia todos los campos
    private void limpiar() {
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

        habilitarSegunTipo();
    }

    // Guardar
    private void guardar() {
        try {
            TipoDocumento tipoDoc = (TipoDocumento) cbTipoDocumento.getSelectedItem();
            String numDoc = txtDocumento.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String telefono = txtTelefono.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            int estrato = 0;
            if (txtEstrato.isEnabled() && !txtEstrato.getText().trim().isEmpty()) {
                estrato = Integer.parseInt(txtEstrato.getText().trim());
            }
            String estadoCivil = (String) cbEstadoCivil.getSelectedItem();
            boolean cabeza = chkCabezaHogar.isSelected();
            String tipo = (String) cbTipoPersona.getSelectedItem();

            if (numDoc.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Documento y Nombre son obligatorios");
                return;
            }

            Persona persona = null;

            if ("Ciudadano".equals(tipo)) {
                double med = parseDouble(txtMedicinaIndependiente.getText());
                double can = parseDouble(txtCanastaFamiliar.getText());
                Medicina medicina = new Medicina(med);
                CanastaFamiliar canasta = new CanastaFamiliar(can);
                persona = new Ciudadano(tipoDoc, numDoc, nombre, apellido, direccion, telefono,
                                        edad, estadoCivil, estrato, cabeza, medicina, canasta);
            } else if ("Profesional de Salud".equals(tipo)) {
                String inst = txtInstitucion.getText().trim();
                String esp = txtEspecialidad.getText().trim();
                double bio = parseDouble(txtElementoBioseguridad.getText());
                double med = parseDouble(txtMedicinaSalud.getText());
                ElementoBioseguridad elemento = new ElementoBioseguridad(bio);
                Medicina medicina = new Medicina(med);
                persona = new ProfesionalSalud(tipoDoc, numDoc, nombre, apellido, direccion, telefono,
                                               edad, estadoCivil, estrato, cabeza, inst, esp, elemento, medicina);
            } else if ("Docente".equals(tipo)) {
                String inst = txtInstitucion.getText().trim();
                String nivel = (String) cbNivel.getSelectedItem();
                double imp = parseDouble(txtImplementosTecnologicos.getText());
                double serv = parseDouble(txtInternetEnergia.getText());
                ImplementoTecnologico implemento = new ImplementoTecnologico(imp);
                Servicio servicio = new Servicio(serv);
                persona = new Docente(tipoDoc, numDoc, nombre, apellido, direccion, telefono,
                                      edad, estadoCivil, estrato, cabeza, inst, nivel, implemento, servicio);
            }

            if (persona != null) {
                if (!persona.distribucionValida()) {
                    JOptionPane.showMessageDialog(this,
                        "La distribución supera el monto del bono asignado ($" + persona.getBono().getMonto() + ")",
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                personas.add(persona);
                JOptionPane.showMessageDialog(this, "Persona guardada correctamente.\nTotal registrados: " + personas.size());
                limpiar();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Revise los campos numéricos (Edad, Estrato y montos)");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }

    // Buscar por documento
    private void buscar() {
        String doc = txtDocumento.getText().trim();
        if (doc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de documento a buscar");
            return;
        }
        for (Persona p : personas) {
            if (p.getNumDocumento().equals(doc)) {
                JOptionPane.showMessageDialog(this, p.toString(), "Datos encontrados", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontró ninguna persona con ese documento");
    }

    private double parseDouble(String texto) {
        if (texto == null || texto.trim().isEmpty()) return 0;
        return Double.parseDouble(texto.trim());
    }

    // ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbTipoPersona) {
            habilitarSegunTipo();
        } else if (e.getSource() == btnGuardar) {
            guardar();
        } else if (e.getSource() == btnLimpiar) {
            limpiar();
        } else if (e.getSource() == btnBuscar) {
            buscar();
        }
    }
}
