package modelo;

public abstract class Candidato extends Estudiante
{
    private String lema;
    private int numeroTarjeton;
    private int votos;

    public Candidato(String nombre, String apellido, int grado, String grupo, String lema, int numeroTarjeton){
        super(nombre, apellido, grado, grupo);
        this.lema = lema;
        this.numeroTarjeton = numeroTarjeton;
        this.votos = 0;
    }

    public void sumarVoto(){
        votos++;
    }

    public String toString(){
        return "Tarjetón " + numeroTarjeton + ": " + super.toString() + " - \"" + lema + "\"";
    }

    // ==================== GET Y SET ====================

    public String getLema(){
        return this.lema;
    }

    public void setLema(String lema){
        this.lema = lema;
    }

    public int getNumeroTarjeton(){
        return this.numeroTarjeton;
    }

    public void setNumeroTarjeton(int numeroTarjeton){
        this.numeroTarjeton = numeroTarjeton;
    }

    public int getVotos(){
        return this.votos;
    }
}//End class
