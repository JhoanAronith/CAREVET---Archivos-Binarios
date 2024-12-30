package Proceso;

import Modelo.*;
import Vista.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProcesosForma05 {

    //Metodo que limpia las entradas de la vista
    public static void LimpiarEntradas(Forma05 f5) {
        f5.txtCodigo.setText("");
        f5.txtNomCliente.setText("");
        f5.cbxMascota.setSelectedIndex(0);
        f5.txtNomPersonal.setText("");
        f5.cbxServicio.setSelectedIndex(0);
    }

    //Metodo que agrega datos al cbxServicio
    public static void AgregarServicio(JComboBox<String> cbx) {
        ServicioArreglo servicioArreglo = new ServicioArreglo();
        servicioArreglo.RecuperarDeArchivo();
        servicioArreglo.ActualizarCantidadSer();
        Servicio[] listaServicios = servicioArreglo.getLista();
        for (int i = 0; i < ServicioArreglo.getCantSer(); i++) {
            cbx.addItem(listaServicios[i].getNombre());
        }
    }

    //Metodo que carga mascota segun el cliente
    public static void MostrarMascotasEnComboBox(JComboBox<String> comboBox, MascotaListaEnlazada ListaMascota, String nombreDueño) {
        comboBox.removeAllItems();
        MascotaNodo actual = ListaMascota.getIni();
        while (actual != null) {
            Mascota mas = actual.getMas();
            if (mas.getDueño().equalsIgnoreCase(nombreDueño)) {
                comboBox.addItem(mas.getNombre());
            }
            actual = actual.getSig();
        }
    }

    //Metodo que lee una cita
    public static Cita LeerCita(Forma05 f5) {
        Cita cita = new Cita();
        cita.setCodigo(f5.txtCodigo.getText());

        Date fechaCompleta = f5.txtFecha.getDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        String fechaFormateada = formatoFecha.format(fechaCompleta);
        cita.setFechaHora(fechaFormateada);

        cita.setNomCliente(f5.txtNomCliente.getText());
        cita.setNomMascota(f5.cbxMascota.getSelectedItem().toString());
        cita.setNomServicio(f5.cbxServicio.getSelectedItem().toString());
        cita.setNomPersonal(f5.txtNomPersonal.getText());
        return cita;
    }

    //Metodo que muestra los datos en una tabla
//    public static void MostrarDatos(Forma05 f5, CitaHashTable lista) {
//        String titulos[] = {"Num", "Codigo", "Fecha y Hora", "Cliente", "Mascota", "Servicio", "Personal"};
//        DefaultTableModel mt = new DefaultTableModel(null, titulos);
//        f5.tblCitas.setModel(mt);
//        int cont = 0;
//        Enumeration<Cita> enumera = lista.getLista().elements();
//        while (enumera.hasMoreElements()) {
//            cont++;
//            mt.addRow(enumera.nextElement().Registro(cont));
//        }
//    }
    public static void MostrarDatos(Forma05 f5, CitaHashTable lista) {
        String titulos[] = {"Num", "Codigo", "Fecha y Hora", "Cliente", "Mascota", "Servicio", "Personal"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        f5.tblCitas.setModel(mt);
        int cont = 0;
        Enumeration<Cita> enumera = lista.getLista().elements();
        while (enumera.hasMoreElements()) {
            cont++;
            mt.addRow(enumera.nextElement().Registro(cont));
        }
    }

    //metodo que cambia el estado de una cita en cancelada
    public static void CancelarCita(Cita cita) {
        cita.setCancelada(true);
    }

    //Ordenamiento
    // Método para ordenar las citas por código usando QuickSort y devolver una Hashtable ordenada
    public static CitaHashTable obtenerCitasOrdenadasPorCodigo(CitaHashTable citaHashTable) {
        // Extraer las citas de la Hashtable a una lista de entradas
        List<Map.Entry<String, Cita>> entryList = new ArrayList<>(citaHashTable.getLista().entrySet());

        // Ordenar la lista usando QuickSort
        quickSort(entryList, 0, entryList.size() - 1);

        // Crear una nueva Hashtable ordenada
        CitaHashTable sortedCitaHashTable = new CitaHashTable();
        for (Map.Entry<String, Cita> entry : entryList) {
            sortedCitaHashTable.AgregarCita(entry.getValue());
        }

        return sortedCitaHashTable;
    }

    // Función principal de QuickSort
    private static void quickSort(List<Map.Entry<String, Cita>> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    // Función para particionar la lista
    private static int partition(List<Map.Entry<String, Cita>> list, int low, int high) {
        // Elegir el último elemento como pivote
        String pivotCode = list.get(high).getKey();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            String currentCode = list.get(j).getKey();
            if (currentCode.compareTo(pivotCode) < 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

}
