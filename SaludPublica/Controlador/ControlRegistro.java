package Controlador;

import Modelo.*;
import Vista.JFRegistroPersona;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador del registro de personas y distribución del bono.
 */
public class ControlRegistro implements ActionListener {
    // Atributos
    private JFRegistroPersona vista;
    private RegistroPersonas modelo;

    // Constructor
    public ControlRegistro(JFRegistroPersona vista, RegistroPersonas modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getCbTipoPersona().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);

        // Estado inicial
        habilitarSegunTipo();
    }

    // ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getCbTipoPersona()) {
            habilitarSegunTipo();
        } else if (e.getSource() == vista.getBtnGuardar()) {
            guardar();
        } else if (e.getSource() == vista.getBtnLimpiar()) {
            limpiar();
        } else if (e.getSource() == vista.getBtnBuscar()) {
            buscar();
        }
    }

    // Habilita / deshabilita campos y paneles según el tipo seleccionado
    private void habilitarSegunTipo() {
        String tipo = (String) vista.getCbTipoPersona().getSelectedItem();

        // Campos específicos
        boolean esCiudadano = "Ciudadano".equals(tipo);
        boolean esProf = "Profesional de Salud".equals(tipo);
        boolean esDocente = "Docente".equals(tipo);

        vista.getTxtInstitucion().setEnabled(esProf || esDocente);
        vista.getTxtEspecialidad().setEnabled(esProf);
        vista.getCbNivel().setEnabled(esDocente);
        vista.getChkCabezaHogar().setEnabled(esCiudadano);
        vista.getTxtEstrato().setEnabled(esCiudadano);

        // Paneles de distribución
        vista.setPanelHabilitado(vista.getPanelSalud(), esProf);
        vista.setPanelHabilitado(vista.getPanelDocente(), esDocente);
        vista.setPanelHabilitado(vista.getPanelIndependiente(), esCiudadano);
    }

    // Limpia la interfaz
    private void limpiar() {
        vista.limpiar();
        habilitarSegunTipo();
    }

    // Guardar
    private void guardar() {
        String numDoc = vista.getTxtDocumento().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();
        String direccion = vista.getTxtDireccion().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();
        String estadoCivil = (String) vista.getCbEstadoCivil().getSelectedItem();
        boolean cabeza = vista.getChkCabezaHogar().isSelected();
        String tipo = (String) vista.getCbTipoPersona().getSelectedItem();
        TipoDocumento tipoDoc = TipoDocumento.valueOf((String) vista.getCbTipoDocumento().getSelectedItem());

        if (numDoc.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Documento y Nombre son obligatorios");
            return;
        }
        if (modelo.existe(numDoc)) {
            JOptionPane.showMessageDialog(vista, "Ya existe una persona con ese documento");
            return;
        }

        int edad = 0;
        int estrato = 0;
        try {
            edad = Integer.parseInt(vista.getTxtEdad().getText().trim());
            if (vista.getTxtEstrato().isEnabled() && !vista.getTxtEstrato().getText().trim().isEmpty()) {
                estrato = Integer.parseInt(vista.getTxtEstrato().getText().trim());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Edad y Estrato deben ser números enteros");
            return;
        }
        if (edad <= 0) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser mayor que cero");
            return;
        }

        Persona persona = null;
        try {
            if ("Ciudadano".equals(tipo)) {
                double med = leerMonto(vista.getTxtMedicinaIndependiente().getText());
                double can = leerMonto(vista.getTxtCanastaFamiliar().getText());
                persona = new Ciudadano(tipoDoc, numDoc, nombre, apellido, direccion, telefono,
                                        edad, estadoCivil, estrato, cabeza,
                                        new Medicina(med), new CanastaFamiliar(can));
            } else if ("Profesional de Salud".equals(tipo)) {
                String inst = vista.getTxtInstitucion().getText().trim();
                String esp = vista.getTxtEspecialidad().getText().trim();
                double bio = leerMonto(vista.getTxtElementoBioseguridad().getText());
                double med = leerMonto(vista.getTxtMedicinaSalud().getText());
                persona = new ProfesionalSalud(tipoDoc, numDoc, nombre, apellido, direccion, telefono,
                                               edad, estadoCivil, estrato, cabeza, inst, esp,
                                               new ElementoBioseguridad(bio), new Medicina(med));
            } else if ("Docente".equals(tipo)) {
                String inst = vista.getTxtInstitucion().getText().trim();
                String nivel = (String) vista.getCbNivel().getSelectedItem();
                double imp = leerMonto(vista.getTxtImplementosTecnologicos().getText());
                double serv = leerMonto(vista.getTxtInternetEnergia().getText());
                persona = new Docente(tipoDoc, numDoc, nombre, apellido, direccion, telefono,
                                      edad, estadoCivil, estrato, cabeza, inst, nivel,
                                      new ImplementoTecnologico(imp), new Servicio(serv));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Los montos deben ser números mayores o iguales a cero");
            return;
        }

        if (persona == null) {
            return;
        }
        if (!modelo.guardar(persona)) {
            JOptionPane.showMessageDialog(vista,
                "La distribución supera el monto del bono asignado ($" + persona.getBono().getMonto() + ")",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(vista, "Persona guardada correctamente.\nTotal registrados: " + modelo.getCantidad());
        limpiar();
    }

    // Buscar por documento
    private void buscar() {
        String doc = vista.getTxtDocumento().getText().trim();
        if (doc.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el número de documento a buscar");
            return;
        }
        Persona p = modelo.buscar(doc);
        if (p != null) {
            JOptionPane.showMessageDialog(vista, p.toString(), "Datos encontrados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontró ninguna persona con ese documento");
        }
    }

    // Convierte el texto de un monto (vacío = 0). Lanza NumberFormatException si no es válido
    private double leerMonto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        double monto = Double.parseDouble(texto.trim());
        if (monto < 0) {
            throw new NumberFormatException("Monto negativo");
        }
        return monto;
    }
}
