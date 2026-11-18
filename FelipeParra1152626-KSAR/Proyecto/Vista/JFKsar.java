package Proyecto.Vista;
import Proyecto.Modelo.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


/**
 * Ventana principal.
 * Andrés: recibe el controlador y abre los formularios de guía, perro, binomio e historial.
 */
public class JFKsar extends JFrame
  {
   
     // Etiquetas del oeste
    private JLabel lblGuia;
    private JLabel lblCedula;
    private JLabel lblCert;
    private JLabel lblPerro;
    private JLabel lblRaza;

    // Etiquetas del este
    private JLabel lblTipo;
    private JLabel lblMagnitud;
    private JLabel lblLugar;
    private JLabel lblMunicipio;
    private JLabel lblFecha;

    // Búsquedas
    private JComboBox<String> cmbCriterio;
    private JTextField txtBuscar;
    private JLabel lblEquipos;
    private JLabel lblMisiones;
    private JLabel lblDisponibles;
    private JLabel lblMensaje;

    // Botones 
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnRegistrarEquipo;
    private JButton btnRegistrarGuia;
    private JButton btnRegistrarPerro;
    private JButton btnArmarBinomio;
    private JButton btnRegistrarEvento;
    private JButton btnRegistrarMision;
    private JButton btnListarGuiaPerro;
    private JButton btnFiltrarMision;
    private JButton btnMayorDesempeno;
    private JButton btnDesempeno;
    private JButton btnDesempenoConjunto;
    private JButton btnBinomiosDisponibles;

    // Tabla 
    private JTable tabla;
    private DefaultTableModel modelo;
    private ArrayList<Mision> mostradas = new ArrayList<>();

     public JFKsar() {
        setTitle("K-SAR ECID - Sistema de Gestión de Equipos Caninos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(crearNorte(), BorderLayout.NORTH);
        add(crearOeste(), BorderLayout.WEST);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearEste(), BorderLayout.EAST);
        add(crearSur(), BorderLayout.SOUTH);
    }

    // ==================== NORTE ====================
    private JPanel crearNorte() {
        JPanel norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
        norte.setBackground(Color.WHITE);

        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(15, 32, 68));
        barra.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));

        JLabel titulo = new JLabel("K-SAR ECID");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        JLabel subtitulo = new JLabel("Sistema de Gestión de Equipos Caninos");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitulo.setForeground(new Color(200, 210, 230));

        JPanel textos = new JPanel();
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.setOpaque(false);
        textos.add(titulo);
        textos.add(subtitulo);

        ImageIcon icono = new ImageIcon("imagen/logo.png");
        Image img = icono.getImage().getScaledInstance(56, 56, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(img));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 14));

        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        izquierda.setOpaque(false);
        izquierda.add(logo);
        izquierda.add(textos);

        JLabel rol = new JLabel("Rol: Director");
        rol.setForeground(Color.WHITE);
        rol.setFont(new Font("Arial", Font.PLAIN, 13));

        barra.add(izquierda, BorderLayout.WEST);
        barra.add(rol, BorderLayout.EAST);

        JPanel busqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        busqueda.setBackground(Color.WHITE);
        busqueda.add(new JLabel("Buscar por"));
        cmbCriterio = new JComboBox<>(new String[]{"Perro", "Guía", "Misión"});
        busqueda.add(cmbCriterio);
        txtBuscar = new JTextField(18);
        txtBuscar.setToolTipText("Perro: código o nombre | Guía: cédula o nombre | Misión: código");
        busqueda.add(txtBuscar);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(15, 32, 68));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        busqueda.add(btnBuscar);
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFocusPainted(false);
        busqueda.add(btnActualizar);
        lblMensaje = new JLabel(" ");
        lblMensaje.setForeground(new Color(120, 40, 40));
        busqueda.add(lblMensaje);

        JPanel numeros = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 6));
        numeros.setBackground(Color.WHITE);
        lblEquipos = new JLabel("0  equipos");
        lblMisiones = new JLabel("0  misiones");
        lblDisponibles = new JLabel("0  disponibles");
        numeros.add(lblEquipos);
        numeros.add(lblMisiones);
        numeros.add(lblDisponibles);

        norte.add(barra);
        norte.add(busqueda);
        norte.add(numeros);
        return norte;
    }

    // ==================== OESTE ====================
    private JPanel crearOeste() {
        JPanel oeste = new JPanel();
        oeste.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        oeste.setBackground(Color.WHITE);
        oeste.setBorder(BorderFactory.createTitledBorder("Binomio seleccionado"));
        oeste.setPreferredSize(new Dimension(220, 0));

        lblGuia = new JLabel("Guía: —");
        lblCedula = new JLabel("Cédula: —");
        lblCert = new JLabel("Certificación: —");
        lblPerro = new JLabel("Perro: —");
        lblRaza = new JLabel("Raza: —");

        oeste.add(Box.createVerticalStrut(10));
        oeste.add(lblGuia);
        oeste.add(lblCedula);
        oeste.add(lblCert);
        oeste.add(Box.createVerticalStrut(15));
        oeste.add(lblPerro);
        oeste.add(lblRaza);
        oeste.add(Box.createVerticalGlue());
        return oeste;
    }

    // ==================== CENTRO ====================
    private JPanel crearCentro() {
        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(Color.WHITE);
        
        centro.setBorder(BorderFactory.createTitledBorder("Historial de misiones (ordenado por fecha)"));

        String[] columnas = {"Código", "Fecha", "Lugar", "Equipo", "Horas", "Sobrevivientes", "Fallecidos"};
        modelo = new DefaultTableModel(columnas, 0);

        tabla = new JTable(modelo);
        tabla.setRowHeight(22);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabla.getSelectedRow();
                    if (fila >= 0 && fila < mostradas.size()) {
                        Mision m = mostradas.get(fila);
                        mostrarBinomio(m.getBinomio());
                        mostrarEvento(m.getEvento());
                    }
                }
            }
        });

        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return centro;
    }

    // ==================== ESTE ====================
    private JPanel crearEste() {
        JPanel este = new JPanel();
        este.setLayout(new BoxLayout(este, BoxLayout.Y_AXIS));
        este.setBackground(Color.WHITE);
        este.setBorder(BorderFactory.createTitledBorder("Evento"));
        este.setPreferredSize(new Dimension(220, 0));

        lblTipo = new JLabel("Tipo: —");
        lblMagnitud = new JLabel("Magnitud: —");
        lblLugar = new JLabel("Lugar: —");
        lblMunicipio = new JLabel("Municipio: —");
        lblFecha = new JLabel("Fecha: —");

        este.add(Box.createVerticalStrut(10));
        este.add(lblTipo);
        este.add(lblMagnitud);
        este.add(lblLugar);
        este.add(lblMunicipio);
        este.add(lblFecha);
        este.add(Box.createVerticalGlue());
        return este;
    }

    // ==================== SUR ====================
    private JButton crearBotonRegistro(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(new Color(15, 32, 68));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }

    private JPanel crearSur() {
        JPanel sur = new JPanel();
        sur.setLayout(new BoxLayout(sur, BoxLayout.Y_AXIS));
        sur.setBackground(Color.WHITE);
        sur.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        btnRegistrarEquipo = crearBotonRegistro("Registrar equipo");
        btnRegistrarGuia = crearBotonRegistro("Registrar guía");
        btnRegistrarPerro = crearBotonRegistro("Registrar perro");
        btnArmarBinomio = crearBotonRegistro("Armar binomio");
        btnRegistrarEvento = crearBotonRegistro("Registrar evento");
        btnRegistrarMision = crearBotonRegistro("Registrar misión");

        JPanel filaRegistro = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 4));
        filaRegistro.setBackground(Color.WHITE);
        filaRegistro.add(btnRegistrarEquipo);
        filaRegistro.add(btnRegistrarGuia);
        filaRegistro.add(btnRegistrarPerro);
        filaRegistro.add(btnArmarBinomio);
        filaRegistro.add(btnRegistrarEvento);
        filaRegistro.add(btnRegistrarMision);

        btnListarGuiaPerro = new JButton("Listar guías y perros");
        btnFiltrarMision = new JButton("Filtrar misiones");
        btnMayorDesempeno = new JButton("Mayor desempeño");
        btnDesempeno = new JButton("Desempeño");
        btnDesempenoConjunto = new JButton("Desempeño conjunto");
        btnBinomiosDisponibles = new JButton("Binomios disponibles");
        btnListarGuiaPerro.setFocusPainted(false);
        btnFiltrarMision.setFocusPainted(false);
        btnMayorDesempeno.setFocusPainted(false);
        btnDesempeno.setFocusPainted(false);
        btnDesempenoConjunto.setFocusPainted(false);
        btnBinomiosDisponibles.setFocusPainted(false);

        JPanel filaConsulta = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 4));
        filaConsulta.setBackground(Color.WHITE);
        filaConsulta.add(btnListarGuiaPerro);
        filaConsulta.add(btnFiltrarMision);
        
        filaConsulta.add(btnDesempeno);
        filaConsulta.add(btnDesempenoConjunto);
        filaConsulta.add(btnMayorDesempeno);
        filaConsulta.add(btnBinomiosDisponibles);

        sur.add(filaRegistro);
        sur.add(filaConsulta);
        return sur;
    }

    //Start GetterSetterExtension Source Code

    /**GET Method Propertie cmbCriterio*/
    public JComboBox<String> getCmbCriterio(){
        return this.cmbCriterio;
    }//end method getCmbCriterio

    /**GET Method Propertie txtBuscar*/
    public JTextField getTxtBuscar(){
        return this.txtBuscar;
    }//end method getTxtBuscar

    /**GET Method Propertie btnBuscar*/
    public JButton getBtnBuscar(){
        return this.btnBuscar;
    }//end method getBtnBuscar

    /**GET Method Propertie btnActualizar*/
    public JButton getBtnActualizar(){
        return this.btnActualizar;
    }//end method getBtnActualizar

    /**GET Method Propertie btnRegistrarEquipo*/
    public JButton getBtnRegistrarEquipo(){
        return this.btnRegistrarEquipo;
    }//end method getBtnRegistrarEquipo

    /**GET Method Propertie btnRegistrarGuia*/
    public JButton getBtnRegistrarGuia(){
        return this.btnRegistrarGuia;
    }//end method getBtnRegistrarGuia

    /**GET Method Propertie btnRegistrarPerro*/
    public JButton getBtnRegistrarPerro(){
        return this.btnRegistrarPerro;
    }//end method getBtnRegistrarPerro

    /**GET Method Propertie btnArmarBinomio*/
    public JButton getBtnArmarBinomio(){
        return this.btnArmarBinomio;
    }//end method getBtnArmarBinomio

    /**GET Method Propertie btnRegistrarEvento*/
    public JButton getBtnRegistrarEvento(){
        return this.btnRegistrarEvento;
    }//end method getBtnRegistrarEvento

    /**GET Method Propertie btnRegistrarMision*/
    public JButton getBtnRegistrarMision(){
        return this.btnRegistrarMision;
    }//end method getBtnRegistrarMision

    /**GET Method Propertie btnListarGuiaPerro*/
    public JButton getBtnListarGuiaPerro(){
        return this.btnListarGuiaPerro;
    }//end method getBtnListarGuiaPerro

    /**GET Method Propertie btnFiltrarMision*/
    public JButton getBtnFiltrarMision(){
        return this.btnFiltrarMision;
    }//end method getBtnFiltrarMision

    /**GET Method Propertie btnDesempeno*/
    public JButton getBtnDesempeno(){
        return this.btnDesempeno;
    }//end method getBtnDesempeno

    public JButton getBtnDesempenoConjunto(){
        return this.btnDesempenoConjunto;
    }

    /**GET Method Propertie btnMayorDesempeno*/
    public JButton getBtnMayorDesempeno(){
        return this.btnMayorDesempeno;
    }//end method getBtnMayorDesempeno

    /**GET Method Propertie btnBinomiosDisponibles*/
    public JButton getBtnBinomiosDisponibles(){
        return this.btnBinomiosDisponibles;
    }//end method getBtnBinomiosDisponibles

    //End GetterSetterExtension Source Code

    // ==================== MÉTODOS PRESENTACIÓN====================
    
    public void actualizarContadores(int equipos, int misiones, int disponibles) {
        lblEquipos.setText(equipos + "  equipos");
        lblMisiones.setText(misiones + "  misiones");
        lblDisponibles.setText(disponibles + "  disponibles");
    }

    public void mostrarMensaje(String mensaje) {
        lblMensaje.setText(mensaje);
    }

    public void mostrarMensajeEmergente(String texto) {
        JOptionPane.showMessageDialog(this, texto, "Desempeño conjunto", JOptionPane.INFORMATION_MESSAGE);
    }

  
    public void limpiarBusqueda() {
        txtBuscar.setText("");
        lblMensaje.setText(" ");
    }

    public void seleccionarPrimeraFila() {
        if (tabla.getRowCount() > 0) {
            tabla.setRowSelectionInterval(0, 0);
        }
    }

   
    public void mostrarMisiones(ArrayList<Mision> lista) {
        mostradas = new ArrayList<>(lista);
        modelo.setRowCount(0);
        for (Mision m : mostradas) {
            String lugar = (m.getEvento() != null && m.getEvento().getLugar() != null)
                    ? m.getEvento().getLugar().getNombre() : "-";
            modelo.addRow(new Object[]{
                m.getCodigo(),
                m.getFecha() != null ? m.getFecha().toString() : "-",
                lugar,
                m.getEquipo() != null ? m.getEquipo().getNombre() : "-",
                m.getHorasLabor(),
                m.getSobrevivientes(),
                m.getFallecidos()
            });
        }
    }

    // Panel oeste
    public void mostrarBinomio(Binomio b) {
        if (b == null) {
            lblGuia.setText("Guía: —");
            lblCedula.setText("Cédula: —");
            lblCert.setText("Certificación: —");
            lblPerro.setText("Perro: —");
            lblRaza.setText("Raza: —");
            return;
        }
        Guia g = b.getGuia();
        Perro p = b.getPerro();
        lblGuia.setText("Guía: " + (g != null ? g.getNombreCompleto() : "—"));
        lblCedula.setText("Cédula: " + (g != null ? g.getCedula() : "—"));
        lblCert.setText("Certificación: " + (g != null ? g.getCertificacion() : "—"));
        lblPerro.setText("Perro: " + (p != null ? p.getNombre() : "—"));
        lblRaza.setText("Raza: " + (p != null ? p.getRaza() : "—"));
    }

    // Panel este
    public void mostrarEvento(Evento ev) {
        if (ev == null) {
            lblTipo.setText("Tipo: —");
            lblMagnitud.setText("Magnitud: —");
            lblLugar.setText("Lugar: —");
            lblMunicipio.setText("Municipio: —");
            lblFecha.setText("Fecha: —");
            return;
        }
        lblTipo.setText("Tipo: " + ev.getTipo());
        lblMagnitud.setText(ev.getNombreDato() + ": " + ev.getValorDato());
        lblLugar.setText("Lugar: " + (ev.getLugar() != null ? ev.getLugar().getNombre() : "—"));
        lblMunicipio.setText("Municipio: " + (ev.getLugar() != null && ev.getLugar().getMunicipio() != null
                ? ev.getLugar().getMunicipio().getNombre() : "—"));
        lblFecha.setText("Fecha: " + (ev.getFecha() != null ? ev.getFecha().toString() : "—"));
    }
    
    
    public Mision getMisionSeleccionada() {
    int fila = tabla.getSelectedRow();
    if (fila >= 0 && fila < mostradas.size()) {
        return mostradas.get(fila);
    }
    return null;
    }

    public void limpiarDetalle() {
        mostrarBinomio(null);
        mostrarEvento(null);
    }
       
  }