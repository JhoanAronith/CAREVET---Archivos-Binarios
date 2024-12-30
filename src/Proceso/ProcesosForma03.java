package Proceso;

import Modelo.*;
import Vista.*;
import javax.swing.table.*;

public class ProcesosForma03 {

    //Metodo que limpia las entradas de la vista
    public static void LimpiarEntradas(Forma03 f3) {
        f3.txtBuscar.setText("");
        f3.txtCosto.setText("");
        f3.txtDescripcion.setText("");
        f3.txtDuracion.setText("");
        f3.txtNombre.setText("");
        f3.txtCodigo.setText("");
    }

    //Metodo que lee un servicio
    public static Servicio LeerServicio(Forma03 f3) {
        Servicio ser = new Servicio();
        ser.setNombre(f3.txtNombre.getText());
        ser.setCodigo(f3.txtCodigo.getText());
        ser.setCosto(f3.txtCosto.getText());
        ser.setDescripcion(f3.txtDescripcion.getText());
        ser.setDuracion(f3.txtDuracion.getText());
        return ser;
    }

    //Metodo para mostrar en tabla
    public static void MostrarEnTabla(Forma03 f3, Servicio[] a) {
        String titulos[] = {"Num", "Codigo", "Nombre", "Costo", "Descripcion", "Duracion"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        f3.tblServicios.setModel(mt);
        for (int i = 0;
                i < ServicioArreglo.getCantSer();
                i++) {
            mt.addRow(a[i].Registro(i + 1));
        }
    }

    //método inicializa los parámetros inferior y superior y llama al método recursivo.
    public static int BusquedaBinariaPorCodigo(Servicio[] vector, String codbuscado) {
        return BusquedaBinariaPorCodigoRec(vector, codbuscado, 0, ServicioArreglo.getCantSer() - 1);
    }

    //metodo  de busqueda binaria recursiva
    private static int BusquedaBinariaPorCodigoRec(Servicio[] vector, String codbuscado, int inferior, int superior) {
        if (inferior > superior) {
            return -1;
        }
        int centro = (inferior + superior) / 2;
        if (codbuscado.equalsIgnoreCase(vector[centro].getCodigo())) {
            return centro;
        } else if (codbuscado.compareToIgnoreCase(vector[centro].getCodigo()) < 0) {
            return BusquedaBinariaPorCodigoRec(vector, codbuscado, inferior, centro - 1);
        } else {
            return BusquedaBinariaPorCodigoRec(vector, codbuscado, centro + 1, superior);
        }
    }

    //Método de ordenamiento por inserción
    public static Servicio[] OrdenarPorCodigoASC(Servicio[] a) {
        if (a == null) {
            return null;
        }
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Servicio value = a[i];
            if (value == null) {
                continue;
            }
            int j = i;
            while (j > 0 && a[j - 1] != null && a[j - 1].getCodigo().compareTo(value.getCodigo()) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = value;
        }
        return a;
    }
    
    //Método de ordenamiento por inserción
    public static Servicio[] OrdenarPorCodigoDES(Servicio[] a) {
        if (a == null) {
            return null;
        }
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Servicio value = a[i];
            if (value == null) {
                continue;
            }
            int j = i;
            while (j > 0 && a[j - 1] != null && a[j - 1].getCodigo().compareTo(value.getCodigo()) < 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = value;
        }
        return a;
    }
    
}
