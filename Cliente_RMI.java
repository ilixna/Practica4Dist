// Programa para la aplicacion Client
import java.rmi.*;
import java.util.*;

public class Cliente_RMI {
    public static void main(String[] args) throws Exception
    {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                // User Menu
                System.out.println("\nCliente de Consultora de Datos...");
                System.out.println("...realiza las Operaciones en un Servidor Remoto");
                System.out.println("1.Consultar Datos dado el CI\n2.Consultar todos los Datos Registrados\n3.Salir");
                System.out.println("Ingrese su eleccion:");
                int opt = sc.nextInt();
                if (opt == 3) {
                    break;
                }
                
                switch (opt) {
                case 1:
                    System.out.println("--> La accion escogida fue Consultar Datos dado el CI\n");
                    break;
                case 2:
                    System.out.println("-->  La accion escogida fue Consultar todos los Datos Registrados");
                    break;
                }
                
                switch (opt) {
                case 1:
                    // lookup method to find reference of remote
                    // object
                    System.out.println("Ingrese el CI:");
                    String ci = sc.next();

                    ObtenerDatosInterface obje = (ObtenerDatosInterface)Naming.lookup("ADD");
                    String dato = obje.obtenerPorCI(ci);

                    System.out.println(dato);
                    
                    break;
                case 2:
                    ObtenerDatosInterface obj = (ObtenerDatosInterface)Naming.lookup("ADD");
                    List<String> listaDatos = obj.obtenerTodos();
                    
                    ListIterator<String> iterador = listaDatos.listIterator();

                    while (iterador.hasNext()){
                        System.out.println(iterador.next());
                    };

                    //MostrarDatosInterface obje1 = (MostrarDatosInterface)Naming.lookup("ADD");
                    //obje1.mostrarDatos(listaDatos);

                    break;
                }
            }
        }
    }
}
