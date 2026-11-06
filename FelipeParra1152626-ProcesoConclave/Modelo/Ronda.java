package Modelo;

import java.util.*;

public class Ronda
{
    // Atributos
    private int numero;
    private String jornada;
    private int dia;
    private ArrayList<Voto> votos;

    // Constructor
    public Ronda(int numero, String jornada, int dia)
    {
        this.numero = numero;
        this.jornada = jornada;
        this.dia = dia;
        votos = new ArrayList<Voto>();
    }

    // Getters
    public int getNumero()
    {
        return numero;
    }

    public String getJornada()
    {
        return jornada;
    }

    public int getDia()
    {
        return dia;
    }

    public ArrayList<Voto> getVotos()
    {
        return votos;
    }

    // Setters
    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public void setJornada(String jornada)
    {
        this.jornada = jornada;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }

    // Metodos
    public void agregarVoto(Voto voto)
    {
        votos.add(voto);
    }

    public int cantidadVotos()
    {
        return votos.size();
    }

    public int votosDe(Cardenal cardenal)
    {
        int total = 0;
        for (int i = 0; i < votos.size(); i++)
        {
            if (votos.get(i).getVotado() == cardenal)
            {
                total = total + 1;
            }
        }
        return total;
    }
}
