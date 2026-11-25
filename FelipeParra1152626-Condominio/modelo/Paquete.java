package modelo;

/**
 * Paquete o correspondencia que llega a portería para una unidad.
 */
public class Paquete
{
    private int numero;
    private Unidad unidad;
    private String remitente;
    private String descripcion;
    private boolean entregado;
    private Persona recibidoPor;

    public Paquete(int numero, Unidad unidad, String remitente, String descripcion){
        this.numero = numero;
        this.unidad = unidad;
        this.remitente = remitente;
        this.descripcion = descripcion;
        this.entregado = false;
        this.recibidoPor = null;
    }

    public void entregar(Persona persona){
        entregado = true;
        recibidoPor = persona;
    }

    public String toString(){
        String texto = "Paquete #" + numero + " - Unidad " + unidad.getCodigo() + " [" + unidad.getCondominio().getNombre()
            + "] - De: " + remitente + " - " + descripcion;
        if(entregado){
            texto += " - Entregado a " + recibidoPor.getNombre();
        }else{
            texto += " - Pendiente";
        }
        return texto;
    }

    // ==================== GET Y SET ====================

    public int getNumero(){
        return this.numero;
    }

    public Unidad getUnidad(){
        return this.unidad;
    }

    public String getRemitente(){
        return this.remitente;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public boolean isEntregado(){
        return this.entregado;
    }

    public Persona getRecibidoPor(){
        return this.recibidoPor;
    }
}//End class
