package Proyecto.Modelo;
import java.util.Calendar;


/**
 * Write a description of class Fecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int anio;
    
    
    public Fecha(){
        
    }
    
    public Fecha(int dia , int mes , int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie dia*/
    public int getDia(){
        return this.dia;
    }//end method getDia

    /**SET Method Propertie dia*/
    public void setDia(int dia){
        this.dia = dia;
    }//end method setDia

    /**GET Method Propertie mes*/
    public int getMes(){
        return this.mes;
    }//end method getMes

    /**SET Method Propertie mes*/
    public void setMes(int mes){
        this.mes = mes;
    }//end method setMes

    /**GET Method Propertie anio*/
    public int getAnio(){
        return this.anio;
    }//end method getAnio

    /**SET Method Propertie anio*/
    public void setAnio(int anio){
        this.anio = anio;
    }//end method setAnio

//End GetterSetterExtension Source Code
   
        public static Fecha hoy() {
        Calendar cal = Calendar.getInstance();
        int d = cal.get(Calendar.DAY_OF_MONTH);
        int m = cal.get(Calendar.MONTH) + 1; 
        int a = cal.get(Calendar.YEAR);
        return new Fecha(d, m, a);  

      }
      
       private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
      }
      
        public int diasDelMes(int mes, int anio) {
        switch (mes) {
            case 2:
                return esBisiesto(anio) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
      }
      
      public boolean esValida() {
        if (anio < 1 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }
        return dia <= diasDelMes(mes, anio);
     }
     
      public int compararCon(Fecha otra) {
        if (this.anio != otra.anio) {
            return this.anio - otra.anio;
        }
        if (this.mes != otra.mes) {
            return this.mes - otra.mes;
        }
        return this.dia - otra.dia;
     }
     
     public boolean esPosteriorAHoy() {
        return compararCon(Fecha.hoy()) > 0;
     }
     

     public String mostrarFecha() {
        return String.format("%04d-%02d-%02d", anio, mes, dia);
     }
     
      @Override
      public String toString() {
        return mostrarFecha();
    }
      
}
