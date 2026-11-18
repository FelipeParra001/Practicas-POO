package controlador;
import modelo.*;
import vista.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlVecindad implements ActionListener
{
    private JFVecindad vista;
    private Vecindad modelo;

    public ControlVecindad(JFVecindad vista, Vecindad modelo){
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnVerPersonajes().addActionListener(this);
        this.vista.getBtnInteractuar().addActionListener(this);
        this.vista.getBtnRelacionar().addActionListener(this);
        this.vista.getBtnMover().addActionListener(this);
        this.vista.getBtnUsarObjeto().addActionListener(this);

        vista.llenarPersonajes(modelo.getNombresPersonajes());
        vista.llenarLugares(modelo.getNombresLugares());
        actualizarUbicacion();
        verPersonajes();
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == vista.getBtnRegistrar()){
            registrar();
        }
        else if(source == vista.getBtnVerPersonajes()){
            verPersonajes();
        }
        else if(source == vista.getBtnInteractuar()){
            interactuar();
        }
        else if(source == vista.getBtnRelacionar()){
            relacionar();
        }
        else if(source == vista.getBtnMover()){
            mover();
        }
        else if(source == vista.getBtnUsarObjeto()){
            usarObjeto();
        }
    }

    // ==================== PERSONAJES (RF1) ====================

    public void registrar(){
        String nombre = vista.getTxtNombre().getText().trim();
        String textoEdad = vista.getTxtEdad().getText().trim();
        String personalidad = vista.getTxtPersonalidad().getText().trim();
        String rol = vista.getTxtRol().getText().trim();

        if(nombre.isEmpty() || textoEdad.isEmpty() || personalidad.isEmpty() || rol.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Complete todos los campos");
            return;
        }

        int edad = 0;
        try{
            edad = Integer.parseInt(textoEdad);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número entero");
            return;
        }

        if(modelo.registrarVecino(nombre, edad, personalidad, rol)){
            vista.getTxtSalida().setText("Personaje registrado correctamente");
            vista.llenarPersonajes(modelo.getNombresPersonajes());
            vista.limpiar();
        }else{
            JOptionPane.showMessageDialog(vista, "No se registró: el personaje ya existe o la edad no es válida");
        }
    }

    public void verPersonajes(){
        vista.getTxtSalida().setText(modelo.listarPersonajes());
    }

    // ==================== INTERACCION (RF2) ====================

    public void interactuar(){
        String nombre1 = (String) vista.getCbPersonaje1().getSelectedItem();
        String nombre2 = (String) vista.getCbPersonaje2().getSelectedItem();

        if(nombre1 == null || nombre2 == null){
            JOptionPane.showMessageDialog(vista, "Seleccione los dos personajes");
            return;
        }
        vista.getTxtSalida().setText(modelo.simularInteraccion(nombre1, nombre2));
    }

    public void relacionar(){
        String nombre1 = (String) vista.getCbPersonaje1().getSelectedItem();
        String nombre2 = (String) vista.getCbPersonaje2().getSelectedItem();
        String tipo = (String) vista.getCbTipoRelacion().getSelectedItem();

        if(nombre1 == null || nombre2 == null){
            JOptionPane.showMessageDialog(vista, "Seleccione los dos personajes");
            return;
        }

        if(modelo.relacionar(nombre1, nombre2, tipo)){
            vista.getTxtSalida().setText("Ahora " + nombre1 + " y " + nombre2 + " tienen una relación de " + tipo);
        }else{
            JOptionPane.showMessageDialog(vista, "Seleccione dos personajes diferentes");
        }
    }

    // ==================== JUGADOR (RF3) ====================

    public void mover(){
        String lugar = (String) vista.getCbLugar().getSelectedItem();
        if(lugar == null){
            JOptionPane.showMessageDialog(vista, "Seleccione un lugar");
            return;
        }
        vista.getTxtSalida().setText(modelo.moverJugador(lugar));
        actualizarUbicacion();
    }

    public void usarObjeto(){
        String objeto = (String) vista.getCbObjeto().getSelectedItem();
        if(objeto == null){
            JOptionPane.showMessageDialog(vista, "No hay objetos para interactuar aquí");
            return;
        }
        vista.getTxtSalida().setText(modelo.interactuarConObjeto(objeto));
    }

    private void actualizarUbicacion(){
        vista.mostrarUbicacion(modelo.getNombreUbicacion());
        vista.llenarObjetos(modelo.getNombresObjetosUbicacion());
    }
}//End class
