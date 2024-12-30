package Modelo;

import java.io.*;
import Mensaje.*;

public class MascotaListaEnlazada implements Serializable {

    //Atributos
    private MascotaNodo ini;
    private MascotaNodo fin;

    //Metodo de la clase
    public MascotaListaEnlazada() {
        ini = null;
        fin = null;
    }

    //Metodo para agregar al final
    public void AgregarNodoFinal(MascotaNodo nuevo) {
        if (ini == null && fin == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            fin.sig = nuevo;
        }
        fin = nuevo;
        fin.sig = null;
    }

    //Metodo para actualizar una mascota
    public void ActualizarMascota(MascotaNodo actual, Mascota actualizado) {
        actual.mas = actualizado;
    }

    //Metodo para eliminar una mascota
    public void EliminarMascota(MascotaNodo actual) {
        MascotaNodo anterior = ini;
        while (anterior.sig != actual && anterior.sig != null) {
            anterior = anterior.sig;
        }
        if (actual != null) {
            if (ini == actual) {
                ini = actual.sig;
            } else {
                anterior.sig = actual.sig;
            }
        }
    }

    //Metodo de busca una mascota por su nombre
    public MascotaNodo BuscarMascota(String nombre) {
        MascotaNodo aux = ini;
        while (aux != null && !nombre.equalsIgnoreCase(aux.mas.getNombre())) {
            aux = aux.sig;
        }
        return aux;
    }
    
    //Metodo de busca una mascota por nombre del dueño
    public MascotaNodo BuscarMascotaDueño(String nombreDueño) {
        MascotaNodo aux = ini;
        while (aux != null && !nombreDueño.equalsIgnoreCase(aux.mas.getDueño())) {
            aux = aux.sig;
        }
        return aux;
    }
    
    //Metodo para guardar datos en un archivo binario
    public static void GuardarEnArchivo(MascotaListaEnlazada Lista) {
        try {
          FileOutputStream fos =  new FileOutputStream("DatosMascotas.bin");
          ObjectOutputStream oos =  new ObjectOutputStream(fos);
          oos.writeObject(Lista);
          oos.close();
        } catch(Exception ex) {
            Mensaje.Error("Error, no se puede guardar " + ex, "Error al guardar");
        }
    }
    
    //Metodo para recuperar los datos del archivo binario
    public static MascotaListaEnlazada RecuperarDeArchivo() {
        MascotaListaEnlazada Lista =  new MascotaListaEnlazada();
     try{
          FileInputStream fis =  new FileInputStream("DatosMascotas.bin");
          ObjectInputStream ois =  new ObjectInputStream(fis);
          Lista = (MascotaListaEnlazada) ois.readObject();
          ois.close();
      }catch(Exception ex){
          Mensaje.Error("Error no se puede recuperar " + ex, "Error al recuperar");
      }
     return Lista;
    }
    
    //Getters y Setters
    public MascotaNodo getIni() { return ini; }
    public void setIni(MascotaNodo ini) { this.ini = ini; }
    public MascotaNodo getFin() { return fin; }
    public void setFin(MascotaNodo fin) { this.fin = fin; }
    
    // Método de ordenamiento recursivo MergeSort
    public void ordenarPorNombre() {
        ini = mergeSort(ini);
        MascotaNodo temp = ini;
        while (temp != null && temp.sig != null) {
            temp = temp.sig;
        }
        fin = temp;
    }

    // Función recursiva para realizar el merge sort
    private MascotaNodo mergeSort(MascotaNodo head) {
        if (head == null || head.sig == null) {
            return head;
        }
        MascotaNodo[] halves = dividirLista(head);
        MascotaNodo left = mergeSort(halves[0]);
        MascotaNodo right = mergeSort(halves[1]);
        return merge(left, right);
    }

    // Función para dividir la lista en dos mitades
    private MascotaNodo[] dividirLista(MascotaNodo head) {
        MascotaNodo slow = head;
        MascotaNodo fast = head.sig;
        while (fast != null && fast.sig != null) {
            slow = slow.sig;
            fast = fast.sig.sig;
        }
        MascotaNodo mid = slow.sig;
        slow.sig = null;
        return new MascotaNodo[] { head, mid };
    }

    // Función para combinar dos listas ordenadas
    private MascotaNodo merge(MascotaNodo left, MascotaNodo right) {
        MascotaNodo dummy = new MascotaNodo(new Mascota());
        MascotaNodo current = dummy;
        while (left != null && right != null) {
            if (left.mas.getNombre().compareToIgnoreCase(right.mas.getNombre()) <= 0) {
                current.sig = left;
                left = left.sig;
            } else {
                current.sig = right;
                right = right.sig;
            }
            current = current.sig;
        }
        current.sig = (left != null) ? left : right;
        return dummy.sig;
    }
    
}
