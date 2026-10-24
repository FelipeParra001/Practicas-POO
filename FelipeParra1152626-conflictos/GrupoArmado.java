
/**
 * Write a description of class GrupoArmado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrupoArmado
{ 
    private String codigo;
    private String nombre;
    private LiderPolitico liderPolitico;
    
    
    public void SumaBajas(Division division){
     division.sumarBajas();
     
    }
    
}