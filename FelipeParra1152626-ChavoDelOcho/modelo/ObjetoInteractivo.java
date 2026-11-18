package modelo;

public class ObjetoInteractivo
{
    private String nombre;
    private String descripcion;
    private String accion;
    private int vecesUsado;

    public ObjetoInteractivo(String nombre, String descripcion, String accion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.accion = accion;
        this.vecesUsado = 0;
    }

    // Lo que pasa cuando el jugador interactua con el objeto
    public String usar(){
        vecesUsado++;
        return accion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getAccion(){
        return this.accion;
    }

    public void setAccion(String accion){
        this.accion = accion;
    }

    public int getVecesUsado(){
        return this.vecesUsado;
    }
}//End class
