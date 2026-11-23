package modelo;

/**
 * Tipo de arma que vende un traficante, con su capacidad destructiva y su stock.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class TipoArma
{ private String nombre;
  private int capacidadDestructiva;
  private Traficante traficante;
  private int numero;
  
  public TipoArma(String nombre, int capacidadDestructiva, Traficante traficante, int numero)
  {
      this.nombre = nombre;
      this.capacidadDestructiva = capacidadDestructiva;
      this.traficante = traficante;
      this.numero = numero;
  }
  
  // Cantidad de armas disponibles
  public int stockArmas(){
    return numero;
    }
  
  // Saca armas del stock. Devuelve false si no hay suficientes
  public boolean retirarArmas(int cantidad)
  {
      if (cantidad <= 0 || cantidad > numero)
      {
          return false;
      }
      numero = numero - cantidad;
      return true;
  }
  
  public String getNombre()
  {
      return nombre;
  }
  
  public int getCapacidadDestructiva()
  {
      return capacidadDestructiva;
  }
  
  public Traficante getTraficante()
  {
      return traficante;
  }
}
