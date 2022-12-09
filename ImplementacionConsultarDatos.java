// Programa Java que implementa las Interfaces: AddInterface, SubInterface, MulInterface, y DivInterface
import java.io.File;
import java.io.IOException;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
  
public class ImplementacionConsultarDatos extends UnicastRemoteObject
    implements ObtenerDatosInterface, MostrarDatosInterface {
  
    // Default constructor to throw RemoteException from its parent constructor
    public ImplementacionConsultarDatos() throws Exception { super(); };
  
    // Implementacion de las funciones para la consultora de datos remota

    public List<String> obtenerTodos() {
        String nombreArchivo = "bd.txt";
        List<String> listaDatos = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(nombreArchivo));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                listaDatos.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDatos;
    };
    
    public String  obtenerPorCI(String ci) {
        String nombreArchivo = "bd.txt";
        String dato = "";
        String ciComparado = "";

        try {
            Scanner sc = new Scanner(new File(nombreArchivo));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                dato = line;
                String[] partes = line.split("\\,");
                ciComparado= partes[0];

                if (ci.equals(ciComparado)) {
                    return dato;
                } 
            }
        } catch (IOException e) {
            e.printStackTrace();
        };

        String error = "No se encontro alguna persona que tuviera una cedula que coincidiera con la cedula agregada";
        return  error;
    };

    public void mostrarDatos(List<String> listaDatos) {
        ListIterator<String> iterador = listaDatos.listIterator();

        while (iterador.hasNext()){
            System.out.println(iterador.next());
        };
    };
}
