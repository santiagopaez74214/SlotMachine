
/**
 * Class of exceptions of SlotMachine
 *
 * @author  David Páez y Joseph Cañón
 * @version 10/10/2026
 */
public class SlotMachineException extends Exception
{
    //public final static String;
    public final static String WHEEL_NOT_FOUND = "La rueda indicada no existe.";
    public final static String WHEELS_NOT_FOUND = "La máquina no tiene ruedas.";
    public final static String WHEEL_LOCKED = "La rueda está bloqueada.";
    public final static String WHEEL_TYPE_INVALID = "El tipo de rueda indicado no existe.";
    public final static String REBEL_WHEEL_CANNOT_BE_DELETED = "Una rueda rebelde no se puede eliminar.";
    public final static String REBEL_WHEEL_CANNOT_BE_LOCKED = "Una rueda rebelde no se puede bloquear.";
    public final static String REBEL_WHEEL_CANNOT_BE_SWAPPED = "Una rueda rebelde no se puede intercambiar.";
 
    // Symbols
    public final static String SYMBOL_TYPE_INVALID = "El tipo de símbolo indicado no existe.";
    public final static String SYMBOL_ALREADY_EXISTS = "Ya existe un símbolo de ese color en la rueda.";
    public final static String SYMBOL_NOT_FOUND = "El símbolo indicado no existe.";
 
    // Configuration    
    public final static String CONFIGURATION_SIZE_MISMATCH = "La configuración no coincide con el número de ruedas.";
    
    public SlotMachineException(){
        super();
    }
    
    public SlotMachineException(String message){
        super(message);
    }
    
    public String getMessage(){
        return super.getMessage();
    }
}