package modelo;

/**
 * Dialogo de paz entre un lider politico y una organizacion mediadora en una fecha.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Dialogo
{ private Fecha fechaDialogo;
  private LiderPolitico lideres;
  private OrganizacionMediadora organizaciones;
  
  public Dialogo(Fecha fechaDialogo, LiderPolitico lideres, OrganizacionMediadora organizaciones)
  {
      this.fechaDialogo = fechaDialogo;
      this.lideres = lideres;
      this.organizaciones = organizaciones;
  }
  
  public Fecha getFechaDialogo()
  {
      return fechaDialogo;
  }
  
  public LiderPolitico getLideres()
  {
      return lideres;
  }
  
  public OrganizacionMediadora getOrganizaciones()
  {
      return organizaciones;
  }
}
