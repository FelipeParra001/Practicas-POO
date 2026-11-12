package modelo;
import java.util.*;

public class Gestor
{
    private ArrayList<Recuerdo>recuerdos;
    private ArrayList<Evento> eventos;
    private ArrayList<Emocion> emociones;
    
    
    public Gestor(){
        recuerdos = new ArrayList<>();
        eventos = new ArrayList<>();
        emociones = new ArrayList<>();
    }
    
    public boolean agregarRecuerdos(Recuerdo r){
        for(Recuerdo re : recuerdos){
            if(re.getCodigo().equals(r.getCodigo())){
                return false;
            }
        }
        recuerdos.add(r);
        return true;
    }
    
    public boolean agregarEventos(Evento e){
        for(Evento ev : eventos){
            if(ev.getNombre().equals(e.getNombre())){
                return false;
            }
        }
        eventos.add(e);
        return true;
    }
    
    public boolean agregarEmociones(Emocion e){
        for(Emocion ev : emociones){
            if(ev.getNombre().equals(e.getNombre())){
                return false;
            }
        }
        emociones.add(e);
        return true;
    }
    
    public Recuerdo buscarRecuerdo(String codigo){
        for(Recuerdo re : recuerdos){
            if(re.getCodigo().equals(codigo)){
                return re;
            }
        }
        return null;
    }
    
    public Emocion buscarEmocion(String nombre){
        for(Emocion e : emociones){
            if(e.getNombre().equals(nombre)){
                return e;
            }
        }
        return null;
    }
    
    public Evento buscarEvento(String nombre){
        for(Evento e : eventos){
            if(e.getNombre().equals(nombre)){
                return e;
            }
        }
        return null;
    }
}