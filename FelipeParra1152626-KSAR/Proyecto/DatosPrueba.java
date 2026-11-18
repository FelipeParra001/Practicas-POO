package Proyecto;
import Proyecto.Modelo.Certificacion;
import Proyecto.Modelo.Fecha;
import Proyecto.Modelo.SistemaKsar;

/**
 * Write a description of class DatosPrueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatosPrueba
{
    public static void cargar(SistemaKsar s) {
        // Equipos
        s.registrarEquipo("Equipo Alpha", new Fecha(12, 3, 2018));
        s.registrarEquipo("Equipo Beta", new Fecha(21, 7, 2019));
        s.registrarEquipo("Equipo Gamma", new Fecha(5, 2, 2021));
        s.registrarEquipo("Equipo Delta", new Fecha(14, 9, 2023));
        
        // Guias
        s.registrarGuia("12345678", "Jorge Beens", Certificacion.VIGENTE);
        s.registrarGuia("23456789", "Ana Rojas", Certificacion.VIGENTE);
        s.registrarGuia("34567890", "Luis Pérez", Certificacion.VENCIDA);
        s.registrarGuia("45678901", "Marta Gómez", Certificacion.EN_TRAMITE);
        s.registrarGuia("56789012", "Carlos Díaz", Certificacion.VIGENTE);
        
        // Perros (CAN-001 a CAN-005)
        s.registrarPerro("Tsunami", "Border collie blanco y negro, rescatado del maltrato", "Border collie", 9, Certificacion.VIGENTE);
        s.registrarPerro("Rex", "Pelaje negro con canela", "Pastor alemán", 5, Certificacion.VIGENTE);
        s.registrarPerro("Luna", "Pelaje color miel", "Labrador", 4, Certificacion.VIGENTE);
        s.registrarPerro("Kira", "Pelaje dorado largo", "Golden retriever", 6, Certificacion.EN_TRAMITE);
        s.registrarPerro("Max", "Pelaje corto leonado con máscara negra", "Malinois", 3, Certificacion.VENCIDA);
        
        // Binomios (Carlos Díaz y Max quedan sueltos para probar "Armar binomio")
        s.armarBinomio("12345678", "CAN-001", "Equipo Alpha");
        s.armarBinomio("23456789", "CAN-002", "Equipo Beta");
        s.armarBinomio("34567890", "CAN-003", "Equipo Alpha");
        s.armarBinomio("45678901", "CAN-004", "Equipo Gamma");
        
        // Ubicaciones
        s.registrarUbicacion("Venezuela", "VE", "Libertador", "Residencias Rita", "Av. Principal", "15", "San Bernardino");
        s.registrarUbicacion("Venezuela", "VE", "Vargas", "Quebrada Seca", "Calle 4", "8", "La Guaira");
        s.registrarUbicacion("Venezuela", "VE", "Libertador", "Mercado Municipal", "Calle 7", "22", "Centro");
        
        // Eventos y misiones
        s.registrarTerremoto(new Fecha(24, 6, 2026), 7.2, "Caracas",
                s.buscarLugar("VE", "Libertador", "Residencias Rita"));
        s.registrarDeslave(new Fecha(10, 7, 2026), 1500, "Quebrada Seca",
                s.buscarLugar("VE", "Vargas", "Quebrada Seca"));
        s.registrarTerremoto(new Fecha(25, 6, 2026), 7.5, "La Guaira",
                s.buscarLugar("VE", "Libertador", "Mercado Municipal"));
        
        s.registrarMision(new Fecha(24, 6, 2026), s.getEventos().get(0), s.getBinomios().get(0), 12, 3, 1);
        s.registrarMision(new Fecha(11, 7, 2026), s.getEventos().get(1), s.getBinomios().get(1), 8, 2, 0);
        // El tercer evento queda sin mision, para probar "Registrar misión"
    }
}