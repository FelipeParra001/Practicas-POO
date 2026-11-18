package Proyecto.Vista;
import Proyecto.Modelo.*;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JPanelFecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPanelFecha extends JPanel 
{
     private JComboBox<Integer> cmbDia;
    private JComboBox<Integer> cmbMes;
    private JComboBox<Integer> cmbAnio;
    
    public JPanelFecha() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 6, 0));
        setOpaque(false);
        
        cmbDia = new JComboBox<>();
        for (int d = 1; d <= 31; d++) {
            cmbDia.addItem(d);
        }
        cmbMes = new JComboBox<>();
        for (int m = 1; m <= 12; m++) {
            cmbMes.addItem(m);
        }
        cmbAnio = new JComboBox<>();
        int anioActual = Fecha.hoy().getAnio();
        for (int a = anioActual; a >= 1990; a--) {
            cmbAnio.addItem(a);
        }
        
        add(Estilo.etiqueta("Día"));
        add(cmbDia);
        add(Estilo.etiqueta("Mes"));
        add(cmbMes);
        add(Estilo.etiqueta("Año"));
        add(cmbAnio);
        
        setFecha(Fecha.hoy());
    }
    
    public Fecha getFecha() {
        return new Fecha((Integer) cmbDia.getSelectedItem(),
                         (Integer) cmbMes.getSelectedItem(),
                         (Integer) cmbAnio.getSelectedItem());
    }
    
    public void setFecha(Fecha f) {
        cmbDia.setSelectedItem(f.getDia());
        cmbMes.setSelectedItem(f.getMes());
        cmbAnio.setSelectedItem(f.getAnio());
    }
    
    @Override
    public void setEnabled(boolean habilitado) {
        super.setEnabled(habilitado);
        cmbDia.setEnabled(habilitado);
        cmbMes.setEnabled(habilitado);
        cmbAnio.setEnabled(habilitado);
    }
}