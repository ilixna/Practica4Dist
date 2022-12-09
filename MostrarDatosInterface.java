// Creando una Interfaz SubInterface
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MostrarDatosInterface extends Remote {

    // Declaring the method prototype
    public void mostrarDatos(List<String> listaDatos) throws RemoteException;
}
