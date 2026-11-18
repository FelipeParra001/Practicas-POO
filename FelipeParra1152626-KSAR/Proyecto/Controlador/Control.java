package Proyecto.Controlador;
import Proyecto.Modelo.*;
import Proyecto.Vista.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control
{
     
    private SistemaKsar modeloSistema;
    private JFKsar vistaKsar;

    private JFRegistrarEquipo formularioRegistrarEquipo;
    private JFRegistrarGuia formularioRegistrarGuia;
    private JFRegistrarPerro formularioRegistrarPerro;
    private JFArmarBinomio formularioArmarBinomio;
    private JFRegistrarEvento formularioRegistrarEvento;
    private JFRegistrarMision formularioRegistrarMision;
    private JFListarGuia_Perro formularioListarGuiaPerro;
    private JFFiltrarMision formularioFiltrarMision;
    private JFMayorDesempeño formularioMayorDesempeno;
    private JFBinomioDisponible formularioBinomiosDisponibles;

    private ArrayList<Evento> eventosLibres;
    private ArrayList<Binomio> binomiosEquipo;

    public Control(SistemaKsar modeloSistema, JFKsar vistaKsar){
        this.modeloSistema = modeloSistema;
        this.vistaKsar = vistaKsar;
        eventosLibres = new ArrayList<>();
        binomiosEquipo = new ArrayList<>();

        formularioRegistrarEquipo = new JFRegistrarEquipo();
        formularioRegistrarGuia = new JFRegistrarGuia();
        formularioRegistrarPerro = new JFRegistrarPerro();
        formularioArmarBinomio = new JFArmarBinomio();
        formularioRegistrarEvento = new JFRegistrarEvento();
        formularioRegistrarMision = new JFRegistrarMision();
        formularioListarGuiaPerro = new JFListarGuia_Perro();
        formularioFiltrarMision = new JFFiltrarMision();
        formularioMayorDesempeno = new JFMayorDesempeño();
        formularioBinomiosDisponibles = new JFBinomioDisponible();

        // ==================== VENTANA PRINCIPAL ====================

        vistaKsar.getBtnBuscar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String criterio = (String) vistaKsar.getCmbCriterio().getSelectedItem();
                String texto = vistaKsar.getTxtBuscar().getText().trim();
                if(texto.isEmpty()){
                    vistaKsar.mostrarMensaje("Escriba el texto a buscar.");
                    return;
                }
                vistaKsar.limpiarDetalle();
                
                if(criterio.equals("Misión")){
                    ArrayList<Mision> encontradas = modeloSistema.buscarMisionesPorCodigo(texto);
                    mostrarHistorial(encontradas);
                    if(encontradas.isEmpty()){
                        vistaKsar.mostrarMensaje("No se encontró ninguna misión.");
                    }else{
                        vistaKsar.mostrarMensaje(" ");
                        vistaKsar.seleccionarPrimeraFila();
                    }
                    return;
                }
                
                ArrayList<Binomio> binomios;
                if(criterio.equals("Perro")){
                    binomios = modeloSistema.buscarBinomiosPorPerro(texto);
                }else{
                    binomios = modeloSistema.buscarBinomiosPorGuia(texto);
                }
                
                if(binomios.isEmpty()){
                    mostrarHistorial(new ArrayList<Mision>());
                    String informacion = criterio.equals("Perro") ? modeloSistema.consultarPerro(texto)
                                                                   : modeloSistema.consultarGuia(texto);
                    vistaKsar.mostrarMensaje(informacion);
                    return;
                }
                
                ArrayList<Mision> misiones = modeloSistema.misionesDeBinomios(binomios);
                mostrarHistorial(misiones);
                vistaKsar.mostrarBinomio(binomios.get(0));
                vistaKsar.mostrarMensaje(misiones.isEmpty() ? "El binomio no tiene misiones registradas." : " ");
            }
        });

        vistaKsar.getBtnActualizar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                refrescarVentanaPrincipal();
            }
        });

        vistaKsar.getBtnDesempeno().addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        Mision mision = vistaKsar.getMisionSeleccionada();
        if(mision == null){
            vistaKsar.mostrarMensaje("Seleccione una misión de la tabla.");
            return;
        }
        vistaKsar.mostrarMensaje("Desempeño de la misión " + mision.getCodigo() + ": " + mision.calcularDesempeno());
         }
        });

        vistaKsar.getBtnDesempenoConjunto().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vistaKsar.mostrarMensajeEmergente(modeloSistema.calcularDesempenoConjunto());
            }
        });

        vistaKsar.getBtnRegistrarEquipo().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarEquipo.getTxtNombre().setText("");
                escribir(formularioRegistrarEquipo.getTxtMensaje(), "");
                cargarTablaEquipos();
                formularioRegistrarEquipo.setVisible(true);
            }
        });

        vistaKsar.getBtnRegistrarGuia().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarGuia.getTxtCedula().setText("");
                formularioRegistrarGuia.getTxtNombre().setText("");
                formularioRegistrarGuia.getTxtCedulaAct().setText("");
                escribir(formularioRegistrarGuia.getTxtMensaje(), "");
                formularioRegistrarGuia.setVisible(true);
            }
        });

        vistaKsar.getBtnRegistrarPerro().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limpiarCamposPerro();
                formularioRegistrarPerro.getTxtCodigoAct().setText("");
                escribir(formularioRegistrarPerro.getTxtMensaje(), "");
                formularioRegistrarPerro.setVisible(true);
            }
        });

        vistaKsar.getBtnArmarBinomio().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cargarOpcionesArmarBinomio();
                escribir(formularioArmarBinomio.getTxtMensaje(), "");
                formularioArmarBinomio.setVisible(true);
            }
        });

        vistaKsar.getBtnRegistrarEvento().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limpiarCamposEvento();
                formularioRegistrarEvento.getTxtPais().setText("");
                formularioRegistrarEvento.getTxtCodigo().setText("");
                formularioRegistrarEvento.getTxtMunicipio().setText("");
                formularioRegistrarEvento.getTxtLugar().setText("");
                formularioRegistrarEvento.getTxtCalle().setText("");
                formularioRegistrarEvento.getTxtNumero().setText("");
                formularioRegistrarEvento.getTxtBarrio().setText("");
                escribir(formularioRegistrarEvento.getTxtMensaje(), "");
                formularioRegistrarEvento.setVisible(true);
            }
        });

        vistaKsar.getBtnRegistrarMision().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarMision.getPnlFecha().setFecha(Fecha.hoy());
                limpiarCamposMision();
                cargarEventosLibres();
                
                formularioRegistrarMision.getCmbEquipo().removeAllItems();
                for(Equipo equipo : modeloSistema.getEquipos()){
                    formularioRegistrarMision.getCmbEquipo().addItem(equipo.getNombre());
                }
                escribir(formularioRegistrarMision.getTxtMensaje(), "");
                formularioRegistrarMision.setVisible(true);
            }
        });

        vistaKsar.getBtnListarGuiaPerro().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioListarGuiaPerro.getCmbGuia().removeAllItems();
                for(Guia guia : modeloSistema.getGuias()){
                    formularioListarGuiaPerro.getCmbGuia().addItem(guia.getCedula() + " - " + guia.getNombreCompleto());
                }
                escribir(formularioListarGuiaPerro.getTxtResultado(), "");
                formularioListarGuiaPerro.setVisible(true);
            }
        });

        vistaKsar.getBtnFiltrarMision().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioFiltrarMision.getCmbEquipo().removeAllItems();
                formularioFiltrarMision.getCmbEquipo().addItem(JFFiltrarMision.TODOS);
                for(Equipo equipo : modeloSistema.getEquipos()){
                    formularioFiltrarMision.getCmbEquipo().addItem(equipo.getNombre());
                }
                formularioFiltrarMision.getCmbMunicipio().removeAllItems();
                formularioFiltrarMision.getCmbMunicipio().addItem(JFFiltrarMision.TODOS);
                for(String municipio : modeloSistema.listarNombresMunicipios()){
                    formularioFiltrarMision.getCmbMunicipio().addItem(municipio);
                }
                filtrarMisiones();
                formularioFiltrarMision.setVisible(true);
            }
        });

        vistaKsar.getBtnMayorDesempeno().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                escribir(formularioMayorDesempeno.getTxtResultado(), "");
                formularioMayorDesempeno.setVisible(true);
            }
        });

        vistaKsar.getBtnBinomiosDisponibles().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                escribir(formularioBinomiosDisponibles.getTxtResultado(), "");
                formularioBinomiosDisponibles.setVisible(true);
            }
        });

        // ==================== FORMULARIO REGISTRAR EQUIPO ====================

        formularioRegistrarEquipo.getBtnGuardar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int antes = modeloSistema.getEquipos().size();
                String mensaje = modeloSistema.registrarEquipo(formularioRegistrarEquipo.getTxtNombre().getText(),
                                                               formularioRegistrarEquipo.getPnlFecha().getFecha());
                escribir(formularioRegistrarEquipo.getTxtMensaje(), mensaje);
                if(modeloSistema.getEquipos().size() > antes){
                    formularioRegistrarEquipo.getTxtNombre().setText("");
                    cargarTablaEquipos();
                    actualizarContadores();
                }
            }
        });

        formularioRegistrarEquipo.getBtnCancelar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarEquipo.dispose();
            }
        });

        // ==================== FORMULARIO REGISTRAR GUIA ====================

        formularioRegistrarGuia.getBtnGuardar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int antes = modeloSistema.getGuias().size();
                String mensaje = modeloSistema.registrarGuia(formularioRegistrarGuia.getTxtCedula().getText().trim(),
                                                             formularioRegistrarGuia.getTxtNombre().getText(),
                                                             leerCertificacion(formularioRegistrarGuia.getCmbCert()));
                escribir(formularioRegistrarGuia.getTxtMensaje(), mensaje);
                if(modeloSistema.getGuias().size() > antes){
                    formularioRegistrarGuia.getTxtCedula().setText("");
                    formularioRegistrarGuia.getTxtNombre().setText("");
                }
            }
        });

        formularioRegistrarGuia.getBtnActualizar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String mensaje = modeloSistema.actualizarCertificacionGuia(formularioRegistrarGuia.getTxtCedulaAct().getText().trim(),
                                                                           leerCertificacion(formularioRegistrarGuia.getCmbCertAct()));
                escribir(formularioRegistrarGuia.getTxtMensaje(), mensaje);
                actualizarContadores();
            }
        });

        formularioRegistrarGuia.getBtnCancelar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarGuia.dispose();
            }
        });

        // ==================== FORMULARIO REGISTRAR PERRO ====================

        formularioRegistrarPerro.getBtnGuardar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Integer edad = leerEntero(formularioRegistrarPerro.getTxtEdad().getText());
                if(edad == null){
                    escribir(formularioRegistrarPerro.getTxtMensaje(), "La edad debe ser un número entero.");
                    return;
                }
                int antes = modeloSistema.getPerros().size();
                String mensaje = modeloSistema.registrarPerro(formularioRegistrarPerro.getTxtNombre().getText(),
                                                              formularioRegistrarPerro.getTxtDescripcion().getText(),
                                                              formularioRegistrarPerro.getTxtRaza().getText(),
                                                              edad,
                                                              leerCertificacion(formularioRegistrarPerro.getCmbCertificacion()));
                escribir(formularioRegistrarPerro.getTxtMensaje(), mensaje);
                if(modeloSistema.getPerros().size() > antes){
                    limpiarCamposPerro();
                }
            }
        });

        formularioRegistrarPerro.getBtnActualizar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String codigo = formularioRegistrarPerro.getTxtCodigoAct().getText().trim().toUpperCase();
                String mensaje = modeloSistema.actualizarCertificacionPerro(codigo,
                                                                            leerCertificacion(formularioRegistrarPerro.getCmbCertAct()));
                escribir(formularioRegistrarPerro.getTxtMensaje(), mensaje);
                actualizarContadores();
            }
        });

        formularioRegistrarPerro.getBtnCancelar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarPerro.dispose();
            }
        });

        // ==================== FORMULARIO ARMAR BINOMIO ====================

        formularioArmarBinomio.getBtnArmar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String guia = (String) formularioArmarBinomio.getCmbGuia().getSelectedItem();
                String perro = (String) formularioArmarBinomio.getCmbPerro().getSelectedItem();
                String equipo = (String) formularioArmarBinomio.getCmbEquipo().getSelectedItem();
                if(guia == null || perro == null || equipo == null){
                    escribir(formularioArmarBinomio.getTxtMensaje(), "Debe seleccionar un guía, un perro y un equipo.");
                    return;
                }
                
                int antes = modeloSistema.getBinomios().size();
                String mensaje = modeloSistema.armarBinomio(extraerCodigo(guia), extraerCodigo(perro), equipo);
                if(modeloSistema.getBinomios().size() > antes){
                    cargarOpcionesArmarBinomio();
                    actualizarContadores();
                }
                escribir(formularioArmarBinomio.getTxtMensaje(), mensaje);
            }
        });

        formularioArmarBinomio.getBtnCancelar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioArmarBinomio.dispose();
            }
        });

        // ==================== FORMULARIO REGISTRAR EVENTO ====================

        formularioRegistrarEvento.getCmbTipo().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarEvento.cambiarTipo();
            }
        });

        formularioRegistrarEvento.getBtnUbicacion().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String mensaje = modeloSistema.registrarUbicacion(formularioRegistrarEvento.getTxtPais().getText(),
                                                                  formularioRegistrarEvento.getTxtCodigo().getText(),
                                                                  formularioRegistrarEvento.getTxtMunicipio().getText(),
                                                                  formularioRegistrarEvento.getTxtLugar().getText(),
                                                                  formularioRegistrarEvento.getTxtCalle().getText(),
                                                                  formularioRegistrarEvento.getTxtNumero().getText(),
                                                                  formularioRegistrarEvento.getTxtBarrio().getText());
                escribir(formularioRegistrarEvento.getTxtMensaje(), mensaje);
            }
        });

        formularioRegistrarEvento.getBtnGuardar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Lugar lugar = modeloSistema.buscarLugar(formularioRegistrarEvento.getTxtCodigo().getText().trim(),
                                                        formularioRegistrarEvento.getTxtMunicipio().getText().trim(),
                                                        formularioRegistrarEvento.getTxtLugar().getText().trim());
                if(lugar == null){
                    escribir(formularioRegistrarEvento.getTxtMensaje(),
                             "La ubicación no está registrada. Use \"Registrar ubicación\" antes de guardar el evento.");
                    return;
                }
                Fecha fecha = formularioRegistrarEvento.getPnlFecha().getFecha();
                int antes = modeloSistema.getEventos().size();
                String mensaje;
                
                if(formularioRegistrarEvento.getCmbTipo().getSelectedItem().equals("Terremoto")){
                    Double magnitud = leerDecimal(formularioRegistrarEvento.getTxtMagnitud().getText());
                    if(magnitud == null){
                        escribir(formularioRegistrarEvento.getTxtMensaje(), "La magnitud debe ser un número.");
                        return;
                    }
                    mensaje = modeloSistema.registrarTerremoto(fecha, magnitud,
                                                               formularioRegistrarEvento.getTxtEpicentro().getText(), lugar);
                }else{
                    Integer volumen = leerEntero(formularioRegistrarEvento.getTxtVolumen().getText());
                    if(volumen == null){
                        escribir(formularioRegistrarEvento.getTxtMensaje(), "El volumen debe ser un número entero.");
                        return;
                    }
                    mensaje = modeloSistema.registrarDeslave(fecha, volumen,
                                                             formularioRegistrarEvento.getTxtZona().getText(), lugar);
                }
                
                escribir(formularioRegistrarEvento.getTxtMensaje(), mensaje);
                if(modeloSistema.getEventos().size() > antes){
                    limpiarCamposEvento();
                }
            }
        });

        formularioRegistrarEvento.getBtnCancelar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarEvento.dispose();
            }
        });

        // ==================== FORMULARIO REGISTRAR MISION ====================

        formularioRegistrarMision.getCmbEvento().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarUbicacionEvento();
            }
        });

        formularioRegistrarMision.getCmbEquipo().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                binomiosEquipo.clear();
                String nombre = (String) formularioRegistrarMision.getCmbEquipo().getSelectedItem();
                Equipo equipo = (nombre == null) ? null : modeloSistema.buscarEquipo(nombre);
                if(equipo != null){
                    binomiosEquipo.addAll(equipo.getBinomios());
                }
                formularioRegistrarMision.getCmbBinomio().removeAllItems();
                for(Binomio binomio : binomiosEquipo){
                    formularioRegistrarMision.getCmbBinomio().addItem(binomio.resumen());
                }
            }
        });

        formularioRegistrarMision.getBtnGuardar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int posicionEvento = formularioRegistrarMision.getCmbEvento().getSelectedIndex();
                int posicionBinomio = formularioRegistrarMision.getCmbBinomio().getSelectedIndex();
                Evento evento = null;
                Binomio binomio = null;
                if(posicionEvento >= 0 && posicionEvento < eventosLibres.size()){
                    evento = eventosLibres.get(posicionEvento);
                }
                if(posicionBinomio >= 0 && posicionBinomio < binomiosEquipo.size()){
                    binomio = binomiosEquipo.get(posicionBinomio);
                }
                
                Double horas = leerDecimal(formularioRegistrarMision.getTxtHoras().getText());
                Integer sobrevivientes = leerEntero(formularioRegistrarMision.getTxtSobrevivientes().getText());
                Integer fallecidos = leerEntero(formularioRegistrarMision.getTxtFallecidos().getText());
                if(horas == null || sobrevivientes == null || fallecidos == null){
                    escribir(formularioRegistrarMision.getTxtMensaje(),
                             "Las horas, los sobrevivientes y los fallecidos deben ser números (los dos últimos enteros).");
                    return;
                }
                
                int antes = modeloSistema.getMisiones().size();
                String mensaje = modeloSistema.registrarMision(formularioRegistrarMision.getPnlFecha().getFecha(),
                                                               evento, binomio, horas, sobrevivientes, fallecidos);
                if(modeloSistema.getMisiones().size() > antes){
                    limpiarCamposMision();
                    cargarEventosLibres();
                    refrescarVentanaPrincipal();
                }
                escribir(formularioRegistrarMision.getTxtMensaje(), mensaje);
            }
        });

        formularioRegistrarMision.getBtnCancelar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioRegistrarMision.dispose();
            }
        });

        // ==================== FORMULARIO LISTAR GUIAS Y PERROS ====================

        formularioListarGuiaPerro.getBtnPerros().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String guia = (String) formularioListarGuiaPerro.getCmbGuia().getSelectedItem();
                if(guia == null){
                    escribir(formularioListarGuiaPerro.getTxtResultado(), "No hay guías registrados.");
                    return;
                }
                escribir(formularioListarGuiaPerro.getTxtResultado(), modeloSistema.listarPerrosDelGuia(extraerCodigo(guia)));
            }
        });

        formularioListarGuiaPerro.getBtnTodos().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                escribir(formularioListarGuiaPerro.getTxtResultado(), modeloSistema.listarGuiasYPerros());
            }
        });

        formularioListarGuiaPerro.getBtnCerrar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioListarGuiaPerro.dispose();
            }
        });

        // ==================== FORMULARIO FILTRAR MISIONES ====================

        formularioFiltrarMision.getBtnFiltrar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                filtrarMisiones();
            }
        });

        formularioFiltrarMision.getBtnLimpiar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioFiltrarMision.getCmbEquipo().setSelectedIndex(0);
                formularioFiltrarMision.getCmbMunicipio().setSelectedIndex(0);
                filtrarMisiones();
            }
        });

        formularioFiltrarMision.getBtnCerrar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioFiltrarMision.dispose();
            }
        });

        // ==================== FORMULARIO MAYOR DESEMPEÑO ====================

        formularioMayorDesempeno.getBtnBuscar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayList<Mision> ganadoras = modeloSistema.buscarMayorDesempeno();
                if(ganadoras.isEmpty()){
                    escribir(formularioMayorDesempeno.getTxtResultado(), "No hay misiones registradas.");
                    return;
                }
                StringBuilder resultado = new StringBuilder();
                resultado.append("Mayor desempeño: ").append(ganadoras.get(0).calcularDesempeno()).append("\n\n");
                for(Mision mision : ganadoras){
                    resultado.append(mision.toString()).append("\n\n");
                }
                escribir(formularioMayorDesempeno.getTxtResultado(), resultado.toString());
            }
        });

        formularioMayorDesempeno.getBtnCerrar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioMayorDesempeno.dispose();
            }
        });

        // ==================== FORMULARIO BINOMIOS DISPONIBLES ====================

        formularioBinomiosDisponibles.getBtnConsultar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                escribir(formularioBinomiosDisponibles.getTxtResultado(), modeloSistema.listarBinomiosDisponibles());
            }
        });

        formularioBinomiosDisponibles.getBtnCerrar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                formularioBinomiosDisponibles.dispose();
            }
        });

        refrescarVentanaPrincipal();
    }

    // ==================== METODOS AUXILIARES ====================

    private void refrescarVentanaPrincipal(){
        vistaKsar.limpiarBusqueda();
        vistaKsar.limpiarDetalle();
        mostrarHistorial(modeloSistema.listarMisiones());
        actualizarContadores();
    }

    private void actualizarContadores(){
        vistaKsar.actualizarContadores(modeloSistema.getEquipos().size(),
                                       modeloSistema.getMisiones().size(),
                                       modeloSistema.contarBinomiosDisponibles());
    }

    private void cargarTablaEquipos(){
        DefaultTableModel tabla = formularioRegistrarEquipo.getModeloTabla();
        tabla.setRowCount(0);
        for(Equipo equipo : modeloSistema.getEquipos()){
            tabla.addRow(new Object[]{equipo.getNombre(),
                                      equipo.getFechaCreacion().toString(),
                                      equipo.getBinomios().size()});
        }
    }

    private void limpiarCamposPerro(){
        formularioRegistrarPerro.getTxtNombre().setText("");
        formularioRegistrarPerro.getTxtDescripcion().setText("");
        formularioRegistrarPerro.getTxtRaza().setText("");
        formularioRegistrarPerro.getTxtEdad().setText("");
    }

    private void cargarOpcionesArmarBinomio(){
        formularioArmarBinomio.getCmbGuia().removeAllItems();
        for(Guia guia : modeloSistema.getGuias()){
            if(!guia.tienePerro()){
                formularioArmarBinomio.getCmbGuia().addItem(guia.getCedula() + " - " + guia.getNombreCompleto());
            }
        }
        formularioArmarBinomio.getCmbPerro().removeAllItems();
        for(Perro perro : modeloSistema.getPerros()){
            if(perro.getBinomio() == null){
                formularioArmarBinomio.getCmbPerro().addItem(perro.getCodigo() + " - " + perro.getNombre());
            }
        }
        formularioArmarBinomio.getCmbEquipo().removeAllItems();
        for(Equipo equipo : modeloSistema.getEquipos()){
            formularioArmarBinomio.getCmbEquipo().addItem(equipo.getNombre());
        }
    }

    private void limpiarCamposEvento(){
        formularioRegistrarEvento.getTxtMagnitud().setText("");
        formularioRegistrarEvento.getTxtEpicentro().setText("");
        formularioRegistrarEvento.getTxtVolumen().setText("");
        formularioRegistrarEvento.getTxtZona().setText("");
    }

    private void limpiarCamposMision(){
        formularioRegistrarMision.getTxtHoras().setText("");
        formularioRegistrarMision.getTxtSobrevivientes().setText("");
        formularioRegistrarMision.getTxtFallecidos().setText("");
    }

    private void cargarEventosLibres(){
        formularioRegistrarMision.getTxtCodigo().setText(modeloSistema.siguienteCodigoMision());
        eventosLibres.clear();
        for(Evento evento : modeloSistema.getEventos()){
            if(!evento.tieneMision()){
                eventosLibres.add(evento);
            }
        }
        formularioRegistrarMision.getCmbEvento().removeAllItems();
        for(Evento evento : eventosLibres){
            formularioRegistrarMision.getCmbEvento().addItem(evento.resumen() + " - " + evento.getLugar().getNombre());
        }
        mostrarUbicacionEvento();
    }

    private void mostrarUbicacionEvento(){
        int posicion = formularioRegistrarMision.getCmbEvento().getSelectedIndex();
        if(posicion >= 0 && posicion < eventosLibres.size()){
            Lugar lugar = eventosLibres.get(posicion).getLugar();
            formularioRegistrarMision.getTxtLugar().setText(lugar.getNombre());
            formularioRegistrarMision.getTxtMunicipio().setText(lugar.getMunicipio().getNombre());
        }else{
            formularioRegistrarMision.getTxtLugar().setText("");
            formularioRegistrarMision.getTxtMunicipio().setText("");
        }
    }

    private void filtrarMisiones(){
        String equipo = (String) formularioFiltrarMision.getCmbEquipo().getSelectedItem();
        String municipio = (String) formularioFiltrarMision.getCmbMunicipio().getSelectedItem();
        if(JFFiltrarMision.TODOS.equals(equipo)){
            equipo = "";
        }
        if(JFFiltrarMision.TODOS.equals(municipio)){
            municipio = "";
        }
        ArrayList<Mision> resultado = modeloSistema.ordenarPorFecha(modeloSistema.filtrarMisiones(equipo, municipio));
        formularioFiltrarMision.mostrarMisiones(resultado);
        formularioFiltrarMision.getLblResumen().setText("Misiones encontradas: " + resultado.size());
    }

    private void mostrarHistorial(ArrayList<Mision> misiones){
        vistaKsar.mostrarMisiones(modeloSistema.ordenarPorFecha(misiones));
    }

   private void escribir(JTextArea area, String texto){
        area.setText(texto);
         area.setCaretPosition(0);
   }

    private Certificacion leerCertificacion(JComboBox<String> combo){
        return Certificacion.valueOf((String) combo.getSelectedItem());
    }

    private Integer leerEntero(String texto){
        try{
            return Integer.parseInt(texto.trim());
        }catch(NumberFormatException ex){
            return null;
        }
    }

    private Double leerDecimal(String texto){
        try{
            double valor = Double.parseDouble(texto.trim().replace(',', '.'));
            if(Double.isNaN(valor) || Double.isInfinite(valor)){
                return null;
            }
            return valor;
        }catch(NumberFormatException ex){
            return null;
        }
    }

    private String extraerCodigo(String opcion){
        return opcion.substring(0, opcion.indexOf(" - "));
    }
   
}
     
