package controlador;
import modelo.*;
import vista.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controlador implements ActionListener
{
    private JFPrincipal vista;
    private Gestor modelo;
    
    public Controlador(JFPrincipal vista,Gestor modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.getBtnAgregarRecuerdo().addActionListener(this);
        this.vista.getBtnAgregarEmocion().addActionListener(this);
        this.vista.getBtnAgregarEvento().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source == vista.getBtnAgregarRecuerdo()){
            agregarRecuerdo();
        }
        else if(source == vista.getBtnAgregarEmocion()){
            agregarEmocion();
        }
        else if(source == vista.getBtnAgregarEvento()){
            agregarEvento();
        }
    }
    
    public void agregarRecuerdo(){
        String codigo = vista.getTxtCodigo().getText();
        String des = vista.getTxtDescripcion().getText();
        String fecha = vista.getTxtFecha().getText();
        String nombreE = vista.getTxtEmocion().getText();
        String nombreEv = vista.getTxtEvento().getText();
        
        if(codigo.isEmpty()|| des.isEmpty()|| fecha.isEmpty()){
            vista.getTxtSalida().setText("Completa los campos");
            return;
        }
        
        Emocion emocion = modelo.buscarEmocion(nombreE);
        Evento evento = modelo.buscarEvento(nombreEv);
        
        if(emocion == null){
            vista.getTxtSalida().setText("La emocion no existe, agreguela primero");
            return;
        }
        if(evento == null){
            vista.getTxtSalida().setText("El evento no existe, agreguelo primero");
            return;
        }
        
        Recuerdo recuerdo = new Recuerdo(codigo,des,fecha,emocion,evento);
        
        if(modelo.agregarRecuerdos(recuerdo)){
            vista.getTxtSalida().setText("Recuerdo agregado correctamente");
        }else{
            vista.getTxtSalida().setText("No ha sido agregado");
        }
        
    }
    
    public void agregarEmocion(){

        String nombre = vista.getTxtNombre().getText();
        String tipo = ((String)vista.getCTipo().getSelectedItem());
        String accion = vista.getTxtAccion().getText();
        String estado = vista.getTxtEstado().getText();
        
        if(nombre.isEmpty()|| tipo.isEmpty()|| accion.isEmpty()){
            vista.getTxtSalida().setText("Completa los campos");
            return;
        }
        
        int intensidad = 0;
        try{
            intensidad = Integer.parseInt(vista.getTxtIntensidad().getText());
        }
        catch(NumberFormatException e){
            vista.getTxtSalida().setText("Intensidad es un dato numerico");
            return;
        }
        
        Emocion emocion = new Emocion(nombre,intensidad,tipo,accion,estado);
        
        if(modelo.agregarEmociones(emocion)){
            vista.getTxtSalida().setText("Emocion agregada correctamente");
        }else{
            vista.getTxtSalida().setText("No ha sido agregado");
        }
        
    }
    
    public void agregarEvento(){
        String nombre = vista.getTxtNombreEvento().getText();
        String tipo = ((String)vista.getCTipoEvento().getSelectedItem());
        String impacto = vista.getTxtImpacto().getText();
        
        if(nombre.isEmpty()|| tipo.isEmpty()|| impacto.isEmpty()){
            vista.getTxtSalida().setText("Completa los campos");
            return;
        }
        
        Evento evento = new Evento(nombre,tipo,impacto);
        
        if(modelo.agregarEventos(evento)){
            vista.getTxtSalida().setText("Evento agregado correctamente");
        }else{
            vista.getTxtSalida().setText("No ha sido agregado");
        }
        
    }
    
    
}