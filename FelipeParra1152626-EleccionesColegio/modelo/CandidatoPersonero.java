package modelo;

public class CandidatoPersonero extends Candidato
{
    private Mascota mascota;

    public CandidatoPersonero(String nombre, String apellido, int grado, String grupo, String lema, int numeroTarjeton, Mascota mascota){
        super(nombre, apellido, grado, grupo, lema, numeroTarjeton);
        this.mascota = mascota;
    }

    public String toString(){
        return super.toString() + "\n   Mascota: " + mascota.toString();
    }

    public Mascota getMascota(){
        return this.mascota;
    }

    public void setMascota(Mascota mascota){
        this.mascota = mascota;
    }
}//End class
