// Creando una Interfaz SubInterface
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ObtenerDatosInterface extends Remote {

    // Declaring the method prototype
    public List<String> obtenerTodos() throws RemoteException;
    public String  obtenerPorCI(String ci) throws RemoteException;

}
