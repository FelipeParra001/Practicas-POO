package modelo;


/**
 * Write a description of class Riesgo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Riesgo {
  
    private String codigo, descripcion;
    private String tipo;
    private int nivelPeligro;

    public Riesgo() {
    }

    public Riesgo(String codigo, String descripcion, String tipo, int nivelPeligro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.nivelPeligro = nivelPeligro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
               "Descripción: " + descripcion + "\n" +
               "Tipo: " + tipo + "\n" +
               "Nivel de Peligro: " + nivelPeligro;
    }
}
