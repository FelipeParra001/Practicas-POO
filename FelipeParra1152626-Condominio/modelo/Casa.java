package modelo;

/**
 * Casa o unidad residencial independiente del condominio.
 */
public class Casa extends Unidad
{
    private int numeroPisos;
    private boolean tienePatio;

    public Casa(String codigo, double area, Condominio condominio, int numeroPisos, boolean tienePatio){
        super(codigo, area, condominio);
        this.numeroPisos = numeroPisos;
        this.tienePatio = tienePatio;
    }

    // $3.000 por m2 y $30.000 adicionales si tiene patio
    public double calcularCuota(){
        double cuota = getArea() * 3000;
        if(tienePatio){
            cuota += 30000;
        }
        return cuota;
    }

    public String getTipo(){
        return "Casa";
    }

    public String toString(){
        return super.toString() + " - " + numeroPisos + " piso(s)" + (tienePatio ? ", con patio" : ", sin patio");
    }

    // ==================== GET Y SET ====================

    public int getNumeroPisos(){
        return this.numeroPisos;
    }

    public boolean isTienePatio(){
        return this.tienePatio;
    }
}//End class
