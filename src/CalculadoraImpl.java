import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementación
// Aqui se define COMO se ejecuta cada operación.
// Extiende UnicastRemoteObject para poder recibir llamdas remotas.
// Implementa CalculadoraInterface para cumplir el contrato.

public class CalculadoraImpl extends UnicastRemoteObject implements CalculadoraInterface {
    // Constructor obligatorio que lanza RemoteException.
    // Llama a super() para que UnicastRemoteObject.
    // registre este objeto y lo ponga a escuchar la red.
    public CalculadoraImpl() throws RemoteException{
        super();
    }

    // Suma: operación más simple, retorna a + b
    @Override
    public double sumar(double a, double b) throws RemoteException{
        double resultado = a + b;
        System.out.println("[Servidor] " + a + " + " + b + " = " + resultado);
        return resultado;
    }

    // Resta: retorna a - b
    @Override
    public double restar(double a, double b) throws RemoteException{
        double resultado = a - b;
        System.out.println("[Servidor] " + a + " - " + b + " = " + resultado);
        return resultado;
    }

    // Multiplicación: retorna a * b
    @Override
    public double multiplicar(double a, double b) throws RemoteException{
        double resultado = a * b;
        System.out.println("[Servidor] " + a + " * " + b + " = " + resultado);
        return resultado;
    }

    // División: valida quie el divisor no sea cero antes de dividir.
    // Si b == 0, lanza una excpeción con mensaje descriptivo.
    // Esta excepción viaja de vuelta al Cliente por la red.
    @Override
    public double dividir(double a, double b) throws RemoteException{
        if (b == 0) {
            throw new RemoteException("Error: no se puede dividir entre cero.");
        }
        double resultado = a / b;
        System.out.println("[Servidor] " + a + " / " + b + " = " + resultado);
        return resultado;
    }
    
}
