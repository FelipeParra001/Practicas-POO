package modelo;

/**
 * Pago (completo o abono) de la cuota de administracion de un mes.
 */
public class Pago
{
    private int numero;
    private Unidad unidad;
    private int mes;
    private int anio;
    private double valor;

    public Pago(int numero, Unidad unidad, int mes, int anio, double valor){
        this.numero = numero;
        this.unidad = unidad;
        this.mes = mes;
        this.anio = anio;
        this.valor = valor;
    }

    public boolean esDelPeriodo(Unidad unidad, int mes, int anio){
        return this.unidad == unidad && this.mes == mes && this.anio == anio;
    }

    public String toString(){
        return "Pago #" + numero + " - Unidad " + unidad.getCodigo() + " - " + mes + "/" + anio + " - $" + (long) valor;
    }

    // ==================== GET Y SET ====================

    public int getNumero(){
        return this.numero;
    }

    public Unidad getUnidad(){
        return this.unidad;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAnio(){
        return this.anio;
    }

    public double getValor(){
        return this.valor;
    }
}//End class
