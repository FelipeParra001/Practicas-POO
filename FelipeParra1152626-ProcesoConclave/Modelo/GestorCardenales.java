package Modelo;

import java.util.*;

public class GestorCardenales
{
    // Atributos
    private ArrayList<Cardenal> cardenales;
    private ArrayList<Cardenal> electores;
    private ArrayList<Ronda> rondas;
    private Ronda rondaActual;
    private Cardenal papa;
    private int mayoria;

    // Constructor
    public GestorCardenales()
    {
        cardenales = new ArrayList<Cardenal>();
        electores = new ArrayList<Cardenal>();
        rondas = new ArrayList<Ronda>();
        cargarCardenales();
        cargarElectores();
        mayoria = (int) Math.ceil(electores.size() * 2.0 / 3.0);
        iniciarRonda();
    }

    // Metodos
    private void cargarCardenales()
    {
        cardenales.add(new Cardenal("Italia", "1001", "Pietro Parolin", 70, TipoCardenal.OBISPO));
        cardenales.add(new Cardenal("Filipinas", "1002", "Luis Tagle", 67, TipoCardenal.OBISPO));
        cardenales.add(new Cardenal("Estados Unidos", "1003", "Robert Prevost", 69, TipoCardenal.PRESBITERO));
        cardenales.add(new Cardenal("Hungria", "1004", "Peter Erdo", 72, TipoCardenal.OBISPO));
        cardenales.add(new Cardenal("Congo", "1005", "Fridolin Ambongo", 65, TipoCardenal.DIACONO));
        cardenales.add(new Cardenal("Italia", "1006", "Matteo Zuppi", 69, TipoCardenal.PRESBITERO));
        cardenales.add(new Cardenal("Italia", "1007", "Angelo Sodano", 92, TipoCardenal.OBISPO));
        cardenales.add(new Cardenal("Espana", "1008", "Carlos Amigo", 85, TipoCardenal.PRESBITERO));
    }

    private void cargarElectores()
    {
        for (int i = 0; i < cardenales.size(); i++)
        {
            if (cardenales.get(i).esElector())
            {
                electores.add(cardenales.get(i));
            }
        }
    }

    private void iniciarRonda()
    {
        int numero = rondas.size() + 1;
        int dia = ((numero - 1) / 4) + 1;
        String jornada = "manana";
        if ((numero - 1) % 4 >= 2)
        {
            jornada = "tarde";
        }
        rondaActual = new Ronda(numero, jornada, dia);
        rondas.add(rondaActual);
    }

    public boolean votar(Cardenal votado)
    {
        if (papa != null)
        {
            return false;
        }
        if (rondaActual.cantidadVotos() >= electores.size())
        {
            return false;
        }
        rondaActual.agregarVoto(new Voto(votado));
        if (rondaCerrada())
        {
            revisarMayoria();
        }
        return true;
    }

    public boolean rondaCerrada()
    {
        return rondaActual.cantidadVotos() >= electores.size();
    }

    private void revisarMayoria()
    {
        for (int i = 0; i < cardenales.size(); i++)
        {
            Cardenal c = cardenales.get(i);
            if (rondaActual.votosDe(c) >= mayoria)
            {
                papa = c;
                return;
            }
        }
    }

    public boolean siguienteRonda()
    {
        if (papa != null)
        {
            return false;
        }
        if (!rondaCerrada())
        {
            return false;
        }
        iniciarRonda();
        return true;
    }

    public String listarElectores()
    {
        String texto = "";
        for (int i = 0; i < electores.size(); i++)
        {
            Cardenal c = electores.get(i);
            texto = texto + (i + 1) + ". " + c.getNombre() + " - " + c.getPais() + " - " + c.getEdad() + " anios\n";
        }
        return texto;
    }

    public String resultadosRonda()
    {
        String texto = "Ronda " + rondaActual.getNumero() + " | dia " + rondaActual.getDia() + " | " + rondaActual.getJornada() + "\n";
        texto = texto + "Electores: " + electores.size() + " | Mayoria 2/3: " + mayoria + "\n";
        texto = texto + "Votos: " + rondaActual.cantidadVotos() + " de " + electores.size() + "\n\n";
        for (int i = 0; i < cardenales.size(); i++)
        {
            Cardenal c = cardenales.get(i);
            int v = rondaActual.votosDe(c);
            if (v > 0)
            {
                texto = texto + c.getNombre() + ": " + v + " votos\n";
            }
        }
        if (rondaCerrada())
        {
            if (papa != null)
            {
                texto = texto + "\nHay nuevo papa\n";
                texto = texto + "Ronda: " + rondaActual.getNumero() + "\n";
                texto = texto + "Jornada: " + rondaActual.getJornada() + "\n";
                texto = texto + "Nombre: " + papa.getNombre() + "\n";
                texto = texto + "Pais: " + papa.getPais() + "\n";
                texto = texto + "Edad: " + papa.getEdad();
            }
            else
            {
                texto = texto + "\nNo hay papa aun";
            }
        }
        return texto;
    }

    public ArrayList<Cardenal> getCardenales()
    {
        return cardenales;
    }

    public ArrayList<Cardenal> getElectores()
    {
        return electores;
    }

    public Ronda getRondaActual()
    {
        return rondaActual;
    }

    public Cardenal getPapa()
    {
        return papa;
    }

    public int getMayoria()
    {
        return mayoria;
    }
}
