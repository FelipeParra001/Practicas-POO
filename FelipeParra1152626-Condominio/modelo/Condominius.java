package modelo;
import java.util.ArrayList;

/**
 * Plataforma Condominius: centraliza la gestion de varios condominios.
 * Aqui estan las reglas de negocio y las validaciones del sistema.
 */
public class Condominius
{
    private ArrayList<Condominio> condominios;
    private ArrayList<Persona> personas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Pago> pagos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Visita> visitas;
    private ArrayList<Paquete> paquetes;
    private int consecutivoPago;
    private int consecutivoReserva;
    private int consecutivoPaquete;

    public Condominius(){
        condominios = new ArrayList<>();
        personas = new ArrayList<>();
        vehiculos = new ArrayList<>();
        pagos = new ArrayList<>();
        reservas = new ArrayList<>();
        visitas = new ArrayList<>();
        paquetes = new ArrayList<>();
        consecutivoPago = 1;
        consecutivoReserva = 1;
        consecutivoPaquete = 1;
    }

    // ==================== VALIDACIONES ====================

    private boolean textoValido(String texto){
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean soloDigitos(String texto, int minimo, int maximo){
        if(texto == null || texto.length() < minimo || texto.length() > maximo){
            return false;
        }
        for(int i = 0; i < texto.length(); i++){
            if(!Character.isDigit(texto.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean tieneDigitos(String texto){
        for(int i = 0; i < texto.length(); i++){
            if(Character.isDigit(texto.charAt(i))){
                return true;
            }
        }
        return false;
    }

    // Valida los datos comunes de cualquier persona
    private void validarPersona(String cedula, String nombre, String telefono) throws CondominioException {
        if(!textoValido(cedula) || !textoValido(nombre) || !textoValido(telefono)){
            throw new CondominioException("Complete la cédula, el nombre y el teléfono");
        }
        if(!soloDigitos(cedula, 6, 10)){
            throw new CondominioException("La cédula debe tener solo números (de 6 a 10 dígitos)");
        }
        if(tieneDigitos(nombre)){
            throw new CondominioException("El nombre no puede tener números");
        }
        if(!soloDigitos(telefono, 7, 10)){
            throw new CondominioException("El teléfono debe tener solo números (de 7 a 10 dígitos)");
        }
        if(buscarPersona(cedula) != null){
            throw new CondominioException("Ya existe una persona registrada con la cédula " + cedula);
        }
    }

    // Revisa que la fecha tenga formato dd/mm/aaaa y sea una fecha real
    public boolean fechaValida(String fecha){
        if(fecha == null){
            return false;
        }
        String[] partes = fecha.trim().split("/");
        if(partes.length != 3 || partes[0].length() != 2 || partes[1].length() != 2 || partes[2].length() != 4){
            return false;
        }
        if(!soloDigitos(partes[0], 2, 2) || !soloDigitos(partes[1], 2, 2) || !soloDigitos(partes[2], 4, 4)){
            return false;
        }
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);
        if(anio < 2000 || anio > 2100 || mes < 1 || mes > 12 || dia < 1){
            return false;
        }
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int maximo = diasMes[mes - 1];
        boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
        if(mes == 2 && bisiesto){
            maximo = 29;
        }
        return dia <= maximo;
    }

    // ==================== BUSQUEDAS ====================

    public Condominio buscarCondominio(String codigo){
        for(Condominio c : condominios){
            if(c.getCodigo().equalsIgnoreCase(codigo)){
                return c;
            }
        }
        return null;
    }

    public Unidad buscarUnidad(String codigo){
        for(Condominio c : condominios){
            for(Unidad u : c.getUnidades()){
                if(u.getCodigo().equalsIgnoreCase(codigo)){
                    return u;
                }
            }
        }
        return null;
    }

    public Persona buscarPersona(String cedula){
        for(Persona p : personas){
            if(p.getCedula().equals(cedula)){
                return p;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String placa){
        for(Vehiculo v : vehiculos){
            if(v.getPlaca().equalsIgnoreCase(placa)){
                return v;
            }
        }
        return null;
    }

    public Paquete buscarPaquete(int numero){
        for(Paquete p : paquetes){
            if(p.getNumero() == numero){
                return p;
            }
        }
        return null;
    }

    public Reserva buscarReserva(int numero){
        for(Reserva r : reservas){
            if(r.getNumero() == numero){
                return r;
            }
        }
        return null;
    }

    private Unidad unidadExistente(String codigo) throws CondominioException {
        if(!textoValido(codigo)){
            throw new CondominioException("Escriba el código de la unidad");
        }
        Unidad unidad = buscarUnidad(codigo.trim());
        if(unidad == null){
            throw new CondominioException("No existe la unidad " + codigo.trim());
        }
        return unidad;
    }

    private Condominio condominioExistente(String codigo) throws CondominioException {
        if(!textoValido(codigo)){
            throw new CondominioException("Escriba el código del condominio");
        }
        Condominio condominio = buscarCondominio(codigo.trim());
        if(condominio == null){
            throw new CondominioException("No existe el condominio " + codigo.trim());
        }
        return condominio;
    }

    private Visita visitaActiva(Visitante visitante){
        for(Visita v : visitas){
            if(v.getVisitante() == visitante && v.estaActiva()){
                return v;
            }
        }
        return null;
    }

    // ==================== CONDOMINIOS Y UNIDADES ====================

    public void registrarCondominio(String codigo, String nombre, String direccion) throws CondominioException {
        if(!textoValido(codigo) || !textoValido(nombre) || !textoValido(direccion)){
            throw new CondominioException("Complete el código, el nombre y la dirección del condominio");
        }
        if(buscarCondominio(codigo.trim()) != null){
            throw new CondominioException("Ya existe un condominio con el código " + codigo.trim());
        }
        condominios.add(new Condominio(codigo.trim(), nombre.trim(), direccion.trim()));
    }

    // Valida lo que tienen en comun un apartamento y una casa
    private Condominio validarUnidad(String codigoCondominio, String codigo, double area) throws CondominioException {
        Condominio condominio = condominioExistente(codigoCondominio);
        if(!textoValido(codigo)){
            throw new CondominioException("Escriba el código de la unidad");
        }
        if(buscarUnidad(codigo.trim()) != null){
            throw new CondominioException("Ya existe una unidad con el código " + codigo.trim());
        }
        if(Double.isNaN(area) || area < 20 || area > 1000){
            throw new CondominioException("El área debe estar entre 20 y 1000 m2");
        }
        return condominio;
    }

    public void registrarApartamento(String codigoCondominio, String codigo, double area, String torre, int piso) throws CondominioException {
        Condominio condominio = validarUnidad(codigoCondominio, codigo, area);
        if(!textoValido(torre)){
            throw new CondominioException("Escriba la torre del apartamento");
        }
        if(piso < 1 || piso > 40){
            throw new CondominioException("El piso debe estar entre 1 y 40");
        }
        condominio.agregarUnidad(new Apartamento(codigo.trim(), area, condominio, torre.trim(), piso));
    }

    public void registrarCasa(String codigoCondominio, String codigo, double area, int numeroPisos, boolean tienePatio) throws CondominioException {
        Condominio condominio = validarUnidad(codigoCondominio, codigo, area);
        if(numeroPisos < 1 || numeroPisos > 4){
            throw new CondominioException("La casa debe tener entre 1 y 4 pisos");
        }
        condominio.agregarUnidad(new Casa(codigo.trim(), area, condominio, numeroPisos, tienePatio));
    }

    // ==================== PERSONAS ====================

    public void registrarPropietario(String cedula, String nombre, String telefono) throws CondominioException {
        validarPersona(cedula, nombre, telefono);
        personas.add(new Propietario(cedula, nombre.trim(), telefono));
    }

    // Un propietario puede tener varias unidades, pero cada unidad tiene un solo propietario
    public void asignarPropiedad(String cedula, String codigoUnidad) throws CondominioException {
        if(!textoValido(cedula)){
            throw new CondominioException("Escriba la cédula del propietario");
        }
        Persona persona = buscarPersona(cedula.trim());
        if(!(persona instanceof Propietario)){
            throw new CondominioException("No existe un propietario con la cédula " + cedula.trim());
        }
        Unidad unidad = unidadExistente(codigoUnidad);
        if(unidad.getPropietario() != null){
            throw new CondominioException("La unidad " + unidad.getCodigo() + " ya tiene propietario: " + unidad.getPropietario().getNombre());
        }
        Propietario propietario = (Propietario) persona;
        unidad.setPropietario(propietario);
        propietario.agregarUnidad(unidad);
    }

    public void registrarResidente(String cedula, String nombre, String telefono, String codigoUnidad) throws CondominioException {
        validarPersona(cedula, nombre, telefono);
        Unidad unidad = unidadExistente(codigoUnidad);
        if(unidad.getResidentes().size() >= Unidad.MAX_RESIDENTES){
            throw new CondominioException("La unidad " + unidad.getCodigo() + " ya tiene el máximo de " + Unidad.MAX_RESIDENTES + " residentes");
        }
        Residente residente = new Residente(cedula, nombre.trim(), telefono, unidad);
        unidad.agregarResidente(residente);
        personas.add(residente);
    }

    public void registrarAdministrador(String cedula, String nombre, String telefono, String codigoCondominio) throws CondominioException {
        validarPersona(cedula, nombre, telefono);
        Condominio condominio = condominioExistente(codigoCondominio);
        if(condominio.getAdministrador() != null){
            throw new CondominioException("El condominio " + condominio.getNombre() + " ya tiene administrador");
        }
        Administrador administrador = new Administrador(cedula, nombre.trim(), telefono, condominio);
        condominio.setAdministrador(administrador);
        personas.add(administrador);
    }

    public void registrarVigilante(String cedula, String nombre, String telefono, String codigoCondominio, String turno) throws CondominioException {
        validarPersona(cedula, nombre, telefono);
        Condominio condominio = condominioExistente(codigoCondominio);
        if(!"Dia".equals(turno) && !"Noche".equals(turno)){
            throw new CondominioException("El turno debe ser Dia o Noche");
        }
        Vigilante vigilante = new Vigilante(cedula, nombre.trim(), telefono, condominio, turno);
        condominio.agregarVigilante(vigilante);
        personas.add(vigilante);
    }

    // ==================== VISITANTES ====================

    // Si el visitante ya habia venido antes se reutiliza su registro
    public void registrarIngreso(String cedula, String nombre, String telefono, String codigoUnidad, String cedulaVigilante, int hora) throws CondominioException {
        if(!textoValido(cedula) || !textoValido(nombre) || !textoValido(telefono)){
            throw new CondominioException("Complete la cédula, el nombre y el teléfono del visitante");
        }
        if(hora < 0 || hora > 23){
            throw new CondominioException("La hora de ingreso debe estar entre 0 y 23");
        }
        Unidad unidad = unidadExistente(codigoUnidad);
        if(!unidad.estaHabitada()){
            throw new CondominioException("La unidad " + unidad.getCodigo() + " no tiene propietario ni residentes a quien visitar");
        }
        if(!textoValido(cedulaVigilante)){
            throw new CondominioException("Escriba la cédula del vigilante que registra el ingreso");
        }
        Persona registra = buscarPersona(cedulaVigilante.trim());
        if(!(registra instanceof Vigilante)){
            throw new CondominioException("No existe un vigilante con la cédula " + cedulaVigilante.trim());
        }
        Vigilante vigilante = (Vigilante) registra;
        if(!unidad.getCondominio().tieneVigilante(vigilante)){
            throw new CondominioException("El vigilante " + vigilante.getNombre() + " no trabaja en " + unidad.getCondominio().getNombre());
        }

        Visitante visitante;
        Persona existente = buscarPersona(cedula.trim());
        if(existente == null){
            validarPersona(cedula.trim(), nombre, telefono);
            visitante = new Visitante(cedula.trim(), nombre.trim(), telefono.trim());
            personas.add(visitante);
        }
        else if(existente instanceof Visitante){
            visitante = (Visitante) existente;
            if(visitante.isDentro()){
                throw new CondominioException(visitante.getNombre() + " ya está dentro, primero registre su salida");
            }
        }
        else{
            throw new CondominioException("La cédula " + cedula.trim() + " pertenece a un " + existente.getRol() + ", no a un visitante");
        }
        visitante.entrar();
        visitas.add(new Visita(visitante, unidad, vigilante, hora));
    }

    public void registrarSalida(String cedula, int hora) throws CondominioException {
        if(!textoValido(cedula)){
            throw new CondominioException("Escriba la cédula del visitante");
        }
        if(hora < 0 || hora > 23){
            throw new CondominioException("La hora de salida debe estar entre 0 y 23");
        }
        Persona persona = buscarPersona(cedula.trim());
        if(!(persona instanceof Visitante)){
            throw new CondominioException("No existe un visitante con la cédula " + cedula.trim());
        }
        Visitante visitante = (Visitante) persona;
        Visita visita = visitaActiva(visitante);
        if(visita == null){
            throw new CondominioException(visitante.getNombre() + " no está dentro del condominio");
        }
        if(hora < visita.getHoraIngreso()){
            throw new CondominioException("La hora de salida no puede ser antes del ingreso (" + visita.getHoraIngreso() + ":00)");
        }
        visita.setHoraSalida(hora);
        visitante.salir();
    }

    // ==================== VEHICULOS ====================

    // Carro: ABC123. Moto: ABC12D
    public void registrarVehiculo(String placa, String tipo, String marca, String color, String codigoUnidad) throws CondominioException {
        if(!textoValido(placa) || !textoValido(marca) || !textoValido(color)){
            throw new CondominioException("Complete la placa, la marca y el color");
        }
        String placaMayus = placa.trim().toUpperCase();
        if("Carro".equals(tipo)){
            if(!placaMayus.matches("[A-Z]{3}[0-9]{3}")){
                throw new CondominioException("La placa de un carro debe ser 3 letras y 3 números (ej: ABC123)");
            }
        }
        else if("Moto".equals(tipo)){
            if(!placaMayus.matches("[A-Z]{3}[0-9]{2}[A-Z]")){
                throw new CondominioException("La placa de una moto debe ser 3 letras, 2 números y 1 letra (ej: ABC12D)");
            }
        }
        else{
            throw new CondominioException("El tipo de vehículo debe ser Carro o Moto");
        }
        if(buscarVehiculo(placaMayus) != null){
            throw new CondominioException("Ya existe un vehículo con la placa " + placaMayus);
        }
        Unidad unidad = unidadExistente(codigoUnidad);
        if(unidad.getVehiculos().size() >= Unidad.MAX_VEHICULOS){
            throw new CondominioException("La unidad " + unidad.getCodigo() + " ya tiene " + Unidad.MAX_VEHICULOS + " vehículos autorizados");
        }
        Vehiculo vehiculo = new Vehiculo(placaMayus, tipo, marca.trim(), color.trim(), unidad);
        unidad.agregarVehiculo(vehiculo);
        vehiculos.add(vehiculo);
    }

    public String consultarVehiculo(String placa) throws CondominioException {
        if(!textoValido(placa)){
            throw new CondominioException("Escriba la placa a consultar");
        }
        Vehiculo vehiculo = buscarVehiculo(placa.trim());
        if(vehiculo == null){
            return "La placa " + placa.trim().toUpperCase() + " NO está autorizada";
        }
        return "AUTORIZADO: " + vehiculo.toString();
    }

    // ==================== PAGOS DE ADMINISTRACION ====================

    public double totalPagado(Unidad unidad, int mes, int anio){
        double total = 0;
        for(Pago p : pagos){
            if(p.esDelPeriodo(unidad, mes, anio)){
                total += p.getValor();
            }
        }
        return total;
    }

    private void validarPeriodo(int mes, int anio) throws CondominioException {
        if(mes < 1 || mes > 12){
            throw new CondominioException("El mes debe estar entre 1 y 12");
        }
        if(anio < 2000 || anio > 2100){
            throw new CondominioException("El año debe estar entre 2000 y 2100");
        }
    }

    // Se permiten abonos, pero no pagar mas de lo que se debe en el mes
    public void registrarPago(String codigoUnidad, int mes, int anio, double valor) throws CondominioException {
        Unidad unidad = unidadExistente(codigoUnidad);
        validarPeriodo(mes, anio);
        if(Double.isNaN(valor) || Double.isInfinite(valor) || valor <= 0){
            throw new CondominioException("El valor del pago debe ser mayor que 0");
        }
        double saldo = unidad.calcularCuota() - totalPagado(unidad, mes, anio);
        if(saldo <= 0){
            throw new CondominioException("La unidad " + unidad.getCodigo() + " ya pagó la cuota de " + mes + "/" + anio);
        }
        if(valor > saldo){
            throw new CondominioException("El valor supera el saldo pendiente de $" + (long) saldo);
        }
        pagos.add(new Pago(consecutivoPago, unidad, mes, anio, valor));
        consecutivoPago++;
    }

    public String estadoPago(Unidad unidad, int mes, int anio){
        double pagado = totalPagado(unidad, mes, anio);
        if(pagado >= unidad.calcularCuota()){
            return "AL DIA";
        }
        if(pagado > 0){
            return "ABONO PARCIAL";
        }
        return "PENDIENTE";
    }

    public String consultarEstado(String codigoUnidad, int mes, int anio) throws CondominioException {
        Unidad unidad = unidadExistente(codigoUnidad);
        validarPeriodo(mes, anio);
        double cuota = unidad.calcularCuota();
        double pagado = totalPagado(unidad, mes, anio);
        String texto = "Estado de pagos - " + unidad.getTipo() + " " + unidad.getCodigo() + " [" + unidad.getCondominio().getNombre() + "]\n";
        texto += "Periodo: " + mes + "/" + anio + "\n";
        texto += "Cuota mensual: $" + (long) cuota + "\n";
        texto += "Pagado: $" + (long) pagado + "\n";
        texto += "Saldo pendiente: $" + (long) (cuota - pagado) + "\n";
        texto += "Estado: " + estadoPago(unidad, mes, anio) + "\n";
        texto += "\nHistorial de pagos de la unidad:\n";
        boolean hay = false;
        for(Pago p : pagos){
            if(p.getUnidad() == unidad){
                texto += "  " + p.toString() + "\n";
                hay = true;
            }
        }
        if(!hay){
            texto += "  Sin pagos registrados\n";
        }
        return texto;
    }

    public String listarMorosos(int mes, int anio) throws CondominioException {
        validarPeriodo(mes, anio);
        String texto = "Unidades que no están al día en " + mes + "/" + anio + ":\n";
        int cantidad = 0;
        for(Condominio c : condominios){
            for(Unidad u : c.getUnidades()){
                if(!estadoPago(u, mes, anio).equals("AL DIA")){
                    double saldo = u.calcularCuota() - totalPagado(u, mes, anio);
                    texto += "  " + u.getCodigo() + " [" + c.getNombre() + "] - " + estadoPago(u, mes, anio) + " - Debe $" + (long) saldo + "\n";
                    cantidad++;
                }
            }
        }
        if(cantidad == 0){
            texto += "  Todas las unidades están al día\n";
        }
        return texto;
    }

    // ==================== RESERVAS DE ZONAS COMUNES ====================

    public int registrarReserva(String codigoUnidad, String nombreZona, String fecha, int horaInicio, int horaFin, int numeroPersonas) throws CondominioException {
        Unidad unidad = unidadExistente(codigoUnidad);
        ZonaComun zona = unidad.getCondominio().buscarZona(nombreZona);
        if(zona == null){
            throw new CondominioException("La zona " + nombreZona + " no existe en el condominio");
        }
        if(!fechaValida(fecha)){
            throw new CondominioException("La fecha debe tener el formato dd/mm/aaaa y ser una fecha real");
        }
        if(horaInicio >= horaFin){
            throw new CondominioException("La hora de inicio debe ser menor que la hora de fin");
        }
        if(!zona.estaEnHorario(horaInicio, horaFin)){
            throw new CondominioException(zona.getNombre() + " solo se puede reservar de " + zona.getHoraApertura() + ":00 a " + zona.getHoraCierre() + ":00");
        }
        if(numeroPersonas < 1 || numeroPersonas > zona.getCapacidad()){
            throw new CondominioException("El número de personas debe estar entre 1 y " + zona.getCapacidad() + " para " + zona.getNombre());
        }
        String fechaLimpia = fecha.trim();
        for(Reserva r : reservas){
            if(r.seCruzaCon(zona, fechaLimpia, horaInicio, horaFin)){
                throw new CondominioException("Se cruza con la reserva #" + r.getNumero() + " (" + r.getHoraInicio() + ":00 a " + r.getHoraFin() + ":00)");
            }
        }
        int numero = consecutivoReserva;
        reservas.add(new Reserva(numero, zona, unidad, fechaLimpia, horaInicio, horaFin, numeroPersonas));
        consecutivoReserva++;
        return numero;
    }

    public void cancelarReserva(int numero) throws CondominioException {
        Reserva reserva = buscarReserva(numero);
        if(reserva == null){
            throw new CondominioException("No existe la reserva #" + numero);
        }
        reservas.remove(reserva);
    }

    // ==================== PAQUETES Y CORRESPONDENCIA ====================

    public int registrarPaquete(String codigoUnidad, String remitente, String descripcion) throws CondominioException {
        if(!textoValido(remitente) || !textoValido(descripcion)){
            throw new CondominioException("Complete el remitente y la descripción del paquete");
        }
        Unidad unidad = unidadExistente(codigoUnidad);
        int numero = consecutivoPaquete;
        paquetes.add(new Paquete(numero, unidad, remitente.trim(), descripcion.trim()));
        consecutivoPaquete++;
        return numero;
    }

    // Solo lo puede recibir el propietario o un residente de la unidad
    public void entregarPaquete(int numero, String cedulaRecibe) throws CondominioException {
        Paquete paquete = buscarPaquete(numero);
        if(paquete == null){
            throw new CondominioException("No existe el paquete #" + numero);
        }
        if(paquete.isEntregado()){
            throw new CondominioException("El paquete #" + numero + " ya fue entregado");
        }
        if(!textoValido(cedulaRecibe)){
            throw new CondominioException("Escriba la cédula de quien recibe");
        }
        Persona persona = buscarPersona(cedulaRecibe.trim());
        if(persona == null){
            throw new CondominioException("No existe una persona con la cédula " + cedulaRecibe.trim());
        }
        Unidad unidad = paquete.getUnidad();
        boolean esPropietario = unidad.getPropietario() == persona;
        boolean esResidente = unidad.getResidentes().contains(persona);
        if(!esPropietario && !esResidente){
            throw new CondominioException(persona.getNombre() + " no es propietario ni residente de la unidad " + unidad.getCodigo());
        }
        paquete.entregar(persona);
    }

    // ==================== LISTADOS Y REPORTES ====================

    public String listarCondominios(){
        if(condominios.isEmpty()){
            return "No hay condominios registrados";
        }
        String texto = "";
        for(Condominio c : condominios){
            texto += c.toString() + "\n";
        }
        return texto;
    }

    public String listarPersonas(){
        if(personas.isEmpty()){
            return "No hay personas registradas";
        }
        String texto = "Personas registradas:\n";
        for(Persona p : personas){
            texto += "  " + p.toString() + "\n";
        }
        return texto;
    }

    public String listarVisitantesDentro(){
        String texto = "Visitantes dentro en este momento:\n";
        int cantidad = 0;
        for(Visita v : visitas){
            if(v.estaActiva()){
                texto += "  " + v.toString() + "\n";
                cantidad++;
            }
        }
        if(cantidad == 0){
            texto += "  Ninguno\n";
        }
        return texto;
    }

    public String listarHistorialVisitas(){
        if(visitas.isEmpty()){
            return "No hay visitas registradas";
        }
        String texto = "Historial de visitas:\n";
        for(Visita v : visitas){
            texto += "  " + v.toString() + "\n";
        }
        return texto;
    }

    public String listarVehiculos(){
        if(vehiculos.isEmpty()){
            return "No hay vehículos autorizados";
        }
        String texto = "Vehículos autorizados:\n";
        for(Vehiculo v : vehiculos){
            texto += "  " + v.toString() + "\n";
        }
        return texto;
    }

    public String listarReservas(){
        if(reservas.isEmpty()){
            return "No hay reservas registradas";
        }
        String texto = "Reservas:\n";
        for(Reserva r : reservas){
            texto += "  " + r.toString() + "\n";
        }
        return texto;
    }

    public String listarPaquetesPendientes(){
        String texto = "Paquetes pendientes por entregar:\n";
        int cantidad = 0;
        for(Paquete p : paquetes){
            if(!p.isEntregado()){
                texto += "  " + p.toString() + "\n";
                cantidad++;
            }
        }
        if(cantidad == 0){
            texto += "  Ninguno\n";
        }
        return texto;
    }

    public String reporteGeneral(){
        int unidades = 0;
        for(Condominio c : condominios){
            unidades += c.getUnidades().size();
        }
        int propietarios = 0, residentes = 0, administradores = 0, vigilantes = 0, visitantes = 0;
        for(Persona p : personas){
            if(p instanceof Propietario){
                propietarios++;
            }
            else if(p instanceof Residente){
                residentes++;
            }
            else if(p instanceof Administrador){
                administradores++;
            }
            else if(p instanceof Vigilante){
                vigilantes++;
            }
            else if(p instanceof Visitante){
                visitantes++;
            }
        }
        int dentro = 0;
        for(Visita v : visitas){
            if(v.estaActiva()){
                dentro++;
            }
        }
        int pendientes = 0;
        for(Paquete p : paquetes){
            if(!p.isEntregado()){
                pendientes++;
            }
        }
        double recaudado = 0;
        for(Pago p : pagos){
            recaudado += p.getValor();
        }
        String texto = "===== REPORTE GENERAL CONDOMINIUS =====\n";
        texto += "Condominios: " + condominios.size() + "\n";
        texto += "Unidades: " + unidades + "\n";
        texto += "Propietarios: " + propietarios + " - Residentes: " + residentes + "\n";
        texto += "Administradores: " + administradores + " - Vigilantes: " + vigilantes + "\n";
        texto += "Visitantes registrados: " + visitantes + " - Dentro ahora: " + dentro + "\n";
        texto += "Vehículos autorizados: " + vehiculos.size() + "\n";
        texto += "Pagos registrados: " + pagos.size() + " - Total recaudado: $" + (long) recaudado + "\n";
        texto += "Reservas: " + reservas.size() + "\n";
        texto += "Paquetes: " + paquetes.size() + " - Pendientes: " + pendientes + "\n";
        return texto;
    }

    // ==================== GET ====================

    public ArrayList<Condominio> getCondominios(){
        return this.condominios;
    }

    public ArrayList<Persona> getPersonas(){
        return this.personas;
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return this.vehiculos;
    }

    public ArrayList<Pago> getPagos(){
        return this.pagos;
    }

    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }

    public ArrayList<Visita> getVisitas(){
        return this.visitas;
    }

    public ArrayList<Paquete> getPaquetes(){
        return this.paquetes;
    }
}//End class
