package Modelo;

public class Voto
{
    // Atributos
    private Cardenal votado;

    // Constructor
    public Voto(Cardenal votado)
    {
        this.votado = votado;
    }

    // Getters
    public Cardenal getVotado()
    {
        return votado;
    }

    // Setters
    public void setVotado(Cardenal votado)
    {
        this.votado = votado;
    }
}
