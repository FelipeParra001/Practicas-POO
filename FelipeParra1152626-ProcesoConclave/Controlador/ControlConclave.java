package Controlador;

import Modelo.*;

public class ControlConclave
{
    // Atributos
    private GestorCardenales gestor;

    // Constructor
    public ControlConclave()
    {
        gestor = new GestorCardenales();
    }

    // Metodos
    public boolean votar(Cardenal cardenal)
    {
        return gestor.votar(cardenal);
    }

    public boolean siguienteRonda()
    {
        return gestor.siguienteRonda();
    }

    public boolean rondaCerrada()
    {
        return gestor.rondaCerrada();
    }

    public String resultados()
    {
        return gestor.resultadosRonda();
    }

    public String electores()
    {
        return gestor.listarElectores();
    }

    public GestorCardenales getGestor()
    {
        return gestor;
    }
}
