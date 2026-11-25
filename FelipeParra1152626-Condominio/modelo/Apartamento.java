package modelo;

/**
 * Apartamento ubicado en una torre del condominio.
 */
public class Apartamento extends Unidad
{
    private String torre;
    private int piso;

    public Apartamento(String codigo, double area, Condominio condominio, String torre, int piso){
        super(codigo, area, condominio);
        this.torre = torre;
        this.piso = piso;
    }

    // $3.500 por m2 y $20.000 de ascensor desde el piso 6
    public double calcularCuota(){
        double cuota = getArea() * 3500;
        if(piso >= 6){
            cuota += 20000;
        }
        return cuota;
    }

    public String getTipo(){
        return "Apartamento";
    }

    public String toString(){
        return super.toString() + " - Torre " + torre + ", piso " + piso;
    }

    // ==================== GET Y SET ====================

    public String getTorre(){
        return this.torre;
    }

    public int getPiso(){
        return this.piso;
    }
}//End class
