// Program for server application
import java.rmi.*;

public class Servidor_RMI {
    public static void main(String[] args) throws Exception
    {
  
        // Create an object of the interface
        // implementation class
        ImplementacionConsultarDatos obj = new ImplementacionConsultarDatos();
  
        // Binds the remote object by the name ADD
        Naming.rebind("ADD", obj);
  
        System.out.println("Servidor especializado en consultas dentro de la Bd... esperando por Invocacion de Metodos Remotos");
    }
}
