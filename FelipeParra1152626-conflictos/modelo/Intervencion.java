package modelo;

/**
 * Intervencion de una organizacion mediadora o de un grupo armado en un conflicto.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Intervencion
{  private OrganizacionMediadora organizaciones;
   private GrupoArmado grupos;
   private Conflicto conflictos;
   private Fecha fechaIncorporacion;
   private Fecha fechaSalida;
   private int numDespliegue;
   
   public Intervencion(OrganizacionMediadora organizaciones, GrupoArmado grupos, Conflicto conflictos,
                       Fecha fechaIncorporacion, Fecha fechaSalida, int numDespliegue)
   {
       this.organizaciones = organizaciones;
       this.grupos = grupos;
       this.conflictos = conflictos;
       this.fechaIncorporacion = fechaIncorporacion;
       this.fechaSalida = fechaSalida;
       this.numDespliegue = numDespliegue;
   }
   
   public OrganizacionMediadora getOrganizaciones()
   {
       return organizaciones;
   }
   
   public GrupoArmado getGrupos()
   {
       return grupos;
   }
   
   public Conflicto getConflictos()
   {
       return conflictos;
   }
   
   public Fecha getFechaIncorporacion()
   {
       return fechaIncorporacion;
   }
   
   public Fecha getFechaSalida()
   {
       return fechaSalida;
   }
   
   public int getNumDespliegue()
   {
       return numDespliegue;
   }
}
