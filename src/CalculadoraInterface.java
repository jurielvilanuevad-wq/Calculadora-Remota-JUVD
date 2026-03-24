import java.rmi.Remote;
import java.rmi.RemoteException;


// Extiende Remote: le dice a Java que esta interfaz
// puede ser usada desde otra maquina por la red
public interface CalculadoraInterface extends Remote{
    
}
