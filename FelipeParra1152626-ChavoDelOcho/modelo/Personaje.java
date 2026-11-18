package modelo;
import java.util.ArrayList;

public abstract class Personaje
{
    private String nombre;
    private int edad;
    private String personalidad;
    private String rol;
    private ArrayList<String> dialogos;
    private ArrayList<Relacion> relaciones;
    private int turnoDialogo;

    public Personaje(String nombre, int edad, String personalidad, String rol){
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
        this.dialogos = new ArrayList<>();
        this.relaciones = new ArrayList<>();
        this.turnoDialogo = 0;
    }

    // ==================== DIALOGOS ====================

    public void agregarDialogo(String dialogo){
        if(dialogo != null && !dialogo.trim().isEmpty()){
            dialogos.add(dialogo);
        }
    }

    // Devuelve el siguiente dialogo y vuelve a empezar al llegar al final
    public String decirDialogo(){
        if(dialogos.isEmpty()){
            return "...";
        }
        String dialogo = dialogos.get(turnoDialogo);
        turnoDialogo++;
        if(turnoDialogo >= dialogos.size()){
            turnoDialogo = 0;
        }
        return dialogo;
    }

    // ==================== RELACIONES ====================

    public void agregarRelacion(Personaje otro, String tipo){
        if(otro == null || otro == this){
            return;
        }
        for(Relacion r : relaciones){
            if(r.getPersonaje() == otro){
                r.setTipo(tipo);
                return;
            }
        }
        relaciones.add(new Relacion(otro, tipo));
    }

    public String tipoRelacionCon(Personaje otro){
        for(Relacion r : relaciones){
            if(r.getPersonaje() == otro){
                return r.getTipo();
            }
        }
        return "Conocidos";
    }

    public String describirRelaciones(){
        if(relaciones.isEmpty()){
            return "Sin relaciones";
        }
        String texto = "";
        for(Relacion r : relaciones){
            texto += r.getTipo() + " con " + r.getPersonaje().getNombre() + "; ";
        }
        return texto;
    }

    // ==================== INTERACCION (RF2) ====================

    // Cada personaje tiene su propia accion con otro personaje
    public abstract String accionCon(Personaje otro);

    public String toString(){
        return nombre + " | " + edad + " años | " + personalidad + " | " + rol;
    }

    // ==================== GET Y SET ====================

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getPersonalidad(){
        return this.personalidad;
    }

    public void setPersonalidad(String personalidad){
        this.personalidad = personalidad;
    }

    public String getRol(){
        return this.rol;
    }

    public void setRol(String rol){
        this.rol = rol;
    }

    public ArrayList<String> getDialogos(){
        return this.dialogos;
    }

    public ArrayList<Relacion> getRelaciones(){
        return this.relaciones;
    }
}//End class
