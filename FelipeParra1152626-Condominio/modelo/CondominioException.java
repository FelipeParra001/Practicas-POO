package modelo;

/**
 * Excepcion propia del sistema Condominius.
 * Se lanza cuando se incumple una regla de negocio o un dato no es valido.
 */
public class CondominioException extends Exception
{
    private static final long serialVersionUID = 1L;

    public CondominioException(String mensaje){
        super(mensaje);
    }
}//End class
