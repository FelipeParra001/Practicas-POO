package controlador;

import modelo.*;
import vista.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Control implements ActionListener {

    private GestorRiesgos modelGestor;
    private JFGestion viewGestion;

    public Control(GestorRiesgos modelGestor, JFGestion viewGestion) {
        this.modelGestor = modelGestor;
        this.viewGestion = viewGestion;

        this.viewGestion.getBtnAgregar().addActionListener(this);
        this.viewGestion.getBtnBuscar().addActionListener(this);
        this.viewGestion.getBtnEliminar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewGestion.getBtnAgregar()) {
            agregar();
        } else if (e.getSource() == viewGestion.getBtnBuscar()) {
            buscar();
        } else if (e.getSource() == viewGestion.getBtnEliminar()) {
            eliminar();
        }
    }

    // Acción botón Agregar
    private void agregar() {
        String codigo = viewGestion.getTxtCodigo().getText().trim();
        String descripcion = viewGestion.getTxtDescripcion().getText().trim();
        String tipo = viewGestion.getTxtTipo().getText().trim();
        String textoNivel = viewGestion.getTxtNivel().getText().trim();

        // Validar que no haya campos vacios
        if (codigo.equals("") || descripcion.equals("") || tipo.equals("") || textoNivel.equals("")) {
            JOptionPane.showMessageDialog(viewGestion, "Complete todos los campos.");
            return;
        }

        int nivel;
        try {
            nivel = Integer.parseInt(textoNivel);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(viewGestion, "Nivel debe ser un número entero.");
            return;
        }

        // El nivel de peligro va de 1 a 5
        if (nivel < 1 || nivel > 5) {
            JOptionPane.showMessageDialog(viewGestion, "El nivel debe estar entre 1 y 5.");
            return;
        }

        Riesgo r = new Riesgo(codigo, descripcion, tipo, nivel);
        if (modelGestor.agregarRiesgo(r)) {
            viewGestion.getAreaSalida().setText("✔ Riesgo agregado\n\n" + modelGestor.listarRiesgos());
        } else {
            viewGestion.getAreaSalida().setText("✘ Ya existe un riesgo con ese código.");
        }
    }

    // Acción botón Buscar
    private void buscar() {
        String codigo = viewGestion.getTxtCodigo().getText();
        Riesgo r = modelGestor.buscarPorCodigo(codigo);
        if (r != null) {
            viewGestion.getAreaSalida().setText("✔ Riesgo encontrado:\n\n" + r.toString());
        } else {
            viewGestion.getAreaSalida().setText("✘ No se encontró ese riesgo.");
        }
    }

    // Acción botón Eliminar
    private void eliminar() {
        String codigo = viewGestion.getTxtCodigo().getText();
        if (modelGestor.eliminarRiesgo(codigo)) {
            viewGestion.getAreaSalida().setText("✔ Riesgo eliminado\n\n" + modelGestor.listarRiesgos());
        } else {
            viewGestion.getAreaSalida().setText("✘ No se encontró ese riesgo.");
        }
    }
}
