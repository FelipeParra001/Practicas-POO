package modelo;
import java.util.ArrayList;


public class GestorEmocion
{
    private ArrayList<Emocion> lista ;
    private ArrayList<Recuerdo> recuerdos ;
    private ArrayList<Evento> eventos;
    public GestorEmocion(){
        lista = new ArrayList<>();
        recuerdos = new ArrayList<>();
        eventos = new ArrayList<>();
    }
    
    public boolean agregarEmocion(Emocion e){
        String nombre = e.getNombre();
        for(Emocion emocion: lista){
            if(emocion.getNombre().equals(nombre)){
                return false;
            }
        }
        lista.add(e);
        return true;
    }
    
    public String enlistarEmociones(){
        String r = "" ;
        for(Emocion emocion: lista){
            r += emocion.toString() + "\n";
        }
        return r ;
    }
    
    public boolean agregarRecuerdo(Recuerdo e){
        String nombre = e.getDescripcion();
        for(Recuerdo recuerdo: recuerdos){
            if(recuerdo.getDescripcion().equals(nombre)){
                return false;
            }
        }
        recuerdos.add(e);
        return true;
    }
    
    public boolean agregarEvento(Evento e){
        String nombre = e.getNombre();
        for(Evento evento: eventos){
            if(evento.getNombre().equals(nombre)){
                return false;
            }
        }
        eventos.add(e);
        return true;
    }
    
    public double calcularPromedio(){
        double suma = 0.0;
        double total = 0.0 ;
        for(Emocion emocion: lista){
            if(emocion.getTipo().equals("Positiva")){
            suma += emocion.getIntensidad();
        }else if(emocion.getTipo().equals("Negativa")){
            suma -= emocion.getIntensidad();
        }
            total++;
        }
        if(total == 0){
            return 0.0;
        }
        double  promedio = suma / total ;
        return promedio ;
    }
    
    public String enlistarRecuerdos(Emocion e){
        String r = "";
        if(e == null){
            return r;
        }
        for(Recuerdo recuerdo: recuerdos){
            if(recuerdo.getEmocion().getNombre().equals(e.getNombre())){
                r += recuerdo.enlistar();
            }
        }
        return r;
    }
    
    public void nuevaIntensidad(Emocion e,int nuevaInt, String operacion){
        if(e == null){
            return;
        }
        if(operacion.equals("Positivo")){
            e.sumarIntensidad(nuevaInt);
        }else if(operacion.equals("Negativo")){
            e.restarIntensidad(nuevaInt);
        }
    }
    
    public Emocion hallarEmocionMasIntensa(){
        int mayor = 0;
        Emocion Emayor = null ;
        for(Emocion emocion: lista){
            if(emocion.getIntensidad() > mayor){
                mayor = emocion.getIntensidad();
                Emayor = emocion;
            }
        }
        return Emayor ;
    }
    
    public String enlistarUltimos5(){
        String r = "";
        // Del mas reciente al mas antiguo, maximo 5
        int limite = recuerdos.size() - 5;
        if(limite < 0){
            limite = 0;
        }
        for(int i = recuerdos.size() - 1 ; i >= limite ;i--){
            r += recuerdos.get(i).enlistar();
        }
        return r;
    }
}
