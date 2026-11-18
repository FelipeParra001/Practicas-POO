package modelo;

public class SenorBarriga extends Personaje
{
    public SenorBarriga(){
        super("Señor Barriga", 50, "Paciente y bondadoso", "Dueño de la vecindad");
        agregarDialogo("¡Tenía que ser el Chavo del Ocho!");
        agregarDialogo("Vengo a cobrar la renta");
    }

    public String accionCon(Personaje otro){
        if(otro instanceof DonRamon){
            return "le cobra los 14 meses de renta a " + otro.getNombre();
        }
        return "saluda amablemente a " + otro.getNombre();
    }
}//End class
