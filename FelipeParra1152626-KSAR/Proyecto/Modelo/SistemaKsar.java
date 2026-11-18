package Proyecto.Modelo;
import java.util.ArrayList;

/**
 * Contenedora del sistema K-SAR.
 * Andrés: registrarGuia, registrarPerro, armarBinomio (RF1),
 * actualizarCertificacionGuia/Perro (RF4), filtrarPorEquipo y listarMisiones (RF5).
 * La contenedora llama a los métodos de cada clase; no contiene su lógica.
 */
public class SistemaKsar
{
    private ArrayList<Equipo> equipos;
    private ArrayList<Guia> guias;
    private ArrayList<Perro> perros;
    private ArrayList<Binomio> binomios;
    private ArrayList<Evento> eventos;
    private ArrayList<Mision> misiones;
    private ArrayList<Pais> paises;

    private int consecutivoPerro;
    private int consecutivoMision;

    public SistemaKsar() {
        this.equipos = new ArrayList<>();
        this.guias = new ArrayList<>();
        this.perros = new ArrayList<>();
        this.binomios = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.misiones = new ArrayList<>();
        this.paises = new ArrayList<>();
        this.consecutivoPerro = 0;
        this.consecutivoMision = 0;
    }
    
    
    // GETTERS PARA LA VISTA 
       public ArrayList<Equipo> getEquipos(){
        return equipos;
    }
    
    public ArrayList<Guia> getGuias(){
        return guias;
    }
    
    public ArrayList<Perro> getPerros(){
        return perros;
    }
    
    public ArrayList<Binomio> getBinomios(){
        return binomios;
    }
    
    public ArrayList<Evento> getEventos(){
        return eventos;
    }
    
    public ArrayList<Mision> getMisiones(){
        return misiones;
    }
    
    public ArrayList<Pais> getPaises(){
        return paises;
    }
    
    public ArrayList<Mision> listarMisiones() {
       return misiones;
   }
    
    // MUNICIPIOS REGISTRADOS DE LOS PAISES
    public ArrayList<Municipio> getMunicipios(){
        ArrayList<Municipio> todos = new ArrayList<>();
        for(Pais p : paises){
            todos.addAll(p.getMunicipios());
        }
        return todos;
    }
    
 
    // METODOS AUXILIARES
    
    // BUSQUEDAS
    public Guia buscarGuia(String cedula) {
        for (Guia g : guias) {
            if (g.getCedula().equals(cedula)) return g;
        }
        return null;
    }

    public Perro buscarPerro(String codigo) {
        for (Perro p : perros) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    public Equipo buscarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) return e;
        }
        return null;
    }
    
     public Mision buscarMision(String codigo){
        for(Mision m:misiones){
            if(m.getCodigo().equalsIgnoreCase(codigo)){
                return m;
            }
        }
        return null;
    }
    
    public Pais buscarPais(String codigo){
        for(Pais p:paises){
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                return p;
            }
        }
        return null;
    }
    
    public Pais buscarPaisPorNombre(String nombre){
        for(Pais p:paises){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }
    
     public Lugar buscarLugar(String codigoPais, String nombreMunicipio, String nombreLugar){
        Pais pais = buscarPais(codigoPais);
        if(pais == null){
            return null;
        }
        Municipio municipio = pais.buscarMunicipio(nombreMunicipio);
        if(municipio == null){
            return null;
        }
        return municipio.buscarLugar(nombreLugar);
    }
    
    // CONSECUTIVOS
    private String generarCodigoPerro() {
        consecutivoPerro++;
        return String.format("CAN-%03d", consecutivoPerro);
    }
    
    public String siguienteCodigoPerro(){
        return String.format("CAN-%03d", consecutivoPerro + 1);
    }
    
    private String generarCodigoMision(){
        consecutivoMision++;
        return String.format("DES-%03d", consecutivoMision);
    }
    
     public String siguienteCodigoMision(){
        return String.format("DES-%03d", consecutivoMision + 1);
    }

    // ==================== REGISTROS RF1 (Andrés) ====================

    // REGISTRO GUIA 
    public String registrarGuia(String cedula, String nombre, Certificacion cert) {
        if (cedula == null || !cedula.matches("\\d+")) {
            return "La cédula debe tener solo números.";
        }
        if (buscarGuia(cedula) != null) {
            return "Ya existe un guía con esa cédula.";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }
        guias.add(new Guia(cedula, nombre.trim(), cert));
        return "Guía registrado correctamente.";
    }

    // REGISTRO PERRO
    public String registrarPerro(String nombre, String descripcion, String raza, int edad, Certificacion cert) {
        if (nombre == null || nombre.trim().isEmpty() || raza == null || raza.trim().isEmpty()) {
            return "Nombre y raza son obligatorios.";
        }
        if (edad < 0) {
            return "La edad debe ser mayor o igual a 0.";
        }
        String codigo = generarCodigoPerro();
        perros.add(new Perro(codigo, nombre.trim(), descripcion, raza.trim(), edad, cert));
        return "Perro registrado. Código: " + codigo;
    }

    // ARMA BINOMIO
    public String armarBinomio(String cedulaGuia, String codigoPerro, String nombreEquipo) {
        Guia guia = buscarGuia(cedulaGuia);
        Perro perro = buscarPerro(codigoPerro);
        Equipo equipo = buscarEquipo(nombreEquipo);
        if (guia == null){
          return "El guía no existe.";  
        }
        
        if (perro == null){
         return "El perro no existe.";
        }
        
        if (equipo == null) {
          return "El equipo no existe.";   
        }
        
        if (guia.getBinomio() != null) {
          return "Ese guía ya tiene binomio.";   
        }
        
        if (perro.getBinomio() != null) {
          return "Ese perro ya tiene binomio.";
        }

        boolean disponible = guia.estaVigente() && perro.estaVigente();
        Binomio b = new Binomio(disponible, 0, guia, perro);
        b.setEquipo(equipo);
        b.actualizarEstado();
        guia.setBinomio(b);
        perro.setBinomio(b);
        equipo.getBinomios().add(b);
        binomios.add(b);
        return disponible ? "Binomio armado y disponible." : "Binomio armado (certificación no vigente).";
    }
    
    // REGISTRO UBICACION DE EVENTO 
    
     public String registrarUbicacion(String nombrePais, String codigoPais, String nombreMunicipio,
                                     String nombreLugar, String calle, String numero, String barrio) {
        if (esVacio(nombrePais) || esVacio(codigoPais) || esVacio(nombreMunicipio) || esVacio(nombreLugar)) {
            return "País, código, municipio y lugar son obligatorios.";
        }
        String codigo = codigoPais.trim().toUpperCase();
        Pais pais = buscarPais(codigo);
        if (pais == null) {
            if (buscarPaisPorNombre(nombrePais.trim()) != null) {
                return "Ya existe un país con ese nombre y con otro código.";
            }
            pais = new Pais(nombrePais.trim(), codigo);
            paises.add(pais);
        } else if (!pais.getNombre().equalsIgnoreCase(nombrePais.trim())) {
            return "El código " + codigo + " ya pertenece a " + pais.getNombre() + ".";
        }
        
          Municipio municipio = pais.buscarMunicipio(nombreMunicipio.trim());
        if (municipio == null) {
            municipio = new Municipio(nombreMunicipio.trim(), pais);
            pais.agregarMunicipio(municipio);
        }

        if (municipio.buscarLugar(nombreLugar.trim()) != null) {
            return "La ubicación ya estaba registrada.";
        }
        Lugar lugar = new Lugar(nombreLugar.trim(), calle == null ? "" : calle.trim(), "",
                                numero == null ? "" : numero.trim(), barrio == null ? "" : barrio.trim(), municipio);
        municipio.agregarLugar(lugar);
        return "Ubicación registrada correctamente.";
    }

    private boolean esVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

        
    // REGISTRO EQUIPO
    
     public String registrarEquipo(String nombre, Fecha fechaCreacion) {
        if (esVacio(nombre)) {
            return "El nombre del equipo es obligatorio.";
        }
        if (buscarEquipo(nombre.trim()) != null) {
            return "Ya existe un equipo con ese nombre.";
        }
        if (fechaCreacion == null || !fechaCreacion.esValida()) {
            return "La fecha de creación no es válida.";
        }
        equipos.add(new Equipo(nombre.trim(), fechaCreacion));
        return "Equipo registrado correctamente.";
    }
    
    
    // REGISTRO EVENTO (TERREMOTO)
    public String registrarTerremoto(Fecha fecha, double magnitud, String epicentro, Lugar lugar) {
        if (lugar == null) {
            return "Debe indicar la ubicación del evento.";
        }
        if (magnitud < 0 || Math.abs(magnitud * 10 - Math.round(magnitud * 10)) > 1e-9) {
            return "La magnitud debe ser mayor o igual a 0 y con un decimal.";
        }
        Terremoto t = new Terremoto("Terremoto", fecha, lugar, magnitud, epicentro == null ? "" : epicentro.trim());
        if (!t.validarFecha()) {
            return "La fecha del evento no es válida o es posterior a la fecha actual.";
        }
        eventos.add(t);
        lugar.agregarEvento(t);
        return "Terremoto registrado correctamente.";
    }
    
    
    // REGISTRO EVENTO (DESLAVE)
    public String registrarDeslave(Fecha fecha, int volumenDesplazado, String zonaAfectada, Lugar lugar) {
        if (lugar == null) {
            return "Debe indicar la ubicación del evento.";
        }
        if (volumenDesplazado < 0) {
            return "El volumen desplazado debe ser mayor o igual a 0.";
        }
        Deslave d = new Deslave("Deslave", fecha, lugar, volumenDesplazado, zonaAfectada == null ? "" : zonaAfectada.trim());
        if (!d.validarFecha()) {
            return "La fecha del evento no es válida o es posterior a la fecha actual.";
        }
        eventos.add(d);
        lugar.agregarEvento(d);
        return "Deslave registrado correctamente.";
    }
    
     // REGISTRO MISION
       public String registrarMision(Fecha fecha, Evento evento, Binomio binomio, double horasLabor, int sobrevivientes, int fallecidos) {
    if (evento == null) {
        return "Debe seleccionar un evento.";
    }
    if (binomio == null) {
        return "Debe seleccionar un binomio.";
    }
    if (evento.tieneMision()) {
        return "Ese evento ya tiene una misión registrada.";
    }
    if (!binomio.verificarCertificacion()) {
        return "No se puede registrar la misión: el guía y el perro deben tener la certificación vigente.";
    }

    Mision m = new Mision("", fecha, binomio.getEquipo(), binomio, evento,
                          horasLabor, sobrevivientes, fallecidos);

    if (!m.validarFecha()) {
        return "La fecha de la misión no es válida o es posterior a la fecha actual.";
    }
    if (!m.validarDatos()) {
        return "Las horas, los sobrevivientes y los fallecidos deben ser mayores o iguales a 0.";
    }

    m.setCodigo(generarCodigoMision());
    evento.setMision(m);
    binomio.getMisiones().add(m);
    binomio.incrementarMisiones();
    misiones.add(m);
    return "Misión registrada. Código: " + m.getCodigo();
   }
    
    
    // ==================== CONSULTAS RF2, RF3 (Camilo) ====================
    
    // LISTAR GUIAS Y PERROS CON SU CERTIFICACIÓN 
    
    public String listarGuiasYPerros(){
        StringBuilder listado=new StringBuilder();
        listado.append("------LISTADO DE GUIAS-----\n");
        if(guias.isEmpty()){
            listado.append("no hay guias registrados\n");
        }else{
            for(Guia g:guias){
                listado.append("Cedula: ").append(g.getCedula()).append("\n Nombre: ").append(g.getNombreCompleto()).append("\n Certificacion: ").append(g.getCertificacion()).append("\n\n");
            }
        }
        
        listado.append("\n-----LISTADO DE PERROS-----\n");
        if(perros.isEmpty()){
            listado.append("No hay perros registrados\n");
        }else{
            for(Perro p:perros){
                listado.append("Codigo: ").append(p.getCodigo()).append("\n Nombre: ").append(p.getNombre()).append("\n Certificacion: ").append(p.getCertificacion()).append("\n\n");
            }
        }
        return listado.toString();
    }
    
    public String listarPerrosDelGuia(String cedulaGuia){
        Guia guia=buscarGuia(cedulaGuia);
        if(guia==null){
            return "No se encontro, el Guia con cedula "+cedulaGuia+" no existe";
        }
        StringBuilder listado=new StringBuilder();
        listado.append("Perros asociados al guia ").append(guia.getNombreCompleto()).append(":\n");
        boolean tienePerros=false;
        for(Binomio b:binomios){
            if(b.getGuia().getCedula().equals(cedulaGuia)){
                Perro p=b.getPerro();
                listado.append("*Codigo: ").append(p.getCodigo()).append("\nNombre: ").append(p.getNombre())
                       .append("\nCertificacion: ").append(p.getCertificacion()).append("\n");
                tienePerros=true;
            }
        }
        if(!tienePerros){
            return "El guia "+guia.getNombreCompleto()+" está pero no tiene perros en ningun binomio";
        }
        return listado.toString();
    }
    
    // ==================== CONSULTAR RF3 (Camilo) ====================
    
    public String consultarPerro(String codigo){
        Perro p = buscarPerro(codigo == null ? "" : codigo.trim());
        if(p == null){
            return "No se encontró ningún perro con el código "+codigo+".";
        }
        return p.toString();
    }
    
    public String consultarGuia(String cedula){
        Guia g = buscarGuia(cedula == null ? "" : cedula.trim());
        if(g == null){
            return "No se encontró ningún guía con la cédula "+cedula+".";
        }
        return g.toString();
    }
    
    public String consultarMision(String codigo){
        Mision m = buscarMision(codigo == null ? "" : codigo.trim());
        if(m == null){
            return "No se encontró ninguna misión con el código "+codigo+".";
        }
        return m.toString();
    }
     
    
    // ==================== ACTUALIZACIÓN RF4 (Andrés) ====================

    // ACTUALIZACIONES  CERFICADOS GUIA Y PERRO
    public String actualizarCertificacionGuia(String cedula, Certificacion nueva) {
        Guia g = buscarGuia(cedula);
        if (g == null) return "No se encontró el guía.";
        g.cambiarCertificacion(nueva);
        return "Certificación del guía actualizada.";
    }

    
    public String actualizarCertificacionPerro(String codigo, Certificacion nueva) {
        Perro p = buscarPerro(codigo);
        if (p == null) return "No se encontró el perro.";
        p.cambiarCertificacion(nueva);
        return "Certificación del perro actualizada.";
    }

    public ArrayList<Mision> filtrarPorEquipo(String nombreEquipo) {
        ArrayList<Mision> resultado = new ArrayList<>();
        Equipo eq = buscarEquipo(nombreEquipo);
        if (eq == null) return resultado;
        for (Binomio b : eq.getBinomios()) {
            if (b.getMisiones() != null) {
                resultado.addAll(b.getMisiones());
            }
        }
        return resultado;
    }

    public ArrayList<Mision> filtrarPorMunicipio(String nombreMunicipio) {
        ArrayList<Mision> resultado = new ArrayList<>();
        for (Mision m : misiones) {
            Evento ev = m.getEvento();
            if (ev != null && ev.getLugar() != null && ev.getLugar().getMunicipio() != null
                    && ev.getLugar().getMunicipio().getNombre().equalsIgnoreCase(nombreMunicipio)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    // // ==================== FILTRAR POR EQUIPO Y/O MUNICIPIO RF5 ====================
    public ArrayList<Mision> filtrarMisiones(String nombreEquipo, String nombreMunicipio) {
        ArrayList<Mision> resultado = new ArrayList<>();
        for (Mision m : misiones) {
            boolean okEquipo = esVacio(nombreEquipo) || m.esDeEquipo(nombreEquipo.trim());
            boolean okMunicipio = esVacio(nombreMunicipio) || m.esDeMunicipio(nombreMunicipio.trim());
            if (okEquipo && okMunicipio) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    
    public ArrayList<String> listarNombresMunicipios() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Municipio m : getMunicipios()) {
            if (!nombres.contains(m.getNombre())) {
                nombres.add(m.getNombre());
            }
        }
        return nombres;
    }
    
    // ====================DESEMPEÑO DEL CONJUNTO DE TODAS LAS MISIONES RF6============
    public String calcularDesempenoConjunto() {
        if (misiones.isEmpty()) {
            return "No hay misiones registradas.";
        }
        int suma = 0;
        for (Mision m : misiones) {
            suma += m.calcularDesempeno();
        }
        double promedio = suma / (double) misiones.size();
        return "Desempeño del conjunto:\nMisiones: " + misiones.size()
             + "\nSuma: " + suma
             + "\nPromedio: " + promedio;
    }
    
     //  ==================== BUSQUEDA DE MISIONES POR MAYOR DESEMPEÑO RF7 ====================

    public ArrayList<Mision> buscarMayorDesempeno() {
    ArrayList<Mision> ganadoras = new ArrayList<>();
    int mayor = 0;

    // hallar el mayor desempeño
    for (Mision m : misiones) {
        int desempeno = m.calcularDesempeno();
        if (desempeno > mayor) {
            mayor = desempeno;
        }
    }

    // agrega todas las misiones que tengan ese desempeño
    for (Mision m : misiones) {
        if (m.calcularDesempeno() == mayor) {
            ganadoras.add(m);
        }
    }
    return ganadoras;
   }
   
    //  ==================== CONSULTAR BINOMIOS DISPONIBLES  RF8 ====================
     
    public String listarBinomiosDisponibles() {
    String r = "";
    int cantidad = 0;
    for (Binomio b : binomios) {
        if (b.estaDisponible()) {
            r += b.enlistar();
            cantidad++;
        }
    }
    
    if (cantidad == 0) {
        return "No hay binomios disponibles en este momento.";
    }
    return "Binomios disponibles: " + cantidad + "\n\n" + r;
   }  
   
   // ================= HISTORIAL DE MISIONES ORDENADO POR FECHA  RF9====================00
    public ArrayList<Mision> ordenarPorFecha(ArrayList<Mision> misiones) {
        ArrayList<Mision> ordenadas = new ArrayList<>();
        if (misiones == null) {
            return ordenadas;
        }
        for (int i = 0; i < misiones.size(); i++) {
            ordenadas.add(misiones.get(i));
        }
        for (int i = 0; i < ordenadas.size() - 1; i++) {
            for (int j = i + 1; j < ordenadas.size(); j++) {
                Mision m1 = ordenadas.get(i);
                Mision m2 = ordenadas.get(j);
                if (m1.getFecha() != null && m2.getFecha() != null
                        && m1.getFecha().compararCon(m2.getFecha()) > 0) {
                    ordenadas.set(i, m2);
                    ordenadas.set(j, m1);
                }
            }
        }
        return ordenadas;
    }
    // BUSQUEDAS PARA LA VENTANA PRINCIPAL

    
    public ArrayList<Mision> buscarMisionesPorCodigo(String texto) {
        ArrayList<Mision> resultado = new ArrayList<>();
        String t = texto == null ? "" : texto.trim().toLowerCase();
        for (Mision m : misiones) {
            if (m.getCodigo().toLowerCase().contains(t)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    
    public ArrayList<Binomio> buscarBinomiosPorPerro(String texto) {
        ArrayList<Binomio> resultado = new ArrayList<>();
        String t = texto == null ? "" : texto.trim().toLowerCase();
        for (Binomio b : binomios) {
            Perro p = b.getPerro();
            if (p != null && (p.getCodigo().toLowerCase().contains(t)
                    || p.getNombre().toLowerCase().contains(t))) {
                resultado.add(b);
            }
        }
        return resultado;
    }


    public ArrayList<Binomio> buscarBinomiosPorGuia(String texto) {
        ArrayList<Binomio> resultado = new ArrayList<>();
        String t = texto == null ? "" : texto.trim().toLowerCase();
        for (Binomio b : binomios) {
            Guia g = b.getGuia();
            if (g != null && (g.getCedula().toLowerCase().contains(t)
                    || g.getNombreCompleto().toLowerCase().contains(t))) {
                resultado.add(b);
            }
        }
        return resultado;
    }

    // Junta las misiones de una lista de binomios
    public ArrayList<Mision> misionesDeBinomios(ArrayList<Binomio> lista) {
        ArrayList<Mision> resultado = new ArrayList<>();
        if (lista == null) {
            return resultado;
        }
        for (Binomio b : lista) {
            if (b.getMisiones() != null) {
                resultado.addAll(b.getMisiones());
            }
        }
        return resultado;
    }

    public int contarBinomiosDisponibles() {
        int n = 0;
        for (Binomio b : binomios) {
            if (b.estaDisponible()) n++;
        }
        return n;
    }

    

}
