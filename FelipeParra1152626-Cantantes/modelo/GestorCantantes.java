package modelo;

import java.util.*;

public class GestorCantantes
{
    // Atributos
    private ArrayList<Cantante> lista;

    // Constructor
    public GestorCantantes()
    {
        lista = new ArrayList<Cantante>();
    }

    // Metodos
    public void agregar(Cantante c)
    {
        lista.add(c);
    }

    public Cantante buscarPorNombre(String nombre)
    {
        for (int i = 0; i < lista.size(); i++)
        {
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre))
            {
                return lista.get(i);
            }
        }
        return null;
    }

    public boolean eliminar(String nombre)
    {
        Cantante c = buscarPorNombre(nombre);
        if (c == null) return false;
        lista.remove(c);
        return true;
    }

    public String listar()
    {
        if (lista.size() == 0) return "No hay cantantes";
        String texto = "";
        for (int i = 0; i < lista.size(); i++)
        {
            texto = texto + lista.get(i).toString() + "\n";
        }
        return texto;
    }
}
