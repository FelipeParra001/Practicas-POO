package modelo;

import java.util.ArrayList;

/**
 * Guarda los conflictos y los grupos armados registrados.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class GestorConflictos
{
    private ArrayList<Conflicto> conflictos;
    private ArrayList<GrupoArmado> grupos;
    
    public GestorConflictos()
    {
        conflictos = new ArrayList<Conflicto>();
        grupos = new ArrayList<GrupoArmado>();
    }
    
    // ----------------------------- Conflictos -----------------------------
    
    // Crea el conflicto segun el tipo. Devuelve false si ya existe el nombre o el tipo no es valido
    public boolean registrarConflicto(String tipo, String nombre, String pais, int muertos, int heridos, String detalle)
    {
        if (buscarConflicto(nombre) != null)
        {
            return false;
        }
        Pais p = new Pais(pais);
        Conflicto c = null;
        if (tipo.equals("Territorial"))
        {
            c = new Territorial(nombre, p, muertos, heridos, detalle);
        }
        else if (tipo.equals("Religioso"))
        {
            c = new Religioso(nombre, p, muertos, heridos, detalle);
        }
        else if (tipo.equals("Economico"))
        {
            c = new Economico(nombre, p, muertos, heridos, detalle);
        }
        else if (tipo.equals("Racial"))
        {
            c = new Racial(nombre, p, muertos, heridos, detalle);
        }
        if (c == null)
        {
            return false;
        }
        conflictos.add(c);
        return true;
    }
    
    public Conflicto buscarConflicto(String nombre)
    {
        for (int i = 0; i < conflictos.size(); i++)
        {
            if (conflictos.get(i).getNombre().equalsIgnoreCase(nombre))
            {
                return conflictos.get(i);
            }
        }
        return null;
    }
    
    public int totalMuertos()
    {
        int total = 0;
        for (int i = 0; i < conflictos.size(); i++)
        {
            total = total + conflictos.get(i).getMuertos();
        }
        return total;
    }
    
    public int totalHeridos()
    {
        int total = 0;
        for (int i = 0; i < conflictos.size(); i++)
        {
            total = total + conflictos.get(i).getHeridos();
        }
        return total;
    }
    
    // Conflicto con mas muertos (null si no hay conflictos)
    public Conflicto conflictoMasGrave()
    {
        Conflicto mayor = null;
        for (int i = 0; i < conflictos.size(); i++)
        {
            if (mayor == null || conflictos.get(i).getMuertos() > mayor.getMuertos())
            {
                mayor = conflictos.get(i);
            }
        }
        return mayor;
    }
    
    // --------------------------- Grupos armados ---------------------------
    
    public boolean registrarGrupo(String codigo, String nombre, String nombreLider, String apoyos)
    {
        if (buscarGrupo(codigo) != null)
        {
            return false;
        }
        LiderPolitico lider = new LiderPolitico(nombreLider, apoyos);
        grupos.add(new GrupoArmado(codigo, nombre, lider));
        return true;
    }
    
    public GrupoArmado buscarGrupo(String codigo)
    {
        for (int i = 0; i < grupos.size(); i++)
        {
            if (grupos.get(i).getCodigo().equalsIgnoreCase(codigo))
            {
                return grupos.get(i);
            }
        }
        return null;
    }
    
    // 0 = agregada, 1 = no existe el grupo, 2 = consecutivo repetido
    public int agregarDivision(String codigoGrupo, int consecutivo, int barcos, int aviones,
                               int hombres, int tanques, int bajas)
    {
        GrupoArmado g = buscarGrupo(codigoGrupo);
        if (g == null)
        {
            return 1;
        }
        Division d = new Division(consecutivo, barcos, aviones, hombres, tanques, bajas);
        if (!g.agregarDivision(d))
        {
            return 2;
        }
        return 0;
    }
    
    public int totalBajas()
    {
        int total = 0;
        for (int i = 0; i < grupos.size(); i++)
        {
            total = total + grupos.get(i).SumaBajas();
        }
        return total;
    }
    
    // ------------------------------- Reporte -------------------------------
    
    public String reporte()
    {
        String texto = "===== CONFLICTOS =====\n";
        if (conflictos.size() == 0)
        {
            texto = texto + "No hay conflictos registrados\n";
        }
        for (int i = 0; i < conflictos.size(); i++)
        {
            texto = texto + (i + 1) + ". " + conflictos.get(i).toString() + "\n";
        }
        texto = texto + "Total muertos: " + totalMuertos() + "\n";
        texto = texto + "Total heridos: " + totalHeridos() + "\n";
        Conflicto grave = conflictoMasGrave();
        if (grave != null)
        {
            texto = texto + "Conflicto con mas muertos: " + grave.getNombre() + "\n";
        }
        texto = texto + "\n===== GRUPOS ARMADOS =====\n";
        if (grupos.size() == 0)
        {
            texto = texto + "No hay grupos registrados\n";
        }
        for (int i = 0; i < grupos.size(); i++)
        {
            GrupoArmado g = grupos.get(i);
            texto = texto + g.toString() + "\n";
            for (int j = 0; j < g.getDivisiones().size(); j++)
            {
                texto = texto + "   " + g.getDivisiones().get(j).toString() + "\n";
            }
        }
        texto = texto + "Total bajas de todos los grupos: " + totalBajas() + "\n";
        return texto;
    }
    
    public ArrayList<Conflicto> getConflictos()
    {
        return conflictos;
    }
    
    public ArrayList<GrupoArmado> getGrupos()
    {
        return grupos;
    }
}
