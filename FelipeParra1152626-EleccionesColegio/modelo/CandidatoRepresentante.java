package modelo;

public class CandidatoRepresentante extends Candidato
{
    private Estudiante formula;

    public CandidatoRepresentante(String nombre, String apellido, int grado, String grupo, String lema, int numeroTarjeton, Estudiante formula){
        super(nombre, apellido, grado, grupo, lema, numeroTarjeton);
        this.formula = formula;
    }

    public String toString(){
        return super.toString() + "\n   Fórmula: " + formula.toString();
    }

    public Estudiante getFormula(){
        return this.formula;
    }

    public void setFormula(Estudiante formula){
        this.formula = formula;
    }
}//End class
