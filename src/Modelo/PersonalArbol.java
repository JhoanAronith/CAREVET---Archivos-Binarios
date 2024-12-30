package Modelo;

import java.io.*;
import javax.swing.table.*;
import Mensaje.*;

public class PersonalArbol implements Serializable {

    //Atributos
    private PersonalNodo Raiz;
    
    //Constructor vacio
    public PersonalArbol() {
        Raiz = null;
    }
    
    //metodo que crea un nodo
    public PersonalNodo getRaiz() {
        return Raiz;
    }
    
    //Metodo que iguala Raiz
    public void setRaiz(PersonalNodo Raiz) {
        this.Raiz = Raiz;
    }

    //Metodo que agrega un personal
    public PersonalNodo Agregar(PersonalNodo Nodo, Personal elemento) {
        if (Nodo == null) {
            PersonalNodo Nuevo = new PersonalNodo(elemento);
            return Nuevo;
        } else {
            if (elemento.getDni().compareTo(Nodo.getElemento().getDni()) > 0) {
                Nodo.setDer(Agregar(Nodo.getDer(), elemento));
            } else {
                Nodo.setIzq(Agregar(Nodo.getIzq(), elemento));
            }
        }
        return Nodo;
    }

    //metodo que elimina un personal
    public PersonalNodo Eliminar(PersonalNodo Nodo, String dni) {
        if (Nodo == null) {
            return null;
        }
        if (dni.compareTo(Nodo.getElemento().getDni()) < 0) {
            Nodo.setIzq(Eliminar(Nodo.getIzq(), dni));
        } else if (dni.compareTo(Nodo.getElemento().getDni()) > 0) {
            Nodo.setDer(Eliminar(Nodo.getDer(), dni));
        } else {
            if (Nodo.getIzq() == null) {
                return Nodo.getDer();
            } else if (Nodo.getDer() == null) {
                return Nodo.getIzq();
            }
            Nodo.setElemento(MinValue(Nodo.getDer()));
            Nodo.setDer(Eliminar(Nodo.getDer(), Nodo.getElemento().getDni()));
        }
        return Nodo;
    }

    //Metodo que actualiza un personal
    public void Actualizar(PersonalNodo Nodo, Personal actualizado) {
        if (Nodo == null) {
            return;
        }
        if (actualizado.getDni().compareTo(Nodo.getElemento().getDni()) < 0) {
            Actualizar(Nodo.getIzq(), actualizado);
        } else if (actualizado.getDni().compareTo(Nodo.getElemento().getDni()) > 0) {
            Actualizar(Nodo.getDer(), actualizado);
        } else {
            Nodo.setElemento(actualizado);
        }
    }
    
    //metodo que calcula el minvalue
    private Personal MinValue(PersonalNodo Nodo) {
        Personal minv = Nodo.getElemento();
        while (Nodo.getIzq() != null) {
            minv = Nodo.getIzq().getElemento();
            Nodo = Nodo.getIzq();
        }
        return minv;
    }
    
    //metodo para mostrar Datos
    public void MostrarDatos(PersonalNodo Nodo, DefaultTableModel modelo) {
        if (Nodo != null) {
            MostrarDatos(Nodo.getIzq(), modelo);
            modelo.addRow(Nodo.getElemento().Registro(0));
            MostrarDatos(Nodo.getDer(), modelo);
        }
    }

    //metodo de busqueda por dni
    public PersonalNodo BuscarDni(String dni) {
        PersonalNodo aux = Raiz;
        while (aux != null) {
            if (aux.getElemento().getDni().startsWith(dni)) {
                return aux;
            } else {
                if (dni.compareToIgnoreCase(aux.getElemento().getDni()) > 0) {
                    aux = aux.getDer();
                } else {
                    aux = aux.getIzq();
                }
            }
        }
        return null;
    }

    //Metodo para guardar en archivo
    public static void GuardarEnArchivo(PersonalArbol arbol) {
        try {
            FileOutputStream fos = new FileOutputStream("DatosPersonales.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arbol);
            oos.close();
        } catch (Exception ex) {
            Mensaje.Error("No se puede guardar", "Error");
        }
    }

    //metodo para recuperar de archivo
    public static PersonalArbol RecuperarDeArchivo() {
        PersonalArbol arbol = new PersonalArbol();
        try {
            FileInputStream fis = new FileInputStream("DatosPersonales.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arbol = (PersonalArbol) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            Mensaje.Error("No se puede guardar", "Error");
        }
        return arbol;
    }

}
