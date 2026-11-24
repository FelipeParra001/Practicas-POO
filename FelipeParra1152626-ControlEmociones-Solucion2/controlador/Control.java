package controlador;
import modelo.*;
import vista.*;
import java.awt.event.*;

public class Control implements ActionListener
{
    private JFGestion vistaGestor;
    private GestorEmocion modeloGestor;
    private JPEmocion panelEmocion;
    private JPRecuerdo panelRecuerdo;
    private JPResumen panelResumen ;
    private JPEvento panelEvento ;
    private JPEnlistar panelEnlistar ;
    public Control(GestorEmocion modeloGestor, JFGestion vistaGestor){
        this.vistaGestor = vistaGestor;
        this.modeloGestor = modeloGestor;
        panelEmocion = new JPEmocion();
        panelRecuerdo = new JPRecuerdo();
        panelResumen = new JPResumen();
        panelEvento = new JPEvento();
        panelEnlistar = new JPEnlistar();
        vistaGestor.getBtnEmocion().addActionListener(this);
        vistaGestor.getBtnListarRecuerdos().addActionListener(this);
        vistaGestor.getBtnLista5().addActionListener(this);
        panelEnlistar.getBtnEnlistar().addActionListener(this);
        vistaGestor.getBtnRecuerdo().addActionListener(this);
        vistaGestor.getBtnEvento().addActionListener(this);
        panelEmocion.getBtnAgregar().addActionListener(this);
        panelRecuerdo.getBtnAgregar().addActionListener(this);
        vistaGestor.getBtrEmocionMas().addActionListener(this);
        panelEvento.getBtnAgregar().addActionListener(this);
        vistaGestor.getBtnMasFuerte().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object boton = e.getSource();
        if(boton == vistaGestor.getBtnEmocion()){
            mostrarPanelEmocion();
        }else if(boton == vistaGestor.getBtnListarRecuerdos()){
            mostrarPanelEnlistar();
        }else if(boton == vistaGestor.getBtnLista5()){
            mostrarUltimos5();
        }else if(boton == panelEnlistar.getBtnEnlistar()){
            enlistarRecuerdos();
        }else if(boton == vistaGestor.getBtnRecuerdo()){
            mostrarPanelRecuerdo();
        }else if(boton == vistaGestor.getBtnEvento()){
            mostrarPanelEvento();
        }else if(boton == panelEmocion.getBtnAgregar()){
            agregarEmocion();
        }else if(boton == panelRecuerdo.getBtnAgregar()){
            agregarRecuerdo();
        }else if(boton == vistaGestor.getBtrEmocionMas()){
            mostrarFelicidad();
        }else if(boton == panelEvento.getBtnAgregar()){
            agregarEvento();
        }else if(boton == vistaGestor.getBtnMasFuerte()){
            mostrarMasFuerte();
        }
    }

    private void mostrarPanelEmocion(){
        vistaGestor.reemplazarPanelCentral(panelEmocion);
    }

    private void mostrarPanelEnlistar(){
        vistaGestor.reemplazarPanelCentral(panelEnlistar);
    }

    private void mostrarUltimos5(){
        vistaGestor.reemplazarPanelCentral(panelResumen);
        String r = modeloGestor.enlistarUltimos5();
        panelResumen.getCampoResumen().setText("Ultimos 5 recuerdos agregados: \n" + r);
    }

    private void enlistarRecuerdos(){
        Emocion emocion = (Emocion) panelEnlistar.getCbEmocion().getSelectedItem();
        if(emocion == null){
            panelEnlistar.getCampoTexto().setText("Primero agregue una emocion");
            return;
        }
        String lista = modeloGestor.enlistarRecuerdos(emocion);
        panelEnlistar.getCampoTexto().setText("Recuerdos Asociados: \n " + lista);
    }

    private void mostrarPanelRecuerdo(){
        vistaGestor.reemplazarPanelCentral(panelRecuerdo);
    }

    private void mostrarPanelEvento(){
        vistaGestor.reemplazarPanelCentral(panelEvento);
    }

    private void agregarEmocion(){
        String nombre = panelEmocion.getTxtNombre().getText();
        int intensidad = 0 ;
        try{
            intensidad =Integer.parseInt( panelEmocion.getTxtIntensidad().getText());
        }catch(NumberFormatException ex){
            panelEmocion.getCampoTexto().setText("Intensidad debe ser un entero");
            return;
        }
        if(nombre.trim().isEmpty()){
            panelEmocion.getCampoTexto().setText("Ingrese el nombre de la emocion");
            return;
        }
        if(intensidad < 1 || intensidad > 10){
            panelEmocion.getCampoTexto().setText("La intensidad debe estar entre 1 y 10");
            return;
        }
        String tipo = (String) panelEmocion.getCbTipo().getSelectedItem();
        String accion  = panelEmocion.getTxtAccion().getText();
        String estado = panelEmocion.getTxtEstado().getText();
        
        Emocion nueva = new Emocion(nombre,intensidad,tipo,accion,estado);
        if(modeloGestor.agregarEmocion(nueva)){
            panelRecuerdo.getCbEmociones().addItem(nueva);
            panelEvento.getCbEmocion().addItem(nueva);
            panelEnlistar.getCbEmocion().addItem(nueva);
            panelEmocion.getCampoTexto().setText("Agregado correctamente");
        }else{
            panelEmocion.getCampoTexto().setText("Emocion ya creada");
        }
    }

    private void agregarRecuerdo(){
        String descripcion = panelRecuerdo.getTxtDescripcion().getText();
        String fecha = panelRecuerdo.getTxtFecha().getText();
        Emocion  emocion =(Emocion) panelRecuerdo.getCbEmociones().getSelectedItem();
        Evento evento =(Evento) panelRecuerdo.getCbEventos().getSelectedItem();

        if(descripcion.trim().isEmpty() || fecha.trim().isEmpty()){
            panelRecuerdo.getCampoTexto().setText("Complete la descripcion y la fecha");
            return;
        }
        if(emocion == null || evento == null){
            panelRecuerdo.getCampoTexto().setText("Primero agregue una emocion y un evento");
            return;
        }
        if(evento.getEmocion() != emocion){
         emocion = evento.getEmocion();
        }           

        Recuerdo r = new Recuerdo(emocion,descripcion, fecha,evento);
        if(modeloGestor.agregarRecuerdo(r)){
            panelRecuerdo.getCampoTexto().setText("Agregado correctamente");
        }else{
            panelRecuerdo.getCampoTexto().setText("Recuerdo ya existente");
        }
    }

    private void mostrarFelicidad(){
        vistaGestor.reemplazarPanelCentral(panelResumen);
        double felicidad = modeloGestor.calcularPromedio() ;    
        if(felicidad < 2.5){
            panelResumen.getCampoResumen().setText("Ryley esta Triste, nivel de Felicidad: " + felicidad);
        }else if(felicidad >= 2.5 && felicidad < 5.0){
            panelResumen.getCampoResumen().setText("Ryley esta Ansiosa, nivel de Felicidad: " + felicidad);
        }
        else if(felicidad >= 5.0 && felicidad < 7.5){
            panelResumen.getCampoResumen().setText("Ryley esta Neutral, nivel de Felicidad: " + felicidad);
        }
        else if(felicidad >= 7.5 ){
            panelResumen.getCampoResumen().setText("Ryley esta Feliz , nivel de Felicidad: " + felicidad);
        }
    }

    private void agregarEvento(){
        String nombre = panelEvento.getTxtNombre().getText();
        String tipo = (String) panelEvento.getCbTipo().getSelectedItem();
        Emocion  emocion =(Emocion) panelEvento.getCbEmocion().getSelectedItem();
        if(nombre.trim().isEmpty()){
            panelEvento.getCampoTexto().setText("Ingrese el nombre del evento");
            return;
        }
        if(emocion == null){
            panelEvento.getCampoTexto().setText("Primero agregue una emocion");
            return;
        }
        int nivelCambio;
        try{
            nivelCambio = Integer.parseInt(panelEvento.getTxtNivelCambio().getText());
        }catch (NumberFormatException ex){
            panelEvento.getCampoTexto().setText("Ingrese un numero valido");
            return;
        }
        String  tipoCambio = (String) panelEvento.getCbTipoCambio().getSelectedItem();
        
        Evento ev = new Evento(nombre,tipo,emocion,nivelCambio, tipoCambio);
        if(modeloGestor.agregarEvento(ev)){
            panelEvento.getCampoTexto().setText("Agregado Correctamente");
            modeloGestor.nuevaIntensidad(emocion,nivelCambio, tipoCambio);
            panelRecuerdo.getCbEventos().addItem(ev);
        }
    }

    private void mostrarMasFuerte(){
        vistaGestor.reemplazarPanelCentral(panelResumen);
        Emocion emocion = modeloGestor.hallarEmocionMasIntensa();
        if(emocion == null){
            panelResumen.getCampoResumen().setText("No hay emociones registradas");
            return;
        }
        panelResumen.getCampoResumen().setText("La emocion mas intensa en este momento es: " + emocion + "\n" +
                                                "Con una intensidad de : " + emocion.getIntensidad());
    }
}
