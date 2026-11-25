package vista;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de Condominius. Solo contiene los componentes graficos.
 */
public class JFCondominio extends JFrame
{
    // Condominios y unidades
    private JTextField txtCodigoCondominio, txtNombreCondominio, txtDireccion;
    private JButton btnRegistrarCondominio;
    private JTextField txtCondominioUnidad, txtCodigoUnidad, txtArea, txtTorre, txtPiso, txtNumeroPisos;
    private JComboBox<String> cbTipoUnidad;
    private JCheckBox chkPatio;
    private JButton btnRegistrarUnidad, btnListarCondominios;

    // Personas
    private JComboBox<String> cbTipoPersona, cbTurno;
    private JTextField txtCedula, txtNombre, txtTelefono, txtUnidadResidente, txtCondominioPersona;
    private JButton btnRegistrarPersona;
    private JTextField txtCedulaPropietario, txtUnidadPropiedad;
    private JButton btnAsignarPropiedad, btnListarPersonas;

    // Visitantes
    private JTextField txtCedulaVisitante, txtNombreVisitante, txtTelefonoVisitante, txtUnidadVisita, txtCedulaVigilante, txtHoraIngreso;
    private JButton btnRegistrarIngreso;
    private JTextField txtCedulaSalida, txtHoraSalida;
    private JButton btnRegistrarSalida, btnVisitantesDentro, btnHistorialVisitas;

    // Vehiculos
    private JTextField txtPlaca, txtMarca, txtColor, txtUnidadVehiculo, txtPlacaConsulta;
    private JComboBox<String> cbTipoVehiculo;
    private JButton btnRegistrarVehiculo, btnConsultarPlaca, btnListarVehiculos;

    // Pagos
    private JTextField txtUnidadPago, txtMes, txtAnio, txtValor;
    private JButton btnRegistrarPago, btnConsultarEstado, btnMorosos;

    // Reservas
    private JTextField txtUnidadReserva, txtFecha, txtHoraInicio, txtHoraFin, txtPersonas, txtNumeroReserva;
    private JComboBox<String> cbZona;
    private JButton btnReservar, btnCancelarReserva, btnListarReservas;

    // Paquetes
    private JTextField txtUnidadPaquete, txtRemitente, txtDescripcion, txtNumeroPaquete, txtCedulaRecibe;
    private JButton btnRegistrarPaquete, btnEntregarPaquete, btnPaquetesPendientes;

    // Reportes
    private JButton btnReporteGeneral;

    private JTextArea txtSalida;

    public JFCondominio(){
        setTitle("Condominius - Gestión de condominios");
        setSize(820,720);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane pestanas = new JTabbedPane();

        // ==================== CONDOMINIOS Y UNIDADES ====================
        JPanel panelCondominio = new JPanel(new GridLayout(4,2,5,5));
        panelCondominio.setBorder(BorderFactory.createTitledBorder("Nuevo condominio"));

        txtCodigoCondominio = new JTextField();
        txtNombreCondominio = new JTextField();
        txtDireccion = new JTextField();
        btnRegistrarCondominio = new JButton("Registrar condominio");

        panelCondominio.add(new JLabel("Código condominio")); panelCondominio.add(txtCodigoCondominio);
        panelCondominio.add(new JLabel("Nombre")); panelCondominio.add(txtNombreCondominio);
        panelCondominio.add(new JLabel("Dirección")); panelCondominio.add(txtDireccion);
        panelCondominio.add(new JLabel("")); panelCondominio.add(btnRegistrarCondominio);

        JPanel panelUnidad = new JPanel(new GridLayout(9,2,5,5));
        panelUnidad.setBorder(BorderFactory.createTitledBorder("Nueva unidad"));

        txtCondominioUnidad = new JTextField();
        cbTipoUnidad = new JComboBox<String>(new String[] {"Apartamento","Casa"});
        txtCodigoUnidad = new JTextField();
        txtArea = new JTextField();
        txtTorre = new JTextField();
        txtPiso = new JTextField();
        txtNumeroPisos = new JTextField();
        chkPatio = new JCheckBox("Tiene patio (solo casa)");
        btnRegistrarUnidad = new JButton("Registrar unidad");
        btnListarCondominios = new JButton("Ver condominios y unidades");

        panelUnidad.add(new JLabel("Código del condominio")); panelUnidad.add(txtCondominioUnidad);
        panelUnidad.add(new JLabel("Tipo de unidad")); panelUnidad.add(cbTipoUnidad);
        panelUnidad.add(new JLabel("Código unidad (único, ej: T1-101)")); panelUnidad.add(txtCodigoUnidad);
        panelUnidad.add(new JLabel("Área en m2 (20 a 1000)")); panelUnidad.add(txtArea);
        panelUnidad.add(new JLabel("Torre (solo apartamento)")); panelUnidad.add(txtTorre);
        panelUnidad.add(new JLabel("Piso 1 a 40 (solo apartamento)")); panelUnidad.add(txtPiso);
        panelUnidad.add(new JLabel("Número de pisos 1 a 4 (solo casa)")); panelUnidad.add(txtNumeroPisos);
        panelUnidad.add(new JLabel("")); panelUnidad.add(chkPatio);
        panelUnidad.add(btnListarCondominios); panelUnidad.add(btnRegistrarUnidad);

        JPanel datosCondominio = new JPanel(new BorderLayout(5,5));
        datosCondominio.add(panelCondominio, BorderLayout.NORTH);
        datosCondominio.add(panelUnidad, BorderLayout.CENTER);
        JPanel contenedorCondominio = new JPanel(new BorderLayout());
        contenedorCondominio.add(datosCondominio, BorderLayout.NORTH);

        // ==================== PERSONAS ====================
        JPanel panelPersona = new JPanel(new GridLayout(8,2,5,5));
        panelPersona.setBorder(BorderFactory.createTitledBorder("Registrar persona"));

        cbTipoPersona = new JComboBox<String>(new String[] {"Propietario","Residente","Administrador","Vigilante"});
        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtUnidadResidente = new JTextField();
        txtCondominioPersona = new JTextField();
        cbTurno = new JComboBox<String>(new String[] {"Dia","Noche"});
        btnRegistrarPersona = new JButton("Registrar persona");

        panelPersona.add(new JLabel("Tipo de persona")); panelPersona.add(cbTipoPersona);
        panelPersona.add(new JLabel("Cédula")); panelPersona.add(txtCedula);
        panelPersona.add(new JLabel("Nombre completo")); panelPersona.add(txtNombre);
        panelPersona.add(new JLabel("Teléfono")); panelPersona.add(txtTelefono);
        panelPersona.add(new JLabel("Código unidad (solo residente)")); panelPersona.add(txtUnidadResidente);
        panelPersona.add(new JLabel("Código condominio (admin. / vigilante)")); panelPersona.add(txtCondominioPersona);
        panelPersona.add(new JLabel("Turno (solo vigilante)")); panelPersona.add(cbTurno);
        panelPersona.add(new JLabel("")); panelPersona.add(btnRegistrarPersona);

        JPanel panelPropiedad = new JPanel(new GridLayout(3,2,5,5));
        panelPropiedad.setBorder(BorderFactory.createTitledBorder("Asignar unidad a un propietario"));

        txtCedulaPropietario = new JTextField();
        txtUnidadPropiedad = new JTextField();
        btnAsignarPropiedad = new JButton("Asignar unidad");
        btnListarPersonas = new JButton("Ver personas");

        panelPropiedad.add(new JLabel("Cédula del propietario")); panelPropiedad.add(txtCedulaPropietario);
        panelPropiedad.add(new JLabel("Código de la unidad")); panelPropiedad.add(txtUnidadPropiedad);
        panelPropiedad.add(btnListarPersonas); panelPropiedad.add(btnAsignarPropiedad);

        JPanel datosPersona = new JPanel(new BorderLayout(5,5));
        datosPersona.add(panelPersona, BorderLayout.NORTH);
        datosPersona.add(panelPropiedad, BorderLayout.CENTER);
        JPanel contenedorPersona = new JPanel(new BorderLayout());
        contenedorPersona.add(datosPersona, BorderLayout.NORTH);

        // ==================== VISITANTES ====================
        JPanel panelIngreso = new JPanel(new GridLayout(7,2,5,5));
        panelIngreso.setBorder(BorderFactory.createTitledBorder("Ingreso de visitante"));

        txtCedulaVisitante = new JTextField();
        txtNombreVisitante = new JTextField();
        txtTelefonoVisitante = new JTextField();
        txtUnidadVisita = new JTextField();
        txtCedulaVigilante = new JTextField();
        txtHoraIngreso = new JTextField();
        btnRegistrarIngreso = new JButton("Registrar ingreso");

        panelIngreso.add(new JLabel("Cédula visitante")); panelIngreso.add(txtCedulaVisitante);
        panelIngreso.add(new JLabel("Nombre visitante")); panelIngreso.add(txtNombreVisitante);
        panelIngreso.add(new JLabel("Teléfono visitante")); panelIngreso.add(txtTelefonoVisitante);
        panelIngreso.add(new JLabel("Código unidad que visita")); panelIngreso.add(txtUnidadVisita);
        panelIngreso.add(new JLabel("Cédula del vigilante")); panelIngreso.add(txtCedulaVigilante);
        panelIngreso.add(new JLabel("Hora de ingreso (0 a 23)")); panelIngreso.add(txtHoraIngreso);
        panelIngreso.add(new JLabel("")); panelIngreso.add(btnRegistrarIngreso);

        JPanel panelSalida = new JPanel(new GridLayout(4,2,5,5));
        panelSalida.setBorder(BorderFactory.createTitledBorder("Salida de visitante"));

        txtCedulaSalida = new JTextField();
        txtHoraSalida = new JTextField();
        btnRegistrarSalida = new JButton("Registrar salida");
        btnVisitantesDentro = new JButton("Visitantes dentro");
        btnHistorialVisitas = new JButton("Historial de visitas");

        panelSalida.add(new JLabel("Cédula visitante")); panelSalida.add(txtCedulaSalida);
        panelSalida.add(new JLabel("Hora de salida (0 a 23)")); panelSalida.add(txtHoraSalida);
        panelSalida.add(new JLabel("")); panelSalida.add(btnRegistrarSalida);
        panelSalida.add(btnVisitantesDentro); panelSalida.add(btnHistorialVisitas);

        JPanel datosVisitante = new JPanel(new BorderLayout(5,5));
        datosVisitante.add(panelIngreso, BorderLayout.NORTH);
        datosVisitante.add(panelSalida, BorderLayout.CENTER);
        JPanel contenedorVisitante = new JPanel(new BorderLayout());
        contenedorVisitante.add(datosVisitante, BorderLayout.NORTH);

        // ==================== VEHICULOS ====================
        JPanel panelVehiculo = new JPanel(new GridLayout(6,2,5,5));
        panelVehiculo.setBorder(BorderFactory.createTitledBorder("Autorizar vehículo"));

        txtPlaca = new JTextField();
        cbTipoVehiculo = new JComboBox<String>(new String[] {"Carro","Moto"});
        txtMarca = new JTextField();
        txtColor = new JTextField();
        txtUnidadVehiculo = new JTextField();
        btnRegistrarVehiculo = new JButton("Autorizar vehículo");

        panelVehiculo.add(new JLabel("Placa (carro ABC123, moto ABC12D)")); panelVehiculo.add(txtPlaca);
        panelVehiculo.add(new JLabel("Tipo")); panelVehiculo.add(cbTipoVehiculo);
        panelVehiculo.add(new JLabel("Marca")); panelVehiculo.add(txtMarca);
        panelVehiculo.add(new JLabel("Color")); panelVehiculo.add(txtColor);
        panelVehiculo.add(new JLabel("Código unidad (máx. 2 vehículos)")); panelVehiculo.add(txtUnidadVehiculo);
        panelVehiculo.add(new JLabel("")); panelVehiculo.add(btnRegistrarVehiculo);

        JPanel panelConsultaPlaca = new JPanel(new GridLayout(2,2,5,5));
        panelConsultaPlaca.setBorder(BorderFactory.createTitledBorder("Control en portería"));

        txtPlacaConsulta = new JTextField();
        btnConsultarPlaca = new JButton("Consultar placa");
        btnListarVehiculos = new JButton("Ver vehículos autorizados");

        panelConsultaPlaca.add(new JLabel("Placa")); panelConsultaPlaca.add(txtPlacaConsulta);
        panelConsultaPlaca.add(btnListarVehiculos); panelConsultaPlaca.add(btnConsultarPlaca);

        JPanel datosVehiculo = new JPanel(new BorderLayout(5,5));
        datosVehiculo.add(panelVehiculo, BorderLayout.NORTH);
        datosVehiculo.add(panelConsultaPlaca, BorderLayout.CENTER);
        JPanel contenedorVehiculo = new JPanel(new BorderLayout());
        contenedorVehiculo.add(datosVehiculo, BorderLayout.NORTH);

        // ==================== PAGOS ====================
        JPanel panelPago = new JPanel(new GridLayout(6,2,5,5));
        panelPago.setBorder(BorderFactory.createTitledBorder("Pagos de administración"));

        txtUnidadPago = new JTextField();
        txtMes = new JTextField();
        txtAnio = new JTextField();
        txtValor = new JTextField();
        btnRegistrarPago = new JButton("Registrar pago");
        btnConsultarEstado = new JButton("Consultar estado de la unidad");
        btnMorosos = new JButton("Unidades en mora del mes");

        panelPago.add(new JLabel("Código unidad")); panelPago.add(txtUnidadPago);
        panelPago.add(new JLabel("Mes (1 a 12)")); panelPago.add(txtMes);
        panelPago.add(new JLabel("Año")); panelPago.add(txtAnio);
        panelPago.add(new JLabel("Valor del pago")); panelPago.add(txtValor);
        panelPago.add(new JLabel("")); panelPago.add(btnRegistrarPago);
        panelPago.add(btnMorosos); panelPago.add(btnConsultarEstado);

        JPanel contenedorPago = new JPanel(new BorderLayout());
        contenedorPago.add(panelPago, BorderLayout.NORTH);

        // ==================== RESERVAS ====================
        JPanel panelReserva = new JPanel(new GridLayout(7,2,5,5));
        panelReserva.setBorder(BorderFactory.createTitledBorder("Reservar zona común"));

        txtUnidadReserva = new JTextField();
        cbZona = new JComboBox<String>(new String[] {"Salon social","Piscina","Zona deportiva"});
        txtFecha = new JTextField();
        txtHoraInicio = new JTextField();
        txtHoraFin = new JTextField();
        txtPersonas = new JTextField();
        btnReservar = new JButton("Reservar");

        panelReserva.add(new JLabel("Código unidad")); panelReserva.add(txtUnidadReserva);
        panelReserva.add(new JLabel("Zona común")); panelReserva.add(cbZona);
        panelReserva.add(new JLabel("Fecha (dd/mm/aaaa)")); panelReserva.add(txtFecha);
        panelReserva.add(new JLabel("Hora inicio (0 a 23)")); panelReserva.add(txtHoraInicio);
        panelReserva.add(new JLabel("Hora fin (1 a 24)")); panelReserva.add(txtHoraFin);
        panelReserva.add(new JLabel("Número de personas")); panelReserva.add(txtPersonas);
        panelReserva.add(new JLabel("")); panelReserva.add(btnReservar);

        JPanel panelCancelar = new JPanel(new GridLayout(2,2,5,5));
        panelCancelar.setBorder(BorderFactory.createTitledBorder("Cancelar o consultar reservas"));

        txtNumeroReserva = new JTextField();
        btnCancelarReserva = new JButton("Cancelar reserva");
        btnListarReservas = new JButton("Ver reservas");

        panelCancelar.add(new JLabel("Número de reserva")); panelCancelar.add(txtNumeroReserva);
        panelCancelar.add(btnListarReservas); panelCancelar.add(btnCancelarReserva);

        JPanel datosReserva = new JPanel(new BorderLayout(5,5));
        datosReserva.add(panelReserva, BorderLayout.NORTH);
        datosReserva.add(panelCancelar, BorderLayout.CENTER);
        JPanel contenedorReserva = new JPanel(new BorderLayout());
        contenedorReserva.add(datosReserva, BorderLayout.NORTH);

        // ==================== PAQUETES ====================
        JPanel panelPaquete = new JPanel(new GridLayout(4,2,5,5));
        panelPaquete.setBorder(BorderFactory.createTitledBorder("Recibir paquete en portería"));

        txtUnidadPaquete = new JTextField();
        txtRemitente = new JTextField();
        txtDescripcion = new JTextField();
        btnRegistrarPaquete = new JButton("Registrar paquete");

        panelPaquete.add(new JLabel("Código unidad")); panelPaquete.add(txtUnidadPaquete);
        panelPaquete.add(new JLabel("Remitente")); panelPaquete.add(txtRemitente);
        panelPaquete.add(new JLabel("Descripción")); panelPaquete.add(txtDescripcion);
        panelPaquete.add(new JLabel("")); panelPaquete.add(btnRegistrarPaquete);

        JPanel panelEntrega = new JPanel(new GridLayout(3,2,5,5));
        panelEntrega.setBorder(BorderFactory.createTitledBorder("Entregar paquete"));

        txtNumeroPaquete = new JTextField();
        txtCedulaRecibe = new JTextField();
        btnEntregarPaquete = new JButton("Entregar paquete");
        btnPaquetesPendientes = new JButton("Paquetes pendientes");

        panelEntrega.add(new JLabel("Número del paquete")); panelEntrega.add(txtNumeroPaquete);
        panelEntrega.add(new JLabel("Cédula de quien recibe")); panelEntrega.add(txtCedulaRecibe);
        panelEntrega.add(btnPaquetesPendientes); panelEntrega.add(btnEntregarPaquete);

        JPanel datosPaquete = new JPanel(new BorderLayout(5,5));
        datosPaquete.add(panelPaquete, BorderLayout.NORTH);
        datosPaquete.add(panelEntrega, BorderLayout.CENTER);
        JPanel contenedorPaquete = new JPanel(new BorderLayout());
        contenedorPaquete.add(datosPaquete, BorderLayout.NORTH);

        // ==================== REPORTES ====================
        JPanel panelReporte = new JPanel(new GridLayout(1,1,5,5));
        btnReporteGeneral = new JButton("Reporte general");
        panelReporte.add(btnReporteGeneral);

        JPanel contenedorReporte = new JPanel(new BorderLayout());
        contenedorReporte.add(panelReporte, BorderLayout.NORTH);

        pestanas.addTab("Condominios", contenedorCondominio);
        pestanas.addTab("Personas", contenedorPersona);
        pestanas.addTab("Visitantes", contenedorVisitante);
        pestanas.addTab("Vehículos", contenedorVehiculo);
        pestanas.addTab("Pagos", contenedorPago);
        pestanas.addTab("Reservas", contenedorReserva);
        pestanas.addTab("Paquetes", contenedorPaquete);
        pestanas.addTab("Reportes", contenedorReporte);

        txtSalida = new JTextArea(12,60);
        txtSalida.setEditable(false);

        add(pestanas, BorderLayout.CENTER);
        add(new JScrollPane(txtSalida), BorderLayout.SOUTH);
    }

    // ==================== METODOS DE LA VISTA ====================

    public void limpiarCondominio(){
        txtCodigoCondominio.setText("");
        txtNombreCondominio.setText("");
        txtDireccion.setText("");
    }

    public void limpiarUnidad(){
        txtCodigoUnidad.setText("");
        txtArea.setText("");
        txtTorre.setText("");
        txtPiso.setText("");
        txtNumeroPisos.setText("");
        chkPatio.setSelected(false);
    }

    public void limpiarPersona(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtUnidadResidente.setText("");
        txtCondominioPersona.setText("");
    }

    public void limpiarPropiedad(){
        txtCedulaPropietario.setText("");
        txtUnidadPropiedad.setText("");
    }

    public void limpiarIngreso(){
        txtCedulaVisitante.setText("");
        txtNombreVisitante.setText("");
        txtTelefonoVisitante.setText("");
        txtUnidadVisita.setText("");
        txtHoraIngreso.setText("");
    }

    public void limpiarSalida(){
        txtCedulaSalida.setText("");
        txtHoraSalida.setText("");
    }

    public void limpiarVehiculo(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtColor.setText("");
        txtUnidadVehiculo.setText("");
    }

    public void limpiarPago(){
        txtValor.setText("");
    }

    public void limpiarReserva(){
        txtFecha.setText("");
        txtHoraInicio.setText("");
        txtHoraFin.setText("");
        txtPersonas.setText("");
    }

    public void limpiarPaquete(){
        txtUnidadPaquete.setText("");
        txtRemitente.setText("");
        txtDescripcion.setText("");
    }

    public void limpiarEntrega(){
        txtNumeroPaquete.setText("");
        txtCedulaRecibe.setText("");
    }

    // ==================== GET ====================

    public JTextField getTxtCodigoCondominio(){
        return this.txtCodigoCondominio;
    }

    public JTextField getTxtNombreCondominio(){
        return this.txtNombreCondominio;
    }

    public JTextField getTxtDireccion(){
        return this.txtDireccion;
    }

    public JButton getBtnRegistrarCondominio(){
        return this.btnRegistrarCondominio;
    }

    public JTextField getTxtCondominioUnidad(){
        return this.txtCondominioUnidad;
    }

    public JTextField getTxtCodigoUnidad(){
        return this.txtCodigoUnidad;
    }

    public JTextField getTxtArea(){
        return this.txtArea;
    }

    public JTextField getTxtTorre(){
        return this.txtTorre;
    }

    public JTextField getTxtPiso(){
        return this.txtPiso;
    }

    public JTextField getTxtNumeroPisos(){
        return this.txtNumeroPisos;
    }

    public JComboBox<String> getCbTipoUnidad(){
        return this.cbTipoUnidad;
    }

    public JCheckBox getChkPatio(){
        return this.chkPatio;
    }

    public JButton getBtnRegistrarUnidad(){
        return this.btnRegistrarUnidad;
    }

    public JButton getBtnListarCondominios(){
        return this.btnListarCondominios;
    }

    public JComboBox<String> getCbTipoPersona(){
        return this.cbTipoPersona;
    }

    public JComboBox<String> getCbTurno(){
        return this.cbTurno;
    }

    public JTextField getTxtCedula(){
        return this.txtCedula;
    }

    public JTextField getTxtNombre(){
        return this.txtNombre;
    }

    public JTextField getTxtTelefono(){
        return this.txtTelefono;
    }

    public JTextField getTxtUnidadResidente(){
        return this.txtUnidadResidente;
    }

    public JTextField getTxtCondominioPersona(){
        return this.txtCondominioPersona;
    }

    public JButton getBtnRegistrarPersona(){
        return this.btnRegistrarPersona;
    }

    public JTextField getTxtCedulaPropietario(){
        return this.txtCedulaPropietario;
    }

    public JTextField getTxtUnidadPropiedad(){
        return this.txtUnidadPropiedad;
    }

    public JButton getBtnAsignarPropiedad(){
        return this.btnAsignarPropiedad;
    }

    public JButton getBtnListarPersonas(){
        return this.btnListarPersonas;
    }

    public JTextField getTxtCedulaVisitante(){
        return this.txtCedulaVisitante;
    }

    public JTextField getTxtNombreVisitante(){
        return this.txtNombreVisitante;
    }

    public JTextField getTxtTelefonoVisitante(){
        return this.txtTelefonoVisitante;
    }

    public JTextField getTxtUnidadVisita(){
        return this.txtUnidadVisita;
    }

    public JTextField getTxtCedulaVigilante(){
        return this.txtCedulaVigilante;
    }

    public JTextField getTxtHoraIngreso(){
        return this.txtHoraIngreso;
    }

    public JButton getBtnRegistrarIngreso(){
        return this.btnRegistrarIngreso;
    }

    public JTextField getTxtCedulaSalida(){
        return this.txtCedulaSalida;
    }

    public JTextField getTxtHoraSalida(){
        return this.txtHoraSalida;
    }

    public JButton getBtnRegistrarSalida(){
        return this.btnRegistrarSalida;
    }

    public JButton getBtnVisitantesDentro(){
        return this.btnVisitantesDentro;
    }

    public JButton getBtnHistorialVisitas(){
        return this.btnHistorialVisitas;
    }

    public JTextField getTxtPlaca(){
        return this.txtPlaca;
    }

    public JTextField getTxtMarca(){
        return this.txtMarca;
    }

    public JTextField getTxtColor(){
        return this.txtColor;
    }

    public JTextField getTxtUnidadVehiculo(){
        return this.txtUnidadVehiculo;
    }

    public JTextField getTxtPlacaConsulta(){
        return this.txtPlacaConsulta;
    }

    public JComboBox<String> getCbTipoVehiculo(){
        return this.cbTipoVehiculo;
    }

    public JButton getBtnRegistrarVehiculo(){
        return this.btnRegistrarVehiculo;
    }

    public JButton getBtnConsultarPlaca(){
        return this.btnConsultarPlaca;
    }

    public JButton getBtnListarVehiculos(){
        return this.btnListarVehiculos;
    }

    public JTextField getTxtUnidadPago(){
        return this.txtUnidadPago;
    }

    public JTextField getTxtMes(){
        return this.txtMes;
    }

    public JTextField getTxtAnio(){
        return this.txtAnio;
    }

    public JTextField getTxtValor(){
        return this.txtValor;
    }

    public JButton getBtnRegistrarPago(){
        return this.btnRegistrarPago;
    }

    public JButton getBtnConsultarEstado(){
        return this.btnConsultarEstado;
    }

    public JButton getBtnMorosos(){
        return this.btnMorosos;
    }

    public JTextField getTxtUnidadReserva(){
        return this.txtUnidadReserva;
    }

    public JTextField getTxtFecha(){
        return this.txtFecha;
    }

    public JTextField getTxtHoraInicio(){
        return this.txtHoraInicio;
    }

    public JTextField getTxtHoraFin(){
        return this.txtHoraFin;
    }

    public JTextField getTxtPersonas(){
        return this.txtPersonas;
    }

    public JTextField getTxtNumeroReserva(){
        return this.txtNumeroReserva;
    }

    public JComboBox<String> getCbZona(){
        return this.cbZona;
    }

    public JButton getBtnReservar(){
        return this.btnReservar;
    }

    public JButton getBtnCancelarReserva(){
        return this.btnCancelarReserva;
    }

    public JButton getBtnListarReservas(){
        return this.btnListarReservas;
    }

    public JTextField getTxtUnidadPaquete(){
        return this.txtUnidadPaquete;
    }

    public JTextField getTxtRemitente(){
        return this.txtRemitente;
    }

    public JTextField getTxtDescripcion(){
        return this.txtDescripcion;
    }

    public JTextField getTxtNumeroPaquete(){
        return this.txtNumeroPaquete;
    }

    public JTextField getTxtCedulaRecibe(){
        return this.txtCedulaRecibe;
    }

    public JButton getBtnRegistrarPaquete(){
        return this.btnRegistrarPaquete;
    }

    public JButton getBtnEntregarPaquete(){
        return this.btnEntregarPaquete;
    }

    public JButton getBtnPaquetesPendientes(){
        return this.btnPaquetesPendientes;
    }

    public JButton getBtnReporteGeneral(){
        return this.btnReporteGeneral;
    }

    public JTextArea getTxtSalida(){
        return this.txtSalida;
    }
}//End class
