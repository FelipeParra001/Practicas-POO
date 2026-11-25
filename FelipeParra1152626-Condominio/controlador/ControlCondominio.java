package controlador;
import modelo.*;
import vista.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Controlador de Condominius: recibe los clics de la vista, lee los datos,
 * los valida y llama al modelo. Los errores se muestran con JOptionPane.
 */
public class ControlCondominio implements ActionListener
{
    private JFCondominio vista;
    private Condominius modelo;

    public ControlCondominio(JFCondominio vista, Condominius modelo){
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnRegistrarCondominio().addActionListener(this);
        this.vista.getBtnRegistrarUnidad().addActionListener(this);
        this.vista.getBtnListarCondominios().addActionListener(this);
        this.vista.getBtnRegistrarPersona().addActionListener(this);
        this.vista.getBtnAsignarPropiedad().addActionListener(this);
        this.vista.getBtnListarPersonas().addActionListener(this);
        this.vista.getBtnRegistrarIngreso().addActionListener(this);
        this.vista.getBtnRegistrarSalida().addActionListener(this);
        this.vista.getBtnVisitantesDentro().addActionListener(this);
        this.vista.getBtnHistorialVisitas().addActionListener(this);
        this.vista.getBtnRegistrarVehiculo().addActionListener(this);
        this.vista.getBtnConsultarPlaca().addActionListener(this);
        this.vista.getBtnListarVehiculos().addActionListener(this);
        this.vista.getBtnRegistrarPago().addActionListener(this);
        this.vista.getBtnConsultarEstado().addActionListener(this);
        this.vista.getBtnMorosos().addActionListener(this);
        this.vista.getBtnReservar().addActionListener(this);
        this.vista.getBtnCancelarReserva().addActionListener(this);
        this.vista.getBtnListarReservas().addActionListener(this);
        this.vista.getBtnRegistrarPaquete().addActionListener(this);
        this.vista.getBtnEntregarPaquete().addActionListener(this);
        this.vista.getBtnPaquetesPendientes().addActionListener(this);
        this.vista.getBtnReporteGeneral().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == vista.getBtnRegistrarCondominio()){
            registrarCondominio();
        }
        else if(source == vista.getBtnRegistrarUnidad()){
            registrarUnidad();
        }
        else if(source == vista.getBtnListarCondominios()){
            vista.getTxtSalida().setText(modelo.listarCondominios());
        }
        else if(source == vista.getBtnRegistrarPersona()){
            registrarPersona();
        }
        else if(source == vista.getBtnAsignarPropiedad()){
            asignarPropiedad();
        }
        else if(source == vista.getBtnListarPersonas()){
            vista.getTxtSalida().setText(modelo.listarPersonas());
        }
        else if(source == vista.getBtnRegistrarIngreso()){
            registrarIngreso();
        }
        else if(source == vista.getBtnRegistrarSalida()){
            registrarSalida();
        }
        else if(source == vista.getBtnVisitantesDentro()){
            vista.getTxtSalida().setText(modelo.listarVisitantesDentro());
        }
        else if(source == vista.getBtnHistorialVisitas()){
            vista.getTxtSalida().setText(modelo.listarHistorialVisitas());
        }
        else if(source == vista.getBtnRegistrarVehiculo()){
            registrarVehiculo();
        }
        else if(source == vista.getBtnConsultarPlaca()){
            consultarPlaca();
        }
        else if(source == vista.getBtnListarVehiculos()){
            vista.getTxtSalida().setText(modelo.listarVehiculos());
        }
        else if(source == vista.getBtnRegistrarPago()){
            registrarPago();
        }
        else if(source == vista.getBtnConsultarEstado()){
            consultarEstado();
        }
        else if(source == vista.getBtnMorosos()){
            listarMorosos();
        }
        else if(source == vista.getBtnReservar()){
            reservar();
        }
        else if(source == vista.getBtnCancelarReserva()){
            cancelarReserva();
        }
        else if(source == vista.getBtnListarReservas()){
            vista.getTxtSalida().setText(modelo.listarReservas());
        }
        else if(source == vista.getBtnRegistrarPaquete()){
            registrarPaquete();
        }
        else if(source == vista.getBtnEntregarPaquete()){
            entregarPaquete();
        }
        else if(source == vista.getBtnPaquetesPendientes()){
            vista.getTxtSalida().setText(modelo.listarPaquetesPendientes());
        }
        else if(source == vista.getBtnReporteGeneral()){
            vista.getTxtSalida().setText(modelo.reporteGeneral());
        }
    }

    // ==================== METODOS DE APOYO ====================

    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(vista, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Convierte un texto a decimal, rechaza NaN e Infinity
    private double leerDecimal(String texto) throws NumberFormatException {
        double numero = Double.parseDouble(texto.trim());
        if(Double.isNaN(numero) || Double.isInfinite(numero)){
            throw new NumberFormatException("no es un numero real");
        }
        return numero;
    }

    private int leerEntero(String texto) throws NumberFormatException {
        return Integer.parseInt(texto.trim());
    }

    // ==================== CONDOMINIOS Y UNIDADES ====================

    private void registrarCondominio(){
        String codigo = vista.getTxtCodigoCondominio().getText().trim();
        String nombre = vista.getTxtNombreCondominio().getText().trim();
        String direccion = vista.getTxtDireccion().getText().trim();

        if(codigo.isEmpty() || nombre.isEmpty() || direccion.isEmpty()){
            mostrarError("Complete el código, el nombre y la dirección del condominio");
            return;
        }
        try{
            modelo.registrarCondominio(codigo, nombre, direccion);
            vista.getTxtSalida().setText("Condominio " + nombre + " registrado correctamente");
            vista.limpiarCondominio();
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void registrarUnidad(){
        String condominio = vista.getTxtCondominioUnidad().getText().trim();
        String codigo = vista.getTxtCodigoUnidad().getText().trim();
        String tipo = (String) vista.getCbTipoUnidad().getSelectedItem();

        if(condominio.isEmpty() || codigo.isEmpty() || vista.getTxtArea().getText().trim().isEmpty()){
            mostrarError("Complete el condominio, el código y el área de la unidad");
            return;
        }
        double area;
        try{
            area = leerDecimal(vista.getTxtArea().getText());
        }catch(NumberFormatException ex){
            mostrarError("El área debe ser un número");
            return;
        }
        try{
            if("Apartamento".equals(tipo)){
                String torre = vista.getTxtTorre().getText().trim();
                if(torre.isEmpty() || vista.getTxtPiso().getText().trim().isEmpty()){
                    mostrarError("Para un apartamento escriba la torre y el piso");
                    return;
                }
                int piso = leerEntero(vista.getTxtPiso().getText());
                modelo.registrarApartamento(condominio, codigo, area, torre, piso);
            }else{
                if(vista.getTxtNumeroPisos().getText().trim().isEmpty()){
                    mostrarError("Para una casa escriba el número de pisos");
                    return;
                }
                int pisos = leerEntero(vista.getTxtNumeroPisos().getText());
                modelo.registrarCasa(condominio, codigo, area, pisos, vista.getChkPatio().isSelected());
            }
            vista.getTxtSalida().setText(tipo + " " + codigo + " registrado correctamente");
            vista.limpiarUnidad();
        }catch(NumberFormatException ex){
            mostrarError("El piso o el número de pisos debe ser un número entero");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    // ==================== PERSONAS ====================

    private void registrarPersona(){
        String tipo = (String) vista.getCbTipoPersona().getSelectedItem();
        String cedula = vista.getTxtCedula().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();

        if(cedula.isEmpty() || nombre.isEmpty() || telefono.isEmpty()){
            mostrarError("Complete la cédula, el nombre y el teléfono");
            return;
        }
        try{
            if("Propietario".equals(tipo)){
                modelo.registrarPropietario(cedula, nombre, telefono);
            }
            else if("Residente".equals(tipo)){
                modelo.registrarResidente(cedula, nombre, telefono, vista.getTxtUnidadResidente().getText().trim());
            }
            else if("Administrador".equals(tipo)){
                modelo.registrarAdministrador(cedula, nombre, telefono, vista.getTxtCondominioPersona().getText().trim());
            }
            else{
                String turno = (String) vista.getCbTurno().getSelectedItem();
                modelo.registrarVigilante(cedula, nombre, telefono, vista.getTxtCondominioPersona().getText().trim(), turno);
            }
            vista.getTxtSalida().setText(tipo + " " + nombre + " registrado correctamente");
            vista.limpiarPersona();
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void asignarPropiedad(){
        String cedula = vista.getTxtCedulaPropietario().getText().trim();
        String unidad = vista.getTxtUnidadPropiedad().getText().trim();

        if(cedula.isEmpty() || unidad.isEmpty()){
            mostrarError("Escriba la cédula del propietario y el código de la unidad");
            return;
        }
        try{
            modelo.asignarPropiedad(cedula, unidad);
            vista.getTxtSalida().setText("Unidad " + unidad + " asignada al propietario " + cedula);
            vista.limpiarPropiedad();
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    // ==================== VISITANTES ====================

    private void registrarIngreso(){
        String cedula = vista.getTxtCedulaVisitante().getText().trim();
        String nombre = vista.getTxtNombreVisitante().getText().trim();
        String telefono = vista.getTxtTelefonoVisitante().getText().trim();
        String unidad = vista.getTxtUnidadVisita().getText().trim();
        String vigilante = vista.getTxtCedulaVigilante().getText().trim();
        String hora = vista.getTxtHoraIngreso().getText().trim();

        if(cedula.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || unidad.isEmpty() || vigilante.isEmpty() || hora.isEmpty()){
            mostrarError("Complete todos los datos del ingreso");
            return;
        }
        try{
            int horaIngreso = leerEntero(hora);
            modelo.registrarIngreso(cedula, nombre, telefono, unidad, vigilante, horaIngreso);
            vista.getTxtSalida().setText("Ingreso de " + nombre + " a la unidad " + unidad + " registrado");
            vista.limpiarIngreso();
        }catch(NumberFormatException ex){
            mostrarError("La hora de ingreso debe ser un número entero de 0 a 23");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void registrarSalida(){
        String cedula = vista.getTxtCedulaSalida().getText().trim();
        String hora = vista.getTxtHoraSalida().getText().trim();

        if(cedula.isEmpty() || hora.isEmpty()){
            mostrarError("Escriba la cédula del visitante y la hora de salida");
            return;
        }
        try{
            int horaSalida = leerEntero(hora);
            modelo.registrarSalida(cedula, horaSalida);
            vista.getTxtSalida().setText("Salida del visitante " + cedula + " registrada");
            vista.limpiarSalida();
        }catch(NumberFormatException ex){
            mostrarError("La hora de salida debe ser un número entero de 0 a 23");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    // ==================== VEHICULOS ====================

    private void registrarVehiculo(){
        String placa = vista.getTxtPlaca().getText().trim();
        String tipo = (String) vista.getCbTipoVehiculo().getSelectedItem();
        String marca = vista.getTxtMarca().getText().trim();
        String color = vista.getTxtColor().getText().trim();
        String unidad = vista.getTxtUnidadVehiculo().getText().trim();

        if(placa.isEmpty() || marca.isEmpty() || color.isEmpty() || unidad.isEmpty()){
            mostrarError("Complete la placa, la marca, el color y la unidad");
            return;
        }
        try{
            modelo.registrarVehiculo(placa, tipo, marca, color, unidad);
            vista.getTxtSalida().setText(tipo + " " + placa.toUpperCase() + " autorizado para la unidad " + unidad);
            vista.limpiarVehiculo();
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void consultarPlaca(){
        String placa = vista.getTxtPlacaConsulta().getText().trim();
        if(placa.isEmpty()){
            mostrarError("Escriba la placa a consultar");
            return;
        }
        try{
            vista.getTxtSalida().setText(modelo.consultarVehiculo(placa));
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    // ==================== PAGOS ====================

    private void registrarPago(){
        String unidad = vista.getTxtUnidadPago().getText().trim();
        String mes = vista.getTxtMes().getText().trim();
        String anio = vista.getTxtAnio().getText().trim();
        String valor = vista.getTxtValor().getText().trim();

        if(unidad.isEmpty() || mes.isEmpty() || anio.isEmpty() || valor.isEmpty()){
            mostrarError("Complete la unidad, el mes, el año y el valor");
            return;
        }
        int numeroMes, numeroAnio;
        double valorPago;
        try{
            numeroMes = leerEntero(mes);
            numeroAnio = leerEntero(anio);
        }catch(NumberFormatException ex){
            mostrarError("El mes y el año deben ser números enteros");
            return;
        }
        try{
            valorPago = leerDecimal(valor);
        }catch(NumberFormatException ex){
            mostrarError("El valor del pago debe ser un número");
            return;
        }
        try{
            modelo.registrarPago(unidad, numeroMes, numeroAnio, valorPago);
            vista.getTxtSalida().setText("Pago registrado.\n\n" + modelo.consultarEstado(unidad, numeroMes, numeroAnio));
            vista.limpiarPago();
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void consultarEstado(){
        String unidad = vista.getTxtUnidadPago().getText().trim();
        String mes = vista.getTxtMes().getText().trim();
        String anio = vista.getTxtAnio().getText().trim();

        if(unidad.isEmpty() || mes.isEmpty() || anio.isEmpty()){
            mostrarError("Para consultar escriba la unidad, el mes y el año");
            return;
        }
        try{
            vista.getTxtSalida().setText(modelo.consultarEstado(unidad, leerEntero(mes), leerEntero(anio)));
        }catch(NumberFormatException ex){
            mostrarError("El mes y el año deben ser números enteros");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void listarMorosos(){
        String mes = vista.getTxtMes().getText().trim();
        String anio = vista.getTxtAnio().getText().trim();

        if(mes.isEmpty() || anio.isEmpty()){
            mostrarError("Escriba el mes y el año a revisar");
            return;
        }
        try{
            vista.getTxtSalida().setText(modelo.listarMorosos(leerEntero(mes), leerEntero(anio)));
        }catch(NumberFormatException ex){
            mostrarError("El mes y el año deben ser números enteros");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    // ==================== RESERVAS ====================

    private void reservar(){
        String unidad = vista.getTxtUnidadReserva().getText().trim();
        String zona = (String) vista.getCbZona().getSelectedItem();
        String fecha = vista.getTxtFecha().getText().trim();
        String inicio = vista.getTxtHoraInicio().getText().trim();
        String fin = vista.getTxtHoraFin().getText().trim();
        String personas = vista.getTxtPersonas().getText().trim();

        if(unidad.isEmpty() || fecha.isEmpty() || inicio.isEmpty() || fin.isEmpty() || personas.isEmpty()){
            mostrarError("Complete todos los datos de la reserva");
            return;
        }
        try{
            int horaInicio = leerEntero(inicio);
            int horaFin = leerEntero(fin);
            int numeroPersonas = leerEntero(personas);
            int numero = modelo.registrarReserva(unidad, zona, fecha, horaInicio, horaFin, numeroPersonas);
            vista.getTxtSalida().setText("Reserva #" + numero + " registrada: " + zona + " el " + fecha + " de " + horaInicio + ":00 a " + horaFin + ":00");
            vista.limpiarReserva();
        }catch(NumberFormatException ex){
            mostrarError("Las horas y el número de personas deben ser números enteros");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void cancelarReserva(){
        String numero = vista.getTxtNumeroReserva().getText().trim();
        if(numero.isEmpty()){
            mostrarError("Escriba el número de la reserva");
            return;
        }
        try{
            int numeroReserva = leerEntero(numero);
            modelo.cancelarReserva(numeroReserva);
            vista.getTxtSalida().setText("Reserva #" + numeroReserva + " cancelada");
            vista.getTxtNumeroReserva().setText("");
        }catch(NumberFormatException ex){
            mostrarError("El número de reserva debe ser un número entero");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    // ==================== PAQUETES ====================

    private void registrarPaquete(){
        String unidad = vista.getTxtUnidadPaquete().getText().trim();
        String remitente = vista.getTxtRemitente().getText().trim();
        String descripcion = vista.getTxtDescripcion().getText().trim();

        if(unidad.isEmpty() || remitente.isEmpty() || descripcion.isEmpty()){
            mostrarError("Complete la unidad, el remitente y la descripción");
            return;
        }
        try{
            int numero = modelo.registrarPaquete(unidad, remitente, descripcion);
            vista.getTxtSalida().setText("Paquete #" + numero + " registrado para la unidad " + unidad);
            vista.limpiarPaquete();
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }

    private void entregarPaquete(){
        String numero = vista.getTxtNumeroPaquete().getText().trim();
        String cedula = vista.getTxtCedulaRecibe().getText().trim();

        if(numero.isEmpty() || cedula.isEmpty()){
            mostrarError("Escriba el número del paquete y la cédula de quien recibe");
            return;
        }
        try{
            int numeroPaquete = leerEntero(numero);
            modelo.entregarPaquete(numeroPaquete, cedula);
            vista.getTxtSalida().setText("Paquete #" + numeroPaquete + " entregado");
            vista.limpiarEntrega();
        }catch(NumberFormatException ex){
            mostrarError("El número del paquete debe ser un número entero");
        }catch(CondominioException ex){
            mostrarError(ex.getMessage());
        }
    }
}//End class
