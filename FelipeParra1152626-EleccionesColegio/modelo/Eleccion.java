package modelo;
import java.util.ArrayList;

public class Eleccion
{
    private ArrayList<CandidatoPersonero> personeros;
    private ArrayList<CandidatoRepresentante> representantes;
    private int votosNulosPersonero;
    private int votosBlancoPersonero;
    private int votosNulosRepresentante;
    private int votosBlancoRepresentante;

    public Eleccion(){
        personeros = new ArrayList<>();
        representantes = new ArrayList<>();
        votosNulosPersonero = 0;
        votosBlancoPersonero = 0;
        votosNulosRepresentante = 0;
        votosBlancoRepresentante = 0;
    }

    // ==================== VALIDACIONES ====================

    private boolean textoValido(String texto){
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean datosValidos(String nombre, String apellido, int grado, String grupo, String lema, int tarjeton){
        if(!textoValido(nombre) || !textoValido(apellido) || !textoValido(grupo) || !textoValido(lema)){
            return false;
        }
        if(grado < 1 || grado > 11){
            return false;
        }
        return tarjeton > 0;
    }

    // ==================== REGISTRO DE CANDIDATOS ====================

    // Crea la mascota segun el tipo de animal, devuelve null si los datos no sirven
    public Mascota crearMascota(String tipo, String identificacion, String nombre, String genero, int edad, String cualidades){
        if(!textoValido(identificacion) || !textoValido(nombre) || !textoValido(genero) || !textoValido(cualidades) || edad < 0){
            return null;
        }
        if(buscarMascota(identificacion) != null){
            return null;
        }
        if("Aereo".equals(tipo)){
            return new Aereo(identificacion, nombre, genero, edad, cualidades);
        }
        else if("Terrestre".equals(tipo)){
            return new Terrestre(identificacion, nombre, genero, edad, cualidades);
        }
        else if("Acuatico".equals(tipo)){
            return new Acuatico(identificacion, nombre, genero, edad, cualidades);
        }
        return null;
    }

    public boolean registrarPersonero(String nombre, String apellido, int grado, String grupo, String lema, int tarjeton, Mascota mascota){
        if(!datosValidos(nombre, apellido, grado, grupo, lema, tarjeton) || mascota == null){
            return false;
        }
        if(buscarPersonero(tarjeton) != null || buscarMascota(mascota.getIdentificacion()) != null){
            return false;
        }
        personeros.add(new CandidatoPersonero(nombre, apellido, grado, grupo, lema, tarjeton, mascota));
        return true;
    }

    public boolean registrarRepresentante(String nombre, String apellido, int grado, String grupo, String lema, int tarjeton, String nombreFormula, String apellidoFormula){
        if(!datosValidos(nombre, apellido, grado, grupo, lema, tarjeton)){
            return false;
        }
        if(!textoValido(nombreFormula) || !textoValido(apellidoFormula)){
            return false;
        }
        if(buscarRepresentante(tarjeton) != null){
            return false;
        }
        // La formula es un estudiante del mismo grado y grupo que acompaña al candidato
        Estudiante formula = new Estudiante(nombreFormula, apellidoFormula, grado, grupo);
        representantes.add(new CandidatoRepresentante(nombre, apellido, grado, grupo, lema, tarjeton, formula));
        return true;
    }

    // ==================== BUSQUEDAS ====================

    public CandidatoPersonero buscarPersonero(int tarjeton){
        for(CandidatoPersonero c : personeros){
            if(c.getNumeroTarjeton() == tarjeton){
                return c;
            }
        }
        return null;
    }

    public CandidatoRepresentante buscarRepresentante(int tarjeton){
        for(CandidatoRepresentante c : representantes){
            if(c.getNumeroTarjeton() == tarjeton){
                return c;
            }
        }
        return null;
    }

    public Mascota buscarMascota(String identificacion){
        for(CandidatoPersonero c : personeros){
            if(c.getMascota().getIdentificacion().equalsIgnoreCase(identificacion)){
                return c.getMascota();
            }
        }
        return null;
    }

    // ==================== VOTACION ====================

    public boolean votarPersonero(int tarjeton){
        CandidatoPersonero c = buscarPersonero(tarjeton);
        if(c == null){
            return false;
        }
        c.sumarVoto();
        return true;
    }

    public boolean votarRepresentante(int tarjeton){
        CandidatoRepresentante c = buscarRepresentante(tarjeton);
        if(c == null){
            return false;
        }
        c.sumarVoto();
        return true;
    }

    public void votarBlancoPersonero(){
        votosBlancoPersonero++;
    }

    public void votarNuloPersonero(){
        votosNulosPersonero++;
    }

    public void votarBlancoRepresentante(){
        votosBlancoRepresentante++;
    }

    public void votarNuloRepresentante(){
        votosNulosRepresentante++;
    }

    // ==================== TOTAL DE VOTOS POR CANDIDATO RF1 ====================

    public String totalVotosPorCandidato(){
        String texto = "--- Candidatos a personero ---\n";
        if(personeros.isEmpty()){
            texto += "No hay candidatos registrados\n";
        }
        for(CandidatoPersonero c : personeros){
            texto += "Tarjetón " + c.getNumeroTarjeton() + " " + c.getNombreCompleto() + ": " + c.getVotos() + " votos\n";
        }
        texto += "Votos en blanco: " + votosBlancoPersonero + "\n";
        texto += "Votos nulos: " + votosNulosPersonero + "\n";

        texto += "\n--- Candidatos a representante de grado ---\n";
        if(representantes.isEmpty()){
            texto += "No hay candidatos registrados\n";
        }
        for(CandidatoRepresentante c : representantes){
            texto += "Grado " + c.getGrado() + " - Tarjetón " + c.getNumeroTarjeton() + " " + c.getNombreCompleto() + ": " + c.getVotos() + " votos\n";
        }
        texto += "Votos en blanco: " + votosBlancoRepresentante + "\n";
        texto += "Votos nulos: " + votosNulosRepresentante + "\n";

        texto += "\n--- Representante elegido por grado ---\n";
        for(int grado = 1; grado <= 11; grado++){
            if(tieneCandidatosGrado(grado)){
                CandidatoRepresentante elegido = representanteElegido(grado);
                if(elegido == null){
                    texto += "Grado " + grado + ": sin ganador (sin votos o empate)\n";
                }else{
                    texto += "Grado " + grado + ": " + elegido.getNombreCompleto() + "\n";
                }
            }
        }
        return texto;
    }

    // ==================== PERSONERO ELEGIDO RF2 ====================

    // Devuelve null si no hay candidatos, no hay votos o hay empate
    public CandidatoPersonero personeroElegido(){
        if(personeros.isEmpty()){
            return null;
        }
        CandidatoPersonero mayor = personeros.get(0);
        for(CandidatoPersonero c : personeros){
            if(c.getVotos() > mayor.getVotos()){
                mayor = c;
            }
        }
        if(mayor.getVotos() == 0 || hayEmpatePersonero()){
            return null;
        }
        return mayor;
    }

    public boolean hayEmpatePersonero(){
        int mayor = 0;
        int cantidad = 0;
        for(CandidatoPersonero c : personeros){
            if(c.getVotos() > mayor){
                mayor = c.getVotos();
                cantidad = 1;
            }
            else if(c.getVotos() == mayor && mayor > 0){
                cantidad++;
            }
        }
        return cantidad > 1;
    }

    // ==================== MENOR VOTACION RF3 ====================

    // Si hay empate devuelve el primero registrado
    public CandidatoPersonero personeroMenorVotacion(){
        if(personeros.isEmpty()){
            return null;
        }
        CandidatoPersonero menor = personeros.get(0);
        for(CandidatoPersonero c : personeros){
            if(c.getVotos() < menor.getVotos()){
                menor = c;
            }
        }
        return menor;
    }

    public boolean hayEmpateMenorVotacion(){
        CandidatoPersonero menor = personeroMenorVotacion();
        if(menor == null){
            return false;
        }
        int cantidad = 0;
        for(CandidatoPersonero c : personeros){
            if(c.getVotos() == menor.getVotos()){
                cantidad++;
            }
        }
        return cantidad > 1;
    }

    // ==================== POBLACION ELECTORAL RF4 ====================

    // Votos de los candidatos a personero + votos nulos + votos en blanco
    public int poblacionElectoral(){
        int total = 0;
        for(CandidatoPersonero c : personeros){
            total += c.getVotos();
        }
        return total + votosNulosPersonero + votosBlancoPersonero;
    }

    public int poblacionElectoralRepresentantes(){
        int total = 0;
        for(CandidatoRepresentante c : representantes){
            total += c.getVotos();
        }
        return total + votosNulosRepresentante + votosBlancoRepresentante;
    }

    // ==================== REPRESENTANTE POR GRADO ====================

    public boolean tieneCandidatosGrado(int grado){
        for(CandidatoRepresentante c : representantes){
            if(c.getGrado() == grado){
                return true;
            }
        }
        return false;
    }

    // Devuelve null si el grado no tiene candidatos, no hay votos o hay empate
    public CandidatoRepresentante representanteElegido(int grado){
        CandidatoRepresentante mayor = null;
        boolean empate = false;
        for(CandidatoRepresentante c : representantes){
            if(c.getGrado() == grado){
                if(mayor == null || c.getVotos() > mayor.getVotos()){
                    mayor = c;
                    empate = false;
                }
                else if(c.getVotos() == mayor.getVotos()){
                    empate = true;
                }
            }
        }
        if(mayor == null || mayor.getVotos() == 0 || empate){
            return null;
        }
        return mayor;
    }

    // ==================== LISTADO ====================

    public String listarCandidatos(){
        String texto = "--- Candidatos a personero ---\n";
        for(CandidatoPersonero c : personeros){
            texto += c.toString() + "\n";
        }
        texto += "\n--- Candidatos a representante de grado ---\n";
        for(CandidatoRepresentante c : representantes){
            texto += c.toString() + "\n";
        }
        return texto;
    }

    // ==================== GET ====================

    public ArrayList<CandidatoPersonero> getPersoneros(){
        return this.personeros;
    }

    public ArrayList<CandidatoRepresentante> getRepresentantes(){
        return this.representantes;
    }

    public int getVotosNulosPersonero(){
        return this.votosNulosPersonero;
    }

    public int getVotosBlancoPersonero(){
        return this.votosBlancoPersonero;
    }

    public int getVotosNulosRepresentante(){
        return this.votosNulosRepresentante;
    }

    public int getVotosBlancoRepresentante(){
        return this.votosBlancoRepresentante;
    }
}//End class
