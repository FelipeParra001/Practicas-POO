package modelo;
import java.util.ArrayList;

public class Vecindad
{
    private ArrayList<Personaje> personajes;
    private ArrayList<Lugar> lugares;
    private Jugador jugador;

    public Vecindad(){
        personajes = new ArrayList<>();
        lugares = new ArrayList<>();
        cargarDatos();
    }

    // ==================== DATOS INICIALES ====================

    private void cargarDatos(){
        agregarPersonaje(new Chavo());
        agregarPersonaje(new Quico());
        agregarPersonaje(new Chilindrina());
        agregarPersonaje(new DonRamon());
        agregarPersonaje(new DonaFlorinda());
        agregarPersonaje(new SenorBarriga());

        relacionar("El Chavo", "Quico", "Amistad");
        relacionar("El Chavo", "La Chilindrina", "Amistad");
        relacionar("Don Ramón", "Doña Florinda", "Rivalidad");
        relacionar("Quico", "La Chilindrina", "Rivalidad");

        Lugar patio = new Lugar("Patio", "El centro de la vecindad, donde todos juegan");
        patio.agregarObjeto(new ObjetoInteractivo("Barril del Chavo", "El barril donde se esconde el Chavo",
            "Te asomas al barril y encuentras al Chavo comiendo una torta de jamón"));
        patio.agregarObjeto(new ObjetoInteractivo("Pelota de Quico", "La pelota nueva de Quico",
            "Pateas la pelota y Quico empieza a llorar"));

        Lugar entrada = new Lugar("Entrada", "La entrada de la vecindad");
        entrada.agregarObjeto(new ObjetoInteractivo("Casa del Señor Barriga", "La casa del dueño de la vecindad",
            "Tocas la puerta y el Señor Barriga sale a cobrar la renta"));

        Lugar casaFlorinda = new Lugar("Casa de Doña Florinda", "La casa más arreglada de la vecindad");
        casaFlorinda.agregarObjeto(new ObjetoInteractivo("Tacita de café", "Café recién hecho",
            "Doña Florinda te invita una tacita de café"));

        Lugar casaRamon = new Lugar("Casa de Don Ramón", "La casa número 72");
        casaRamon.agregarObjeto(new ObjetoInteractivo("Guitarra", "La guitarra de Don Ramón",
            "Tocas la guitarra y Don Ramón se pone a cantar"));

        lugares.add(patio);
        lugares.add(entrada);
        lugares.add(casaFlorinda);
        lugares.add(casaRamon);

        jugador = new Jugador("Jugador 1", patio);
    }

    // ==================== PERSONAJES (RF1) ====================

    public boolean agregarPersonaje(Personaje p){
        if(p == null || buscarPersonaje(p.getNombre()) != null){
            return false;
        }
        personajes.add(p);
        return true;
    }

    // Registra un personaje nuevo validando sus datos
    public boolean registrarVecino(String nombre, int edad, String personalidad, String rol){
        if(nombre == null || nombre.trim().isEmpty() || edad < 0 || edad > 120){
            return false;
        }
        return agregarPersonaje(new Vecino(nombre.trim(), edad, personalidad, rol));
    }

    public Personaje buscarPersonaje(String nombre){
        if(nombre == null){
            return null;
        }
        for(Personaje p : personajes){
            if(p.getNombre().equalsIgnoreCase(nombre.trim())){
                return p;
            }
        }
        return null;
    }

    public String listarPersonajes(){
        if(personajes.isEmpty()){
            return "No hay personajes";
        }
        String texto = "";
        for(Personaje p : personajes){
            texto += p.toString() + "\n";
            texto += "   Relaciones: " + p.describirRelaciones() + "\n";
        }
        return texto;
    }

    public ArrayList<String> getNombresPersonajes(){
        ArrayList<String> nombres = new ArrayList<>();
        for(Personaje p : personajes){
            nombres.add(p.getNombre());
        }
        return nombres;
    }

    // ==================== RELACIONES ====================

    public boolean relacionar(String nombre1, String nombre2, String tipo){
        Personaje p1 = buscarPersonaje(nombre1);
        Personaje p2 = buscarPersonaje(nombre2);
        if(p1 == null || p2 == null || p1 == p2){
            return false;
        }
        p1.agregarRelacion(p2, tipo);
        p2.agregarRelacion(p1, tipo);
        return true;
    }

    // ==================== INTERACCION ENTRE PERSONAJES (RF2) ====================

    public String simularInteraccion(String nombre1, String nombre2){
        Personaje p1 = buscarPersonaje(nombre1);
        Personaje p2 = buscarPersonaje(nombre2);
        if(p1 == null || p2 == null){
            return "Alguno de los personajes no existe";
        }
        if(p1 == p2){
            return "Un personaje no puede interactuar consigo mismo";
        }
        String texto = p1.getNombre() + " " + p1.accionCon(p2) + "\n";
        texto += p1.getNombre() + " dice: " + p1.decirDialogo() + "\n";
        texto += p2.getNombre() + " responde: " + p2.decirDialogo() + "\n";
        texto += "Relación entre ellos: " + p1.tipoRelacionCon(p2);
        return texto;
    }

    // ==================== JUGADOR Y OBJETOS (RF3) ====================

    public Lugar buscarLugar(String nombre){
        if(nombre == null){
            return null;
        }
        for(Lugar l : lugares){
            if(l.getNombre().equalsIgnoreCase(nombre.trim())){
                return l;
            }
        }
        return null;
    }

    public String moverJugador(String nombreLugar){
        Lugar lugar = buscarLugar(nombreLugar);
        if(lugar == null){
            return "Ese lugar no existe en la vecindad";
        }
        if(lugar == jugador.getUbicacion()){
            return "Ya estás en " + lugar.getNombre();
        }
        jugador.moverA(lugar);
        String texto = jugador.getNombre() + " se movió a " + lugar.getNombre() + "\n";
        texto += lugar.getDescripcion() + "\n";
        texto += "Objetos: ";
        for(ObjetoInteractivo o : lugar.getObjetos()){
            texto += o.getNombre() + "; ";
        }
        return texto;
    }

    public String interactuarConObjeto(String nombreObjeto){
        Lugar lugar = jugador.getUbicacion();
        ObjetoInteractivo objeto = lugar.buscarObjeto(nombreObjeto);
        if(objeto == null){
            return "Ese objeto no está en " + lugar.getNombre();
        }
        return objeto.usar();
    }

    public String getNombreUbicacion(){
        return jugador.getUbicacion().getNombre();
    }

    public ArrayList<String> getNombresLugares(){
        ArrayList<String> nombres = new ArrayList<>();
        for(Lugar l : lugares){
            nombres.add(l.getNombre());
        }
        return nombres;
    }

    public ArrayList<String> getNombresObjetosUbicacion(){
        ArrayList<String> nombres = new ArrayList<>();
        for(ObjetoInteractivo o : jugador.getUbicacion().getObjetos()){
            nombres.add(o.getNombre());
        }
        return nombres;
    }

    // ==================== GET ====================

    public ArrayList<Personaje> getPersonajes(){
        return this.personajes;
    }

    public ArrayList<Lugar> getLugares(){
        return this.lugares;
    }

    public Jugador getJugador(){
        return this.jugador;
    }
}//End class
