package controlador;

import modelo.*;
import vista.*;
import java.awt.event.*;

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
        String codigo = viewGestion.getTxtCodigo().getText();
        String descripcion = viewGestion.getTxtDescripcion().getText();
        String tipo = viewGestion.getTxtTipo().getText();
        int nivel;
        try {
            nivel = Integer.parseInt(viewGestion.getTxtNivel().getText());
        } catch (NumberFormatException ex) {
            viewGestion.getAreaSalida().setText("Nivel debe ser un número entero.");
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
