package modelo;

import java.util.ArrayList;

/**
 * Grupo armado que participa en conflictos. Tiene divisiones y un lider politico.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class GrupoArmado
{ 
    private String codigo;
    private String nombre;
    private LiderPolitico liderPolitico;
    private ArrayList<Division> divisiones;
    
    public GrupoArmado(String codigo, String nombre, LiderPolitico liderPolitico)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.liderPolitico = liderPolitico;
        this.divisiones = new ArrayList<Division>();
        if (liderPolitico != null)
        {
            liderPolitico.setGrupo(this);
        }
    }
    
    // Agrega una division si no existe otra con el mismo consecutivo
    public boolean agregarDivision(Division division)
    {
        if (buscarDivision(division.getConsecutivo()) != null)
        {
            return false;
        }
        divisiones.add(division);
        return true;
    }
    
    public Division buscarDivision(int consecutivo)
    {
        for (int i = 0; i < divisiones.size(); i++)
        {
            if (divisiones.get(i).getConsecutivo() == consecutivo)
            {
                return divisiones.get(i);
            }
        }
        return null;
    }
    
    // Total de bajas del grupo = suma de las bajas de sus divisiones
    public int SumaBajas(){
     int total = 0;
     for (int i = 0; i < divisiones.size(); i++)
     {
         total = total + divisiones.get(i).getBajas();
     }
     return total;
    }
    
    // Total de hombres del grupo
    public int totalHombres()
    {
        int total = 0;
        for (int i = 0; i < divisiones.size(); i++)
        {
            total = total + divisiones.get(i).getHombres();
        }
        return total;
    }
    
    public String getCodigo()
    {
        return codigo;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public LiderPolitico getLiderPolitico()
    {
        return liderPolitico;
    }
    
    public ArrayList<Division> getDivisiones()
    {
        return divisiones;
    }
    
    public String toString()
    {
        String lider = "sin lider";
        if (liderPolitico != null)
        {
            lider = liderPolitico.getNombre();
        }
        return codigo + " - " + nombre + " (Lider: " + lider + ") - Divisiones: " + divisiones.size()
            + " - Hombres: " + totalHombres() + " - Bajas: " + SumaBajas();
    }
}
