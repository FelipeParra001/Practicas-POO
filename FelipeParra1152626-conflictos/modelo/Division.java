package modelo;

/**
 * Division de un grupo armado: barcos, aviones, hombres, tanques y bajas.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Division
{ private int consecutivo;
  private int barcos; 
  private int aviones;  
  private int hombres;  
  private int tanques;
  private int bajas;  
  
  public Division(int consecutivo, int barcos, int aviones, int hombres, int tanques, int bajas)
  {
      this.consecutivo = consecutivo;
      this.barcos = barcos;
      this.aviones = aviones;
      this.hombres = hombres;
      this.tanques = tanques;
      this.bajas = bajas;
  }
  
  // Suma nuevas bajas a la division y devuelve el total de bajas
  public int sumarBajas(int nuevasBajas){
    if (nuevasBajas > 0)
    {
        bajas = bajas + nuevasBajas;
    }
    return bajas;
    }
  
  public int getConsecutivo()
  {
      return consecutivo;
  }
  
  public int getBarcos()
  {
      return barcos;
  }
  
  public int getAviones()
  {
      return aviones;
  }
  
  public int getHombres()
  {
      return hombres;
  }
  
  public int getTanques()
  {
      return tanques;
  }
  
  public int getBajas()
  {
      return bajas;
  }
  
  public String toString()
  {
      return "Division " + consecutivo + ": barcos " + barcos + ", aviones " + aviones
          + ", hombres " + hombres + ", tanques " + tanques + ", bajas " + bajas;
  }
}
