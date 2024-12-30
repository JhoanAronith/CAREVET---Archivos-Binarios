package Modelo;

import java.io.*;
import java.util.*;
import Mensaje.*;

public class ClienteArrayList implements Serializable {

    //ArrayLista de obejtos Cliente
    public ArrayList<Cliente> Lista;

    //Constructor
    public ClienteArrayList() {
        Lista = new ArrayList();
    }

    //Método para agregar un cliente
    public void AgregarCliente(Cliente cli) {
        Lista.add(cli);
    }
    
    //Metodo que recupera un cliente
    public Cliente RecuperarCliente(int posicion) {
        return Lista.get(posicion);
    }
    
    //Metodo que actualiza un cliente
    public void ActualizarCliente(int posicion, Cliente actualizado) {
        Lista.set(posicion, actualizado);
    }

    //Metodo para eliminar un cliente
    public void EliminarCliente(int posicion) {
        Lista.remove(posicion);
    }
    
    //Método para guardar la lista en un archivo Binario
    public void GuardarEnBinario() {
        try {
            FileOutputStream fos = new FileOutputStream("DatosClientes.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        } catch (Exception ex) {
            Mensaje.Error("Error al guardar en archivo " + ex, "Error al guardar");
        }
    }

    //Método para recuperar los datos del archivo Binario
    public void RecuperararDeArchivo() {
        try {
            FileInputStream fis = new FileInputStream("DatosClientes.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (ArrayList<Cliente>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            Mensaje.Error("Error al recuperar en archivo " + ex, "Error al recuperar");
        }
    }

}
