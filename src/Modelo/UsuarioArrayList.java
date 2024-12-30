package Modelo;

import Mensaje.*;
import java.io.*;
import java.util.*;

public class UsuarioArrayList implements Serializable {

    //ArrayLista de objetos Usuario
    public ArrayList<Usuario> Lista;

    //Constructor
    public UsuarioArrayList() {
        Lista = new ArrayList();
    }

    //Metodo para agregar un usuario
    public void AgregarUsuario(Usuario user) {
        Lista.add(user);
    }

    //Metodo que recuperar a un usuario
    public Usuario RecuperarUsuario(int posicion) {
        return Lista.get(posicion);
    }

    //Metodo guardar usuario en un archivo binario
    public void GuardarEnBinario() {
        try {
            FileOutputStream fos = new FileOutputStream("DatosUsuario.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        } catch (Exception ex) {
            Mensaje.Error("Error al guardar en archivo " + ex, "Error al guardar");
        }
    }

    //Método para recuperar los usuarios del archivo Binario
    public void RecuperararDeArchivo() {
        try {
            FileInputStream fis = new FileInputStream("DatosUsuario.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (ArrayList<Usuario>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            Mensaje.Error("Error al recuperar en archivo " + ex, "Error al recuperar");
        }
    }

}
