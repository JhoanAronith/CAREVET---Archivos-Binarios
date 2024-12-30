package Proceso;

import Vista.*;
import Modelo.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProcesosForma01 {

    //Metodo que lees los datos del Cliente
    public static Cliente LeerCliente(Forma01 f1) {
        Cliente cli = new Cliente();
        cli.setNombre(f1.txtNombre.getText());
        cli.setDni(f1.txtDni.getText());
        cli.setTelefono(f1.txtTelefono.getText());
        cli.setCorreo(f1.txtCorreo.getText());
        cli.setDireccion(f1.txtDireccion.getText());
        return cli;
    }

    //Metod que limpia las entradas
    public static void LimpiarEntradas(Forma01 f1) {
        f1.txtNombre.setText("");
        f1.txtDni.setText("");
        f1.txtTelefono.setText("");
        f1.txtCorreo.setText("");
        f1.txtDireccion.setText("");
    }

    //Metodo que muestra los datos en la tabla
    public static void MostrarDatos(JTable tabla, ArrayList<Cliente> a) {
        String titulos[] = {"Num", "Nombre", "DNI", "Telefono", "Correo", "Direccion"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        tabla.setModel(mt);
        for (int i = 0; i < a.size(); i++) {
            mt.addRow(a.get(i).Registro(i + 1));
        }
    }

    //Metodo de busqueda secuencial recursivo
    public static int BuscarPorDni(ArrayList<Cliente> vector, String dni, int index) {
        if (index >= vector.size()) {
            return -1;
        }
        if (dni.equalsIgnoreCase(vector.get(index).getDni())) {
            return index;
        }
        return BuscarPorDni(vector, dni, index + 1);
    }
    
    //Metodo de busqueda binaria 
    public int BuscarPorNombre(ArrayList<Cliente> vector,String elemento){
      int n=vector.size();
      int inferior=0,superior=n-1;
      while(inferior<=superior){
          int centro=(inferior+superior)/2;
          if(elemento.equalsIgnoreCase(vector.get(centro).getNombre())){
              return centro;
          }else{
              if(elemento.compareTo(vector.get(centro).getNombre())<0)
                  superior=centro-1;
              else 
                  inferior=centro+1;
          }
      }   
      return -1; 
  }

    // Metodo para mostrar las mascotas de un dueño específico
    public static void MostrarMascotas(JTable tabla, MascotaListaEnlazada ListaMascota, String nombreDueño) {
        String titulos[] = {"Num", "Nombre", "Especie"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        MascotaNodo actual = ListaMascota.getIni();
        int numeracion = 1;

        while (actual != null) {
            Mascota mas = actual.getMas();
            if (mas.getDueño().equalsIgnoreCase(nombreDueño)) {
                String fila[] = {String.valueOf(numeracion), mas.getNombre(), mas.getEspecie()};
                modelo.addRow(fila);
                numeracion++;
            }
            actual = actual.getSig();
        }

        tabla.setModel(modelo);
    }

    //Metodo recursivo de ordenamiento inserción
    public static ArrayList<Cliente> OrdenPorNombresASC(ArrayList<Cliente> a) {
        return ordenPorNombresASCRecursivo(a, 1);
    }

    //Metodo recursivo de ordenamiento inserción
    private static ArrayList<Cliente> ordenPorNombresASCRecursivo(ArrayList<Cliente> a, int index) {
        if (index >= a.size()) {
            return a;
        }
        Cliente value = a.get(index);
        int j = index;
        while (j > 0 && a.get(j - 1).getNombre().compareTo(value.getNombre()) > 0) {
            a.set(j, a.get(j - 1));
            j--;
        }
        a.set(j, value);
        return ordenPorNombresASCRecursivo(a, index + 1);
    }

}
